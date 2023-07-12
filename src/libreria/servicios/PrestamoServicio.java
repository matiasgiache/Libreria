package libreria.servicios;

import java.util.Calendar;
import java.util.List;
import libreria.entidades.Cliente;
import libreria.entidades.Libro;
import libreria.entidades.Prestamo;
import libreria.persistencia.PrestamoDAO;

public class PrestamoServicio {

    private AutorServicio autorServicio;
    private EditorialServicio editorialServicio;
    private LibroServicio libroServicio;
    private ClienteServicio clienteServicio;
    private final PrestamoDAO dao;

    public PrestamoServicio() {
        this.dao = new PrestamoDAO();
    }

    public void setServicio(AutorServicio autorServicio, EditorialServicio editorialServicio, LibroServicio libroServicio, ClienteServicio clienteServicio) {
        this.autorServicio = autorServicio;
        this.editorialServicio = editorialServicio;
        this.libroServicio = libroServicio;
        this.clienteServicio = clienteServicio;
    }

    public Prestamo crearPrestamo(Calendar fechaPrestamo, Calendar fechaDevolucion, Libro libro, Cliente cliente) {
        Prestamo prestamo = new Prestamo();
        try {
            prestamo.setFechaPrestamo(fechaPrestamo);
            prestamo.setFechaDevolucion(fechaDevolucion);
            prestamo.setLibro(libro);
            prestamo.setCliente(cliente);

            dao.guardar(prestamo);
            return prestamo;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
    public Prestamo buscarPorID(Integer id){
        try {
            return dao.buscarPorID(id);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public List<Prestamo> buscarPorNombreCliente(String nombre){
        try {
            return dao.buscarPorNombreCliente(nombre);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public List<Prestamo> buscarPorLibro(String libro){
        try {
            return dao.buscarPorNombreLibro(libro);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public boolean eliminarPrestamo(Integer id){
        try {
            dao.eliminarPorID(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        } 
    }
    
    public boolean eliminarPrestamoTitulo(String titulo){
        try {
            dao.eliminarPorTitulo(titulo);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public List<Prestamo> listarPrestamos(){
        try {
            return dao.listarPrestamos();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
    }
}
