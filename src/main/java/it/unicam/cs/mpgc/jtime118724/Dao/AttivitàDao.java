package it.unicam.cs.mpgc.jtime118724.Dao;

import it.unicam.cs.mpgc.jtime118724.Model.Entities.Attivita;

public class AttivitàDao extends AbstractDao<Attivita>{

    public AttivitàDao(){
        super(Attivita.class, Attivita.class.getSimpleName());
    }
}
