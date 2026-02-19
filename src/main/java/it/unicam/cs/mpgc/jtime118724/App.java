package it.unicam.cs.mpgc.jtime118724;




import it.unicam.cs.mpgc.jtime118724.Dao.AttivitaDao;
import it.unicam.cs.mpgc.jtime118724.Dao.ProgettoDao;
import it.unicam.cs.mpgc.jtime118724.Infrastructure.AppContext;
import it.unicam.cs.mpgc.jtime118724.Navigator.INavigator;
import it.unicam.cs.mpgc.jtime118724.Navigator.SceneNavigator;
import it.unicam.cs.mpgc.jtime118724.Navigator.ListaPathFXML;
import javafx.application.Application;

import javafx.stage.Stage;


public class App extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("JTime");
        // qui creo i miei dao e li metto dentro la mia borsa degli attrezzi
        AppContext ctx = new AppContext(new AttivitaDao(), new ProgettoDao());

        // passo la cassetta degli attrezzi al mio assistente che li consegnera ogni volta che andra da na scena ad un altra ai loro corrispettivi controller.
        INavigator navigator = new SceneNavigator(ctx);
        //System.out.println(navigator.stampa());

        navigator.init(stage);
        navigator.goTo(ListaPathFXML.START_MENU);

    }

    public static void main(String[] args) {
        launch(args);

    }

}
