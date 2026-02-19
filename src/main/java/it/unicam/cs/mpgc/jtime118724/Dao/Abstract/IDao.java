package it.unicam.cs.mpgc.jtime118724.Dao.Abstract;

import it.unicam.cs.mpgc.jtime118724.Model.Entities.Stato;

import java.util.List;



public interface IDao <T>{

    void save(T entity);

    T getById(long id);

    List<T> getAll();

    List<T> getListaByStato(Stato stato);

    void update(T entity);

    void delete(long id);

    void clearAndResetIdentity();
}
