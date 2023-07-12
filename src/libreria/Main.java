package libreria;

//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
import libreria.servicios.Menu;

/**
 *
 * @author matia
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
        //EntityManager em = emf.createEntityManager();
        Menu menu = new Menu();
        menu.Menu();
    }

}
