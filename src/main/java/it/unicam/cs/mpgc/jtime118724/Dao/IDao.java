package it.unicam.cs.mpgc.jtime118724.Dao;

import java.util.List;

public interface IDao <T>{
    /**
     * Salva la entità fornita all'interno del suo relativo archivio.
     * @param entity entità da salvare
     */
    void save(T entity);

    /**
     * Aggiorna la entità fornita all'interno del suo relativo archivio.
     * L'entità fornita deve già esistere.
     * Questo metodo applica le modifiche al record
     * esistente nel database.
     * @param entity entità da aggiornare
     */
    void update(T entity);

    /**
     * Elimina dal suo archivio l'entità corrisponde all'id passato come parametro
     * @param id associato all'entità da eliminare
     */
    void delete(long id);

    /**
     * Restituisce l'entità corrispondente all'id passato come parametro
     *
     * @param id associato all'entità richiesta in ritorno
     */
    T getById(long id);

    /**
     * Restituisce la lista di entity di tipo T
     * @return lista entity di tipo T
     */
    List<T> getAll();

    void clearAndResetIdentity();
}
