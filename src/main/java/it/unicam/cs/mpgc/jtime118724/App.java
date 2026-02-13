package it.unicam.cs.mpgc.jtime118724;


import it.unicam.cs.mpgc.jtime118724.Util.UiNavigatorUtil;
import javafx.application.Application;

import javafx.stage.Stage;


public class App extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("JTime");
        UiNavigatorUtil.getInstance().init(stage);
        UiNavigatorUtil.getInstance().cambiaScena("/SceneBuilderFiles/StartMenu.fxml");
    }

    public static void main(String[] args) {
        launch(args);
    }

}
