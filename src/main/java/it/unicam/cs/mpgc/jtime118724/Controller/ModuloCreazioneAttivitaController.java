package it.unicam.cs.mpgc.jtime118724.Controller;

import it.unicam.cs.mpgc.jtime118724.Dao.Dao;
import it.unicam.cs.mpgc.jtime118724.Dao.IDao;
import it.unicam.cs.mpgc.jtime118724.Model.Entities.Attivita;
import it.unicam.cs.mpgc.jtime118724.Util.ConvertitoreLatoGui;
import it.unicam.cs.mpgc.jtime118724.Util.ListaPathFXML;
import it.unicam.cs.mpgc.jtime118724.Util.UiNavigatorUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


/**
 * Gestisce gli eventi scaturi dalla view ModuloCreazioneAttivita
 */
public class ModuloCreazioneAttivitaController {

    @FXML
    private TextField nome;
    //private String name;
    @FXML
    private TextArea descrizione;
    //private String description;
    @FXML
    private TextField durataStimata;
    //private String estimateDuration;
    @FXML
    private TextField durataEffettiva;
    //private String actualDuration;
    @FXML
    private DatePicker dataPianificata;
    //private LocalDate date;
    @FXML
    private TextField progettoAssegnato;
    //private Progetto project;
    @FXML
    private TextField statoAttivita;


    private IDao<Attivita> dao = new Dao<>(Attivita.class);
    /*

    public enum Mode { NUOVA, MODIFICA }

    private Mode mode;

    */
    @FXML
    private void initialize(){

        this.durataEffettiva.setDisable(true);

        this.dataPianificata.setDisable(true);

        this.progettoAssegnato.setText("NESSUNO");
        this.progettoAssegnato.setDisable(true);

        this.statoAttivita.setText("NON_TERMINATA");
        this.statoAttivita.setDisable(true);

    }

    @FXML
    private void x(){
        dao.save(new Attivita(this.nome.getText().trim(),this.descrizione.getText().trim(), ConvertitoreLatoGui.convertiStringa(this.durataStimata.getText())));
        UiNavigatorUtil.getInstance().goTo(ListaPathFXML.LISTA_ATTIVITA);
    }


}
