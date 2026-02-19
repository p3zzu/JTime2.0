package it.unicam.cs.mpgc.jtime118724.Dao.Abstract;

import it.unicam.cs.mpgc.jtime118724.Model.Entities.Progetto;

import java.util.List;

public interface IProgettoDao extends IDao<Progetto> {

    public List<Progetto> getListaProgettiNonCompletati();

    public List<Progetto> getListaProgettiCompletati();
}
