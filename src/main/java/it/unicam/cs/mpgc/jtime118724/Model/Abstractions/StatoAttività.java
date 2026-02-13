package it.unicam.cs.mpgc.jtime118724.Model.Abstractions;

public enum StatoAttività {
    TERMINATA,
    NON_TERMINATA;

    public StatoAttività cambiaStato(){
        return switch(this){
            case NON_TERMINATA -> TERMINATA;
            case TERMINATA -> NON_TERMINATA;
        };
    }
}
