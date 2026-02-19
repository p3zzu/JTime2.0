package it.unicam.cs.mpgc.jtime118724.Navigator;


/**
 * Contenitore di tutti i path dei files .fxml
 */
public enum ListaPathFXML {
    LISTA_ATTIVITA("/SceneBuilderFiles/ListaAttivita.fxml"),
    MODULO_CREAZIONE_ATTIVITA("/SceneBuilderFiles/ModuloCreazioneAttivita.fxml"),
    START_MENU("/SceneBuilderFiles/StartMenu.fxml"),
    MODULO_MODIFICA_ATTIVITA("/SceneBuilderFiles/ModuloModificaAttivita.fxml");

    private final String fxml;
    private ListaPathFXML(String s) {
        this.fxml = s;
    }

    public String getFxml() {
        return fxml;
    }
}

/*
VANTAGGI

✅ Niente refusi (scrivere a mano le stringhe è pericoloso)

✅ Se cambi cartella/nome file, lo cambi una sola volta nell’enum

✅ Il codice diventa più leggibile: View.LISTA_ATTIVITA è più chiaro di una stringa
 */