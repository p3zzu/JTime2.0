package it.unicam.cs.mpgc.jtime118724.Model.Entities;

public enum Stato {
    TERMINATA,
    NON_TERMINATA,
    COMPLETATO,
    NON_COMPLETATO;

    public Stato cambiaStato(){
        return switch(this){
            case NON_TERMINATA -> TERMINATA;
            case TERMINATA -> NON_TERMINATA;
            case NON_COMPLETATO -> COMPLETATO;
            case COMPLETATO -> NON_COMPLETATO;
        };
    }

}
