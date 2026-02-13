package it.unicam.cs.mpgc.jtime118724.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;



public class ModuloAttivitaController {

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
    private TextField statoAttivita;

    @FXML
    private Button conferma;

    @FXML
    private Button annulla;

    public enum Mode { NUOVA, MODIFICA }

    private Mode mode;


    private void initialize(){
        //statoAttivita.setText();
        statoAttivita.setDisable(true);
    }


}
