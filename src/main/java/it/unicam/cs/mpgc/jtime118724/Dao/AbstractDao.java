package it.unicam.cs.mpgc.jtime118724.Dao;

import it.unicam.cs.mpgc.jtime118724.Util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class AbstractDao<T> implements IDao<T>{


    private final Class<T> entityClass;
    private final String tableName;

    public AbstractDao(Class<T> entityClass) {
        this.entityClass = entityClass;
        this.tableName = entityClass.getSimpleName().toUpperCase();
    }

    private void operationTransaction( Consumer<EntityManager> operation ) {
        EntityTransaction tx = null;
        try (EntityManager em = JpaUtil.getEntityManager()){
            tx = em.getTransaction();
            tx.begin();
            operation.accept(em);
            tx.commit();
        } catch( Exception e ) {
            if( tx != null &&  tx.isActive() ) {
                tx.rollback();
            }
            throw new RuntimeException("Error during the operation: "+ e.getMessage());
        }
    }

    private <R> R executeQuery (Function<EntityManager, R> query) {
        try (EntityManager em = JpaUtil.getEntityManager()) {
            return query.apply(em);
        }
    }

    @Override
    public void save(T entity) {
        operationTransaction(em -> em.persist(entity));
    }

    @Override
    public void update(T entity) {
        operationTransaction(em -> em.merge(entity));
    }

    @Override
    public void delete(long id) {
        operationTransaction(em -> {
            T entity = em.find(entityClass, id);
            if(entity != null) em.remove(entity);
        });
    }

    @Override
    public T getById(long id) {
        return executeQuery(em -> em.find(entityClass, id));
    }

    @Override
    public List<T> getAll() {
        return executeQuery(em -> em.createNamedQuery(entityClass.getSimpleName(), entityClass).getResultList());
    }

    public void clearAndResetIdentity() {
        operationTransaction(em -> {
            em.createNativeQuery("DELETE FROM " + this.tableName).executeUpdate();// mi cancella tutte le righe della tabella
            em.createNativeQuery("ALTER TABLE " + this.tableName + " ALTER COLUMN ID RESTART WITH 1").executeUpdate(); // fa ripartire l'autoincremento del valore dell'id a 1
            //em.createNativeQuery("ALTER TABLE " + this.tableName + " ALTER COLUMN ID RESTART WITH 1").executeUpdate();
        });
    }

}
