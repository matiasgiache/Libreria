package libreria.persistencia;

import java.util.List;
import libreria.entidades.Prestamo;

public class PrestamoDAO extends DAO<Prestamo> {

    @Override
    public void guardar(Prestamo prestamo) {
        super.guardar(prestamo);
    }

    public Prestamo buscarPorID(Integer id) {
        conectar();
        Prestamo prestamo = (Prestamo) em.createQuery("SELECT p FROM Prestamo p WHERE p.id LIKE :id")
                .setParameter("id", id).getSingleResult();
        desconectar();
        return prestamo;
    }

    public List<Prestamo> buscarPorNombreCliente(String nombre) {
        conectar();
        List<Prestamo> prestamo = em.createQuery("SELECT p FROM Prestamo p WHERE p.cliente.nombre LIKE '" + nombre + "'")
                .getResultList();
        desconectar();
        return prestamo;
    }

    public List<Prestamo> buscarPorNombreLibro(String nombre) {
        conectar();
        List<Prestamo> prestamo = em.createQuery("SELECT p FROM Prestamo p WHERE p.libro.titulo LIKE '" + nombre + "'")
                .getResultList();
        desconectar();
        return prestamo;
    }

    public void eliminarPorID(Integer id) {
        Prestamo prestamo = buscarPorID(id);
        super.eliminar(prestamo);
    }
    
    public void eliminarPorTitulo(String titulo){
        Prestamo prestamo = buscarPorNombreLibro(titulo).get(0);
        super.eliminar(prestamo);
    }

    public List<Prestamo> listarPrestamos() {
        conectar();
        List<Prestamo> prestamos = em.createQuery("SELECT p FROM Prestamo p")
                .getResultList();
        desconectar();
        return prestamos;
    }

}
