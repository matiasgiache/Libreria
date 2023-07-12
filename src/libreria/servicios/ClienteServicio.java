package libreria.servicios;

import java.util.List;
import libreria.entidades.Cliente;
import libreria.persistencia.ClienteDAO;

/**
 *
 * @author matia
 */
public class ClienteServicio {
    
    private AutorServicio autorServicio;
    private EditorialServicio editorialServicio;
    private LibroServicio libroServicio;
    private PrestamoServicio prestamoServicio;
    private final ClienteDAO dao;

    public ClienteServicio() {
        this.dao = new ClienteDAO();
    }

    public void setServicio(AutorServicio autorServicio, EditorialServicio editorialServicio, LibroServicio libroServicio, PrestamoServicio prestamoServicio) {
        this.autorServicio = autorServicio;
        this.editorialServicio = editorialServicio;
        this.libroServicio = libroServicio;
        this.prestamoServicio = prestamoServicio;
    }
    
    public Cliente crearCliente(Long dni, String nombre, String apellido, String telefono){
        Cliente cliente = new Cliente();
        try {
            cliente.setDni(dni);
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setTelefono(telefono);
            
            dao.guardar(cliente);
            return cliente;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public Cliente buscarPorID(Integer id){
        try {
            return dao.buscarPorID(id);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public Cliente buscarPorNombre(String nombre){
        try {
            return dao.buscarPorNombre(nombre);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public Cliente buscarPorDNI(Long dni){
        try {
            return dao.buscarPorDNI(dni);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public boolean eliminarPorNombre(String nombre){
        try {
            dao.eliminarPorNombre(nombre);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean eliminarPorDNI(Long dni){
        try {
            dao.eliminarPorDNI(dni);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public List<Cliente> listarCliente(){
        try {
            return dao.listarClientes();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
    }
}
