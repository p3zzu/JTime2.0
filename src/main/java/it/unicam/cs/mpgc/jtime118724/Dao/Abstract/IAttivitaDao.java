package it.unicam.cs.mpgc.jtime118724.Dao.Abstract;

import it.unicam.cs.mpgc.jtime118724.Model.Entities.Attivita;

import java.util.List;

public interface IAttivitaDao extends IDao<Attivita> {

    public List<Attivita> getListaAttivitaNonTerminate();

    public List<Attivita> getListaAttivitaTerminate();
}
