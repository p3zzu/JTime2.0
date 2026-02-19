package it.unicam.cs.mpgc.jtime118724.Controller.Default.Attivita;

import it.unicam.cs.mpgc.jtime118724.Controller.Abstract.DataReceiver;
import it.unicam.cs.mpgc.jtime118724.Controller.Abstract.IController;
import it.unicam.cs.mpgc.jtime118724.Infrastructure.AppContext;
import it.unicam.cs.mpgc.jtime118724.Model.Entities.Attivita;
import it.unicam.cs.mpgc.jtime118724.Navigator.INavigator;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ModuloModificaAttivitaController implements IController, DataReceiver <Attivita> {
    @FXML
    private TextField nome;

    @FXML
    private TextArea descrizione;

    @FXML
    private TextField durataStimata;

    @FXML
    private TextField durataEffettiva;

    @FXML
    private DatePicker dataPianificata;

    @FXML
    private TextField progettoAssegnato;

    @FXML
    private Label statoAttivita;

    private INavigator navigator;

    private AppContext appContext;

    private Attivita attivita; //appoggio




   private void initialize(){

   }





    /**
     * @param ctx
     * @param nav
     */
    @Override
    public void init(AppContext ctx, INavigator nav) {
        this.appContext = ctx;
        this.navigator = nav;
    }

    /**
     * @param data
     */
    @Override
    public void setData(Attivita data) {
        this.attivita = data;
    }


}
