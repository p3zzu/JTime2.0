package it.unicam.cs.mpgc.jtime118724.Controller.Default.Attivita;

import it.unicam.cs.mpgc.jtime118724.Dao.Abstract.IAttivitaDao;
import it.unicam.cs.mpgc.jtime118724.Model.Entities.Attivita;
import it.unicam.cs.mpgc.jtime118724.Navigator.INavigator;
import it.unicam.cs.mpgc.jtime118724.Util.ConvertitoreLatoGui;
import it.unicam.cs.mpgc.jtime118724.Navigator.ListaPathFXML;
import javafx.fxml.FXML;
import javafx.scene.control.*;


/**
 * Gestisce gli eventi scaturiti dalla view ModuloCreazioneAttivita.fxml
 */
public class ModuloCreazioneAttivitaController {

    @FXML
    private TextField nome;


    @FXML
    private TextArea descrizione;

    @FXML
    private TextField durataStimata;

    @FXML
    private TextField durataEffettiva;

    @FXML
    private DatePicker dataPianificata;

    @FXML
    private TextField progettoAssegnato;

    @FXML
    private Label statoAttivita;

    private INavigator navigator;

    private IAttivitaDao dao;


    @FXML
    private void initialize(){


        configTextFields();
        configDatePicker();
        configLabels();
    }

    @FXML
    private void confirmOperation(){
        dao.save(new Attivita(this.nome.getText().trim(),this.descrizione.getText().trim(), ConvertitoreLatoGui.convertiStringa(this.durataStimata.getText())));
        this.navigator.goTo(ListaPathFXML.LISTA_ATTIVITA);
    }

    @FXML
    private void cancelOperation(){
        this.navigator.goTo(ListaPathFXML.LISTA_ATTIVITA);
    }

    private void configTextFields(){
        this.durataEffettiva.setDisable(true);

        this.progettoAssegnato.setText("NESSUNO");
        this.progettoAssegnato.setDisable(true);
    }

    private void configDatePicker(){
        this.dataPianificata.setDisable(true);
    }

    private void configLabels(){
        this.statoAttivita.setText("NON_TERMINATA");
        //this.statoAttivita.setDisable(true);
    }

}
