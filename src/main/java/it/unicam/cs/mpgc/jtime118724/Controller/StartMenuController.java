package it.unicam.cs.mpgc.jtime118724.Controller;

import it.unicam.cs.mpgc.jtime118724.Util.UiNavigatorUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class StartMenuController {

    @FXML
    Button listaAttivita;
    @FXML
    Button listaProgetti;
    @FXML
    Button calendario;



    public void cambiaSuScenaListaAttivita() throws IOException {
        UiNavigatorUtil.getInstance().cambiaScena("/SceneBuilderFiles/ListaAttivita.fxml");
    }
    /*
    LISTA PROGETTI ancora da implementare

    public void cambiaSuScenaListaProgetti() throws IOException {
        UiNavigatorUtil.getInstance().cambiaScena("/SceneBuilderFiles/ListaProgetti.fxml");
    }

     */
}
