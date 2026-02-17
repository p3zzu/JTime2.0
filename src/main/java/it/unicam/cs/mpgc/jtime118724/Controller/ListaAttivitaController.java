package it.unicam.cs.mpgc.jtime118724.Controller;

import it.unicam.cs.mpgc.jtime118724.Dao.Dao;
import it.unicam.cs.mpgc.jtime118724.Dao.IDao;
import it.unicam.cs.mpgc.jtime118724.Model.Entities.Attivita;
import it.unicam.cs.mpgc.jtime118724.Util.ListaPathFXML;
import it.unicam.cs.mpgc.jtime118724.Util.UiNavigatorUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;

import java.io.IOException;

public class ListaAttivitaController {

    private ObservableList<Attivita> listaAttivita = FXCollections.observableArrayList();

    @FXML
    private ListView<Attivita> lista;


    private IDao<Attivita> dao = new Dao<>(Attivita.class);

    private String message1 = "Vuoi eliminare l'attività: ";

    private String message2 = "Vuoi eliminare tutto il contenuto della lista ?";


    @FXML
    private void initialize(){

        listaAttivita.addAll(dao.getAll());
        lista.setItems(listaAttivita);
    }

    @FXML
    private void nuovaAttivita() throws IOException {
        UiNavigatorUtil.getInstance().goTo(ListaPathFXML.MODULO_CREAZIONE_ATTIVITA);
    }

    @FXML
    private void eliminaAttivita(){
        Attivita selezionata = lista.getSelectionModel().getSelectedItem();

        if (selezionata == null) {
            new Alert(Alert.AlertType.WARNING, "Seleziona un'attività da eliminare.").showAndWait();
            return;
        }

        if(confermaEliminazione(selezionata, message1)){
            dao.delete(selezionata.getId());
            listaAttivita.remove(selezionata);
        }
    }

    @FXML
    private void eliminaTutto(){

        if(listaAttivita.isEmpty()){

        }

        if(confermaEliminazioneTotale(message2))
        dao.clearAndResetIdentity();
        listaAttivita.clear();
    }

    private boolean confermaEliminazione(Attivita selezionata, String m){
        Alert conferma = new Alert(Alert.AlertType.CONFIRMATION,
                m + selezionata.getNome() + " ?",
                ButtonType.YES, ButtonType.NO);
        conferma.setTitle("Conferma eliminazione");

        return conferma.showAndWait().orElse(ButtonType.NO) == ButtonType.YES;
    }

    private boolean confermaEliminazioneTotale(String m){
        Alert conferma = new Alert(Alert.AlertType.CONFIRMATION,
                m,
                ButtonType.YES, ButtonType.NO);
        conferma.setTitle("Conferma eliminazione totale");

        return  conferma.showAndWait().orElse(ButtonType.NO) == ButtonType.YES;
    }

    private void modificaAttivita(){

    }

}

