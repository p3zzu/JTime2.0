package it.unicam.cs.mpgc.jtime118724.Navigator;

import it.unicam.cs.mpgc.jtime118724.App;
import it.unicam.cs.mpgc.jtime118724.Controller.Abstract.DataReceiver;
import it.unicam.cs.mpgc.jtime118724.Controller.Abstract.IController;
import it.unicam.cs.mpgc.jtime118724.Infrastructure.AppContext;
import javafx.fxml.FXMLLoader;
import javafx.fxml.LoadException;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.Getter;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

@Getter
public class SceneNavigator implements INavigator {

    private static Stage stage;
    private final AppContext ctx;

    public SceneNavigator(AppContext ctx) {
        this.ctx = ctx;
    }

    public void init(Stage primaryStage) {
        stage = primaryStage;
    }

    public void goTo(ListaPathFXML fxml) {
        URL url = check(fxml.getFxml());
        try{
            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();

            Object c = loader.getController();
            if (c instanceof IController controlled) {
                controlled.init(ctx, this);
                /*
                 il navigator passa al controller della view, in cui stiamo andando, "gli attrezzi" per il lavoro : Idao e il navigator stesso
                 questa operazione si chiama inniettare e serve per non andare a costruire una istanza navigator e una dao (AttivitaDao e PRogettoDAo)
                 ogni qual volta c'è un cambio di scena.
                 Navigato e Dao vengono istanziate una volta sola (nello Start di App) e basta poi passati volta in volta.
                 */
            }

            stage.setScene(new Scene(root));
            stage.show();


        } catch (LoadException ex) {
            throw new IllegalStateException("Errore nel file Fxml o nel controller: "+ fxml, ex);
        }   catch (IOException ex) {
            throw new IllegalStateException("Impossibile caricare FXML (IO): "+ fxml, ex);
        }
    }

    public <T> void goTo(ListaPathFXML fxml, T data) {
        URL url = check(fxml.getFxml());
        try {
            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();

            Object c = loader.getController();

            if (c instanceof IController controlled) {
                controlled.init(ctx, this);
            }

            if (c instanceof DataReceiver<?> receiver) {
                @SuppressWarnings("unchecked")
                DataReceiver<T> r = (DataReceiver<T>) receiver;
                r.setData(data);
            }
            stage.setScene(new Scene(root));
            stage.show();

        } catch (LoadException ex) {
            throw new IllegalStateException("Errore nel file Fxml o nel controller: " + fxml, ex);
        } catch (IOException ex) {
            throw new IllegalStateException("Impossibile caricare FXML (IO): " + fxml, ex);
        }
    }



    private URL check(String fxml){
        return Objects.requireNonNull(App.class.getResource(fxml), "File Fxml non trovato: " + fxml);
    }

    public String stampa(){
        return "ESISTO";
    }

}
