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
    private Duration tempoStimato;

    @Convert(converter = ConvertitoreLatoPersistenza.class)
    private  Duration tempoEffettivo;

    private LocalDate dataPianificata;

    private LocalDate dataCreazione;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROGETTO_ID")
    private Progetto progetto;

    @Enumerated(EnumType.STRING)
    private Stato stato;

    protected Attivita() { }

    public Attivita(String nome, String descrizione, Duration t_s) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.tempoStimato = t_s;
        this.stato = Stato.NON_TERMINATA;
        this.dataCreazione = LocalDate.now();
    }

    public void setTempoEffettivo(Duration t) {
        if (t == null) {
            throw new IllegalArgumentException("Il tempo effettivo non può essere null.");
        }
        if (this.tempoEffettivo != null) {
            throw new IllegalStateException("Il tempo effettivo è già stato impostato e non può essere modificato.");
        }
        if (t.isNegative() || t.isZero()) {
            throw new IllegalArgumentException("Il tempo effettivo deve essere > 0.");
        }

        this.tempoEffettivo = t;
        this.stato = this.stato.cambiaStato();
    }

}
