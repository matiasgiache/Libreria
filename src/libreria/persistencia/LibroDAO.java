package libreria.persistencia;

import java.util.List;
import libreria.entidades.Libro;

/**
 *
 * @author matia
 */
public class LibroDAO extends DAO<Libro> {

    @Override
    public void guardar(Libro libro) {
        super.guardar(libro);
    }
    public Libro buscarPorTitulo(String titulo) {
        conectar();
        Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE '" + titulo + "'")
                .getSingleResult();
        desconectar();
        return libro;
    }
    public Libro buscarPorISBN(Long isbn) {
        conectar();
        Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.isbn LIKE :isbn")
                .setParameter("isbn", isbn).getSingleResult();
        desconectar();
        return libro;
    }
    public List<Libro> buscarPorAutor(String autor) {
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.autor.nombre LIKE '" + autor + "'")
                .getResultList();
        desconectar();
        return libros;
    }
    public List<Libro> buscarPorAnio(int anio) {
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.anio = :anio")
                .setParameter("anio", anio).getResultList();
        desconectar();
            return libros;
    }
    public List<Libro> buscarPorEditorial(String editorial) {
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.editorial.nombre LIKE '" + editorial + "'")
                .getResultList();
        desconectar();
        return libros;
    }
    
    public List<Libro> listarLibros() {
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l")
                .getResultList();
        desconectar();
        return libros;
    }

    public void eliminarLibro(String titulo) {
        Libro libro = buscarPorTitulo(titulo);
        super.eliminar(libro);
    }
}
