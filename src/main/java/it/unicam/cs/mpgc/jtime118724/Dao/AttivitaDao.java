package it.unicam.cs.mpgc.jtime118724.Dao;

import it.unicam.cs.mpgc.jtime118724.Dao.Abstract.IAttivitaDao;
import it.unicam.cs.mpgc.jtime118724.Model.Entities.Attivita;
import it.unicam.cs.mpgc.jtime118724.Model.Entities.Stato;

import java.util.List;

public class AttivitaDao extends AbstractDao <Attivita> implements IAttivitaDao {

    public AttivitaDao() {
        super(Attivita.class);
    }

    /*
    createNativeQuery --> sql
    createQuery --> jpql
     */

    public List<Attivita> getListaAttivitaNonTerminate(){
        return getListaByStato(Stato.NON_TERMINATA);
    }

    public List<Attivita> getListaAttivitaTerminate(){
        return getListaByStato(Stato.TERMINATA);
    }

}
