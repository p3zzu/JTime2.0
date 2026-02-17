package it.unicam.cs.mpgc.jtime118724.Dao;

public class Dao <T> extends AbstractDao<T> {

    public Dao(Class<T> entityClass) {
        super(entityClass);
    }
}
