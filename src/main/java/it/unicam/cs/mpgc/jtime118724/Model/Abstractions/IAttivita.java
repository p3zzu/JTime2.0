package it.unicam.cs.mpgc.jtime118724.Model.Abstractions;

import it.unicam.cs.mpgc.jtime118724.Model.Entities.Progetto;
import it.unicam.cs.mpgc.jtime118724.Model.Entities.Stato;

public interface IAttivita {
    Long getId();

    String getNome();

    String getDescrizione();

    java.time.Duration getTempo_stimato();

    java.time.Duration getTempo_effettivo();

    java.time.LocalDate getData_pianificata();

    Progetto getProgetto();

    Stato getStato();

    void setId(Long id);

    void setNome(String nome);

    void setDescrizione(String descrizione);

    void setTempo_stimato(java.time.Duration tempo_stimato);

    void setTempo_effettivo(java.time.Duration tempo_effettivo);

    void setData_pianificata(java.time.LocalDate data_pianificata);

    void setProgetto(Progetto progetto);

    void setStato(Stato stato);
}
