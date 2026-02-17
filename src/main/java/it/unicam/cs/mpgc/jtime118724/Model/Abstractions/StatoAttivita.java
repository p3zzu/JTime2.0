package it.unicam.cs.mpgc.jtime118724.Model.Abstractions;

public enum StatoAttivita {
    TERMINATA,
    NON_TERMINATA;

    public StatoAttivita cambiaStato(){
        return switch(this){
            case NON_TERMINATA -> TERMINATA;
            case TERMINATA -> NON_TERMINATA;
        };
    }
}
