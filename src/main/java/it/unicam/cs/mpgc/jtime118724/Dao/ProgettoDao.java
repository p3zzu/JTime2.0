package it.unicam.cs.mpgc.jtime118724.Dao;

import it.unicam.cs.mpgc.jtime118724.Model.Entities.Progetto;

public class ProgettoDao extends AbstractDao <Progetto>{

    public ProgettoDao(){
        super(Progetto.class, Progetto.class.getSimpleName());
    }
}
