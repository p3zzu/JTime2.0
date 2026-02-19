package it.unicam.cs.mpgc.jtime118724.Controller.Default;

import it.unicam.cs.mpgc.jtime118724.Navigator.INavigator;
import it.unicam.cs.mpgc.jtime118724.Navigator.ListaPathFXML;
import it.unicam.cs.mpgc.jtime118724.Navigator.SceneNavigator;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Gestisce gli eventi scaturiti dalla view StartMenuController.fxml
 */
public class StartMenuController {

    @FXML
    Button listaAttivita;
    @FXML
    Button listaProgetti;
    @FXML
    Button calendario;

    private INavigator navigator;


    @FXML
    private void initialize(){

    }

    /**
     * Gestione del cambio di scena
     * da StartMenu.fxml a ListaAttivita.fxml
     * evento scaturito dal clik del button listaAttivita.
     */
    public void goToListaAttivita() {
        this.navigator.goTo(ListaPathFXML.LISTA_ATTIVITA);
    }
    /*
    LISTA PROGETTI ancora da implementare

    public void cambiaSuScenaListaProgetti() throws IOException {
        UiNavigatorUtil.getInstance().goTo("/SceneBuilderFiles/ListaProgetti.fxml");
    }

     */
}
