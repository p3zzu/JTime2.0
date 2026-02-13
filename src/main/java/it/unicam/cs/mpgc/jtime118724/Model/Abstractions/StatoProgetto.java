package it.unicam.cs.mpgc.jtime118724.Model.Abstractions;

import jdk.jshell.Snippet;

public enum StatoProgetto {
    COMPLETATO,
    NON_COMPLETATO;

    public StatoProgetto cambiaStato(){
         return switch(this){
             case NON_COMPLETATO -> COMPLETATO;
             case COMPLETATO -> NON_COMPLETATO;
         };
    }
}
