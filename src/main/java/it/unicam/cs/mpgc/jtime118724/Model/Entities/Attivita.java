package it.unicam.cs.mpgc.jtime118724.Model.Entities;

import it.unicam.cs.mpgc.jtime118724.Model.Abstractions.StatoAttività;
import it.unicam.cs.mpgc.jtime118724.Util.ConvertitoreDurationStringISO8610;
import jakarta.persistence.*;
import javafx.util.converter.LocalDateStringConverter;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Duration;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "ATTIVITA")
public class Attivita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descrizione;

    @Convert(converter = ConvertitoreDurationStringISO8610.class)
    private Duration tempo_stimato;

    @Convert(converter = ConvertitoreDurationStringISO8610.class)
    private Duration tempo_effettivo;

    private LocalDate data_pianificata;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROGETTO_ID")
    private Progetto progetto;

    private StatoAttività stato;

    protected Attivita() { }

    public Attivita(String nome, String descrizione, Duration t_s) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.tempo_stimato = t_s;
        this.stato = StatoAttività.NON_TERMINATA;
    }

}
