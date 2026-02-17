package it.unicam.cs.mpgc.jtime118724.Controller;

import it.unicam.cs.mpgc.jtime118724.Util.ListaPathFXML;
import it.unicam.cs.mpgc.jtime118724.Util.UiNavigatorUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class StartMenuController {

    @FXML
    Button listaAttivita;
    @FXML
    Button listaProgetti;
    @FXML
    Button calendario;



    public void cambiaSuScenaListaAttivita() throws IOException {
        UiNavigatorUtil.getInstance().goTo(ListaPathFXML.LISTA_ATTIVITA);
    }
    /*
    LISTA PROGETTI ancora da implementare

    public void cambiaSuScenaListaProgetti() throws IOException {
        UiNavigatorUtil.getInstance().goTo("/SceneBuilderFiles/ListaProgetti.fxml");
    }

     */
}
