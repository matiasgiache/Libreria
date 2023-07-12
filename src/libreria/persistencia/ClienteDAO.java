package libreria.persistencia;

import java.util.List;
import libreria.entidades.Cliente;

public class ClienteDAO extends DAO<Cliente> {

    @Override
    public void guardar(Cliente cliente) {
        super.guardar(cliente);
    }

    public Cliente buscarPorID(Integer id) {
        conectar();
        Cliente cliente = (Cliente) em.createQuery("SELECT c FROM Cliente c WHERE c.id = :id")
                .setParameter("id", id).getSingleResult();
        desconectar();
        return cliente;
    }

    public Cliente buscarPorNombre(String nombre) {
        conectar();
        Cliente cliente = (Cliente) em.createQuery("SELECT c FROM Cliente c WHERE c.nombre LIKE " + nombre + "'")
                .getSingleResult();
        desconectar();
        return cliente;
    }

    public Cliente buscarPorDNI(Long dni) {
        conectar();
        Cliente cliente = (Cliente) em.createQuery("SELECT c FROM Cliente c WHERE c.dni LIKE :dni")
                .setParameter("dni", dni).getSingleResult();
        desconectar();
        return cliente;
    }

    public void eliminarPorNombre(String nombre) {
        Cliente cliente = buscarPorNombre(nombre);
        super.eliminar(cliente);
    }

    public void eliminarPorDNI(Long dni) {
        Cliente cliente = buscarPorDNI(dni);
        super.eliminar(cliente);
    }

    public List<Cliente> listarClientes() {
        conectar();
        List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c")
                .getResultList();
        desconectar();
        return clientes;
    }
}
