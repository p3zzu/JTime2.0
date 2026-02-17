package it.unicam.cs.mpgc.jtime118724.Util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.Getter;

/**
 * Serve per fornire la EntityManager senza ricaricare ogni volta le informazioni di configurazione di connessione.
 */

public class JpaUtil {
    @Getter
    private static final EntityManagerFactory emf = buildEntityManagerFactory();

    // dobbiamo definire un costruttore private per impedire di istanziare un oggetto della classe.
    private JpaUtil(){}

    private static EntityManagerFactory buildEntityManagerFactory(){
        try {
            return Persistence.createEntityManagerFactory("jtimePU");
        }catch (Exception e){
            throw new RuntimeException(
                    "Errore nella creazione di EntityManagerFactory" + e.getMessage()
            );
        }
    }


    /**
     * Crea un oggetto EntityManager.
     * ATTENZIONE: chi lo riceve deve chiudere l'entityManager.
     * @return EntityManager
     */
    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

    /**
     * Chiude la EntityManagerFactory NON la EntityManager
     */
    public static void shutdown(){
        emf.close();
    }
}
