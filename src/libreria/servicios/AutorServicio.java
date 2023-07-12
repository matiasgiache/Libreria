package libreria.servicios;

import java.util.List;
import libreria.entidades.Autor;
import libreria.persistencia.AutorDAO;

public class AutorServicio {
    private EditorialServicio editorialServicio;
    private LibroServicio libroServicio;
    private PrestamoServicio prestamosServicio;
    private ClienteServicio clienteServicio;
    private final AutorDAO dao;

    public AutorServicio() {
        this.dao = new AutorDAO();
        
    }
    
    public void setServicio(EditorialServicio editorialServicio, LibroServicio libroServicio, PrestamoServicio prestamoServicio, ClienteServicio clienteServicio){
        this.libroServicio = libroServicio;
        this.editorialServicio = editorialServicio;
        this.prestamosServicio = prestamoServicio;
        this.clienteServicio = clienteServicio;
    }
    
    public Autor crearAutor(String nombre, boolean alta){
        Autor autor = new Autor();
        try {
            autor.setNombre(nombre);
            autor.setAlta(alta);
            dao.guardar(autor);
            return autor;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    public Autor buscarPorNombre(String nombre){
        try {
            return dao.buscarPorNombre(nombre);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;    
        }
    }
    public boolean eliminarAutor(String nombre){
        try {
            dao.eliminar(nombre);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public List<Autor> listarAutores(){
        try {
            return dao.listarAutores();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
