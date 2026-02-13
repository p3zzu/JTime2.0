package it.unicam.cs.mpgc.jtime118724.Controller;

import it.unicam.cs.mpgc.jtime118724.Model.Entities.Attivita;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.io.IOException;

public class ListaAttivitaController {

    private ObservableList<Attivita> listaAttivita = FXCollections.observableArrayList();

    @FXML
    private ListView<Attivita> lista;

    @FXML
    private Button modifica;

    @FXML
    private Button elimina;

    @FXML
    private Button nuovaAttività;



    private void initialize(){
        lista.setItems(listaAttivita);
    }

    @FXML
    public void NuovaAttivita (ActionEvent e) throws IOException {

    }

    public void EliminaAttivita (){

    }

    public void TornaIndietro(){

    }
}
