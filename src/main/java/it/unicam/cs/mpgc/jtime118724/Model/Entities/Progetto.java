package it.unicam.cs.mpgc.jtime118724.Model.Entities;

import it.unicam.cs.mpgc.jtime118724.Model.Abstractions.StatoAttivita;
import it.unicam.cs.mpgc.jtime118724.Model.Abstractions.StatoProgetto;
import jakarta.persistence.*;
import lombok.Data;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "PROGETTO")
public class Progetto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descrizione;

    /*
    Impostati a Zero perchè sennò alla prima chiamata di add/remove esce fuori un NullPointException.
     */
    private Duration tempo_tot_stimato = Duration.ZERO; // somma dei tempi stimati dalle attività

    private Duration tempo_tot_attuale = Duration.ZERO; // somma dei tempi attuali delle attività

    @OneToMany(mappedBy = "progetto",cascade = CascadeType.ALL)
    private List<Attivita> listaAttivita;

    @Enumerated(EnumType.STRING)
    private StatoProgetto stato;

    protected Progetto(){ }

    public Progetto(String name, String descrizione) {
        this.nome = name;
        this.descrizione = descrizione;
        this.listaAttivita = new ArrayList<>();
        this.stato = StatoProgetto.NON_COMPLETATO;
    }

    public void addAttivita(Attivita attivita){
        boolean flag = true;
        this.listaAttivita.add(attivita);
        calcoloValoreTempoTotStimato(attivita, flag);
        attivita.setProgetto(this);
    }

    public void removeAttivita(Attivita attivita){
        Boolean flag = false;
        this.listaAttivita.remove(attivita);
        calcoloValoreTempoTotStimato(attivita, flag);
        attivita.setProgetto(null);
    }

    private void calcoloValoreTempoTotStimato(Attivita attivita, Boolean flag){
        if(flag) this.tempo_tot_stimato = this.tempo_tot_stimato.plus(attivita.getTempo_stimato());
        else this.tempo_tot_stimato = this.tempo_tot_stimato.minus(attivita.getTempo_stimato());
    }

    private void completato(){
       this.stato = this.stato.cambiaStato();
    }

    public void controlloStatoProgetto(){
        boolean flag = false;
        for(Attivita attivita : this.listaAttivita){
            if(attivita.getStato() == StatoAttivita.NON_TERMINATA)flag = true;
        }
        if(!flag) completato();
    }

}
