package it.unicam.cs.mpgc.jtime118724.Model.Abstractions;

import it.unicam.cs.mpgc.jtime118724.Model.Entities.Progetto;
import it.unicam.cs.mpgc.jtime118724.Model.Entities.Stato;

public interface IAttivita {
    Long getId();

    String getNome();

    String getDescrizione();

    java.time.Duration getTempoStimato();

    java.time.Duration getTempoEffettivo();

    java.time.LocalDate getDataPianificata();

    Progetto getProgetto();

    Stato getStato();



    void setId(Long id);

    void setNome(String nome);

    void setDescrizione(String descrizione);

    void setTempoStimato(java.time.Duration tempo_stimato);

    void setTempoEffettivo(java.time.Duration tempo_effettivo);

    void setDataPianificata(java.time.LocalDate data_pianificata);

    void setProgetto(Progetto progetto);

    void setStato(Stato stato);
}
