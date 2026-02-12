package it.unicam.cs.mpgc.jtime118724;

import com.sun.javafx.stage.EmbeddedWindow;
import it.unicam.cs.mpgc.jtime118724.Dao.AttivitàDao;
import it.unicam.cs.mpgc.jtime118724.Dao.IDao;
import it.unicam.cs.mpgc.jtime118724.Dao.ProgettoDao;
import it.unicam.cs.mpgc.jtime118724.Model.Entities.Attivita;
import it.unicam.cs.mpgc.jtime118724.Model.Entities.Progetto;
import it.unicam.cs.mpgc.jtime118724.Util.DaStringaUmanaAStringaIso8610;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.Duration;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        try{
            FXMLLoader loader = new FXMLLoader(App.class.getResource("/SceneBuilderFiles/ListaAttivita.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (RuntimeException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        //launch(args);



        Attivita a = new Attivita("cacca", "fare tanta cacca", Duration.ofDays(13).plusHours(7).plusMinutes(55));
        //System.out.println(a);

        Progetto p = new Progetto("Mega cacca", "Fare la cagata più bella del mondo ");
        //System.out.println(p);

        p.addAttivita(a);

        /*
        IDao<Attivita> dao = new AttivitàDao();
        dao.clearAndResetIdentity();
        dao.save(a);
        */


        IDao<Progetto> dao2 = new ProgettoDao();
        dao2.clearAndResetIdentity();
        dao2.save(p);

        /*
        IDao<Attivita> dao = new AttivitàDao();
        dao.save(a);

        System.out.println(
                App.class.getClassLoader().getResource("META-INF/persistence.xml")
        );

        String s = "3 giorni e 2 ore";// devo trasformarlo in una stringa di tipo iso ISO-8601
        Duration d = Duration.parse(DaStringaUmanaAStringaIso8610.converti(s));
        System.out.println(d);

         */
    }

}
