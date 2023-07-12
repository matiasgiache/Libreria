package libreria.servicios;

import java.util.List;
import libreria.entidades.Editorial;
import libreria.persistencia.EditorialDAO;

/**
 *
 * @author matia
 */
public class EditorialServicio {
    
    private AutorServicio autorServicio;
    private LibroServicio libroServicio;
    private PrestamoServicio prestamoServicio;
    private ClienteServicio clienteServicio;
    private final EditorialDAO dao;

    public EditorialServicio() {
        this.dao = new EditorialDAO();
    }  
    public void setServicio(AutorServicio autorServicio, LibroServicio libroServicio, PrestamoServicio prestamoServicio, ClienteServicio clienteSerivicio){
        this.autorServicio = autorServicio;
        this.libroServicio = libroServicio;
        this.clienteServicio = clienteSerivicio;
        this.prestamoServicio = prestamoServicio;
    }
    public Editorial crearEditorial(String nombre, boolean alta){
        Editorial editorial = new Editorial();
        try {
            editorial.setNombre(nombre);
            editorial.setAlta(alta);
            dao.guardar(editorial);
            return editorial;
        } catch (Exception e) {
            System.out.println( e.getMessage());
            return null;
        }
    }
    public Editorial buscarPorNombre(String nombre){
        try {
            return dao.buscarPorNombre(nombre);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;    
        }
    }
    public boolean eliminarEditorial(String nombre){
        try {
            dao.eliminar(nombre);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public List<Editorial> listarEditoriales(){
        try {
            return dao.listarEditoriales();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    
}
