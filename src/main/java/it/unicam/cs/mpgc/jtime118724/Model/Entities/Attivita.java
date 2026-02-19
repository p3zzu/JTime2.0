package it.unicam.cs.mpgc.jtime118724.Model.Entities;

import it.unicam.cs.mpgc.jtime118724.Model.Abstractions.IAttivita;
import it.unicam.cs.mpgc.jtime118724.Util.ConvertitoreLatoPersistenza;
import jakarta.persistence.*;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "ATTIVITA")
//@NamedQuery(name = "Attivita", query = "SELECT a FROM Attivita a")
public class Attivita implements IAttivita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descrizione;

    @Convert(converter = ConvertitoreLatoPersistenza.class)
    private Duration tempo_stimato;

    @Convert(converter = ConvertitoreLatoPersistenza.class)
    private Duration tempo_effettivo;

    private LocalDate data_pianificata;

    private LocalDate data_creazione;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROGETTO_ID")
    private Progetto progetto;

    @Enumerated(EnumType.STRING)
    private Stato stato;

    protected Attivita() { }

    public Attivita(String nome, String descrizione, Duration t_s) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.tempo_stimato = t_s;
        this.stato = Stato.NON_TERMINATA;
        this.data_creazione = LocalDate.now();
    }

    public void setTempo_effettivo(Duration t_s) {
        this.tempo_effettivo = t_s;
        this.stato = this.stato.cambiaStato();
    }

    public String toString(){
        return this.nome  + " data creazione: " + this.data_creazione;
    }
}
