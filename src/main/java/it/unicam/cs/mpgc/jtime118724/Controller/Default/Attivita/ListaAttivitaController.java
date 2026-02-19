package it.unicam.cs.mpgc.jtime118724.Controller.Default.Attivita;

import it.unicam.cs.mpgc.jtime118724.Controller.Abstract.IController;
import it.unicam.cs.mpgc.jtime118724.Dao.Abstract.IAttivitaDao;
import it.unicam.cs.mpgc.jtime118724.Infrastructure.AppContext;
import it.unicam.cs.mpgc.jtime118724.Model.Entities.Attivita;
import it.unicam.cs.mpgc.jtime118724.Navigator.INavigator;
import it.unicam.cs.mpgc.jtime118724.Navigator.ListaPathFXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;

import java.io.IOException;

/**
 * Gestisce gli eventi scaturiti dalla view ListaAttivita.fxml
 */
public class ListaAttivitaController implements IController {

    private final ObservableList<Attivita> listaAttivitaNonTerminate = FXCollections.observableArrayList(); // lista 1

    private final ObservableList<Attivita> listaAttivitaTerminate = FXCollections.observableArrayList(); // lista 2

    @FXML
    private ListView<Attivita> lista1;

    @FXML
    private ListView<Attivita> lista2;

    private INavigator navigator;

    private IAttivitaDao dao;

    private String message1 = "Vuoi eliminare l'attività: ";

    private String message2 = "Vuoi eliminare tutto il contenuto della lista ?";


    @FXML
    private void initialize(){


        listaAttivitaNonTerminate.addAll(dao.getListaAttivitaNonTerminate());
        listaAttivitaTerminate.addAll(dao.getListaAttivitaTerminate());
        lista1.setItems(listaAttivitaNonTerminate);
        lista2.setItems(listaAttivitaTerminate);
    }

    /**
     * @param ctx
     * @param nav
     */
    @Override
    public void init(AppContext ctx, INavigator nav) {
        this.navigator = nav;
        this.dao = ctx.attivitaDao();
    }

    @FXML
    private void nuovaAttivita() throws IOException {
       this.navigator.goTo(ListaPathFXML.MODULO_CREAZIONE_ATTIVITA);
    }

    @FXML
    private void eliminaAttivita(){
        Attivita selezionata = lista1.getSelectionModel().getSelectedItem();

        if (selezionata == null) {
            new Alert(Alert.AlertType.WARNING, "Seleziona un'attività da eliminare.").showAndWait();
            return;
        }

        if(confermaEliminazione(selezionata, message1)){
            dao.delete(selezionata.getId());
            listaAttivitaNonTerminate.remove(selezionata);
        }
    }

    @FXML
    private void eliminaTutto(){

        if(listaAttivitaNonTerminate.isEmpty()){
            new Alert(Alert.AlertType.WARNING, "Nessuna attivita è al momento nella lista.").showAndWait();
            return;
        }

        if(confermaEliminazioneTotale(message2))
        dao.clearAndResetIdentity();
        listaAttivitaNonTerminate.clear();
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
    @FXML
    private void updateTask(){
        navigator.goTo(ListaPathFXML.MODULO_MODIFICA_ATTIVITA, lista1.getSelectionModel().getSelectedItem());
    }
    @FXML
    private void goBack(){
        this.navigator.goTo(ListaPathFXML.START_MENU);
    }


}

