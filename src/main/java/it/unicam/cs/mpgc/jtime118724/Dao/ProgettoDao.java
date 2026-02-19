package it.unicam.cs.mpgc.jtime118724.Dao;

import it.unicam.cs.mpgc.jtime118724.Dao.Abstract.IProgettoDao;
import it.unicam.cs.mpgc.jtime118724.Model.Entities.Progetto;
import it.unicam.cs.mpgc.jtime118724.Model.Entities.Stato;

import java.util.List;

public class ProgettoDao extends AbstractDao <Progetto> implements IProgettoDao {

    public ProgettoDao() {
        super(Progetto.class);
    }

    /**
     * @return
     */
    @Override
    public List<Progetto> getListaProgettiNonCompletati() {
        return getListaByStato(Stato.NON_COMPLETATO);

    }

    /**
     * @return
     */
    @Override
    public List<Progetto> getListaProgettiCompletati() {
        return getListaByStato(Stato.COMPLETATO);
    }
}
