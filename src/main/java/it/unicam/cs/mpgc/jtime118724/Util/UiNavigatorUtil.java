package it.unicam.cs.mpgc.jtime118724.Util;

import it.unicam.cs.mpgc.jtime118724.App;
import javafx.fxml.FXMLLoader;
import javafx.fxml.LoadException;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public final class UiNavigatorUtil {

    private static final UiNavigatorUtil INSTANCE = new UiNavigatorUtil();

    private Stage stage;
    private Scene scene;
    private Parent root;

    private UiNavigatorUtil() {}

    public static UiNavigatorUtil getInstance() {
        return INSTANCE;
    }

    public void init(Stage s) {
        this.stage = s;
    }

    public void goTo(ListaPathFXML fxml) {
        URL url = check(fxml.getFxml());
        try{
            this.root = FXMLLoader.load(url);
            this.scene = new Scene(root);
            this.stage.setScene(scene);
            this.stage.show();
        } catch (LoadException ex) {
            throw new IllegalStateException("Errore nel file Fxml o nel controller: "+ fxml, ex);
        }   catch (IOException ex) {
            throw new IllegalStateException("Impossibile caricare FXML (IO): "+ fxml, ex);
        }
    }


    /*
     * Se App.class.getResource(fxml) trova la risorsa → ritorna un URL → url contiene quell’URL.
     * Se non la trova → ritorna null → Objects.requireNonNull(...) lancia subito una NullPointerException con il messaggio "FXML non trovato: ...".
     * @param fxml
     * @return URL
     */
    private URL check(String fxml){
        return Objects.requireNonNull(App.class.getResource(fxml), "File Fxml non trovato: " + fxml);
    }


}
