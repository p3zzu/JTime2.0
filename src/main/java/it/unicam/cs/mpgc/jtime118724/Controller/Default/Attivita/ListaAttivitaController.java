package it.unicam.cs.mpgc.jtime118724.Controller.Default.Attivita;

import it.unicam.cs.mpgc.jtime118724.Controller.Abstract.IController;
import it.unicam.cs.mpgc.jtime118724.Dao.Abstract.IAttivitaDao;
import it.unicam.cs.mpgc.jtime118724.Infrastructure.AppContext;
import it.unicam.cs.mpgc.jtime118724.Model.Entities.Attivita;
import it.unicam.cs.mpgc.jtime118724.Navigator.INavigator;
import it.unicam.cs.mpgc.jtime118724.Navigator.ListaPathFXML;
import it.unicam.cs.mpgc.jtime118724.Util.AlertUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

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



    @FXML
    private void initialize(){

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

        listaAttivitaNonTerminate.addAll(dao.getListaAttivitaNonTerminate());
        listaAttivitaTerminate.addAll(dao.getListaAttivitaTerminate());
    }


    @FXML
    private void nuovaAttivita(){
       this.navigator.goTo(ListaPathFXML.MODULO_CREAZIONE_ATTIVITA);
    }


    @FXML
    private void updateTask(){
        navigator.goTo(ListaPathFXML.MODULO_MODIFICA_ATTIVITA, lista1.getSelectionModel().getSelectedItem());
    }


    @FXML
    private void goBack(){
        this.navigator.goTo(ListaPathFXML.START_MENU);
    }

    @FXML
    private void eliminaAttivita(){
        Attivita selezionata = lista1.getSelectionModel().getSelectedItem();

        String msg1 = "Seleziona un'attività da eliminare";
        if (selezionata == null) {
            AlertUtil.warn(msg1);
            return;
        }

        String msg2 = "Vuoi eliminare l'attività: ";
        if(AlertUtil.confirm(selezionata.getNome(), msg2)){
            dao.delete(selezionata.getId());
            listaAttivitaNonTerminate.remove(selezionata);
        }
    }


    @FXML
    private void eliminaTutto(){

        String msg1 = "Nessuna attivita è al momento nella lista";
        if(listaAttivitaNonTerminate.isEmpty()){
            AlertUtil.warn(msg1);
            return;
        }

        String msg2 = "Vuoi eliminare tutto il contenuto della lista ?";
        String title = "Conferma eliminazione";
        if(AlertUtil.confirm(title, msg2)){
            dao.clearAndResetIdentity();
            listaAttivitaNonTerminate.clear();
        }

    }


}

