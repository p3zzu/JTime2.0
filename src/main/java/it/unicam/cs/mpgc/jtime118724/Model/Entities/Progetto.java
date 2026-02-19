package it.unicam.cs.mpgc.jtime118724.Model.Entities;

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

    private int numAttivitaCompletate;

    private int numAttivitaNonCompletate;

    @Enumerated(EnumType.STRING)
    private Stato stato;

    protected Progetto(){ }

    public Progetto(String name, String descrizione) {
        this.nome = name;
        this.descrizione = descrizione;
        this.listaAttivita = new ArrayList<>();
        this.stato = Stato.NON_COMPLETATO;
        this.numAttivitaCompletate = 0;
        this.numAttivitaNonCompletate = 0;
    }

    public void addAttivita(Attivita attivita){
        boolean flag = true;
        this.listaAttivita.add(attivita);
        calcoloValoreTempoTotStimato(attivita, flag);
        attivita.setProgetto(this);
        this.numAttivitaNonCompletate++;
    }

    public void removeAttivita(Attivita attivita){
        Boolean flag = false;
        this.listaAttivita.remove(attivita);
        calcoloValoreTempoTotStimato(attivita, flag);
        attivita.setProgetto(null);
        this.numAttivitaNonCompletate--;
    }

    private void calcoloValoreTempoTotStimato(Attivita attivita, Boolean flag){
        if(flag) this.tempo_tot_stimato = this.tempo_tot_stimato.plus(attivita.getTempoStimato());
        else this.tempo_tot_stimato = this.tempo_tot_stimato.minus(attivita.getTempoStimato());
    }

    private void completato(){
       this.stato = this.stato.cambiaStato();
    }

    public void controlloStatoProgetto(){
        int i = 0;
        for(Attivita attivita : this.listaAttivita){
            if(attivita.getStato() == Stato.NON_TERMINATA){
                i++;
            }
        }
        this.numAttivitaNonCompletate = i;
        if(i == 0) completato();
    }

}
