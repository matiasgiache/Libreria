package libreria.servicios;

import java.util.List;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import libreria.persistencia.LibroDAO;

/**
 *
 * @author matia
 */
public class LibroServicio {

    private EditorialServicio editorialServicio;
    private AutorServicio autorServicio;
    private PrestamoServicio prestamoServicio;
    private ClienteServicio clienteServicio;
    private final LibroDAO dao;

    public LibroServicio() {
        this.dao = new LibroDAO();
    }

    public void setServicio(EditorialServicio editorialServicio, AutorServicio autorServicio, PrestamoServicio prestamoServicio, ClienteServicio clienteSericio) {
        this.autorServicio = autorServicio;
        this.editorialServicio = editorialServicio;
        this.prestamoServicio = prestamoServicio;
        this.clienteServicio = clienteSericio;
    }

    public Libro crearLibro(long isbn, String titulo, Integer anio, Integer ejemplares, Integer ejemplaresPrestados,
            Integer ejemplaresRestantes, boolean alta, Autor autor, Editorial editorial) {
        Libro libro = new Libro();
        try {
            libro.setISBN(isbn);
            libro.setTitulo(titulo);
            libro.setAnio(anio);
            libro.setAlta(alta);
            libro.setEjemplares(ejemplares);
            libro.setEjemplaresPrestados(ejemplaresPrestados);
            libro.setEjemplaresRestantes(ejemplaresRestantes);
            libro.setAutor(autor);
            libro.setEditorial(editorial);
            dao.guardar(libro);
            return libro;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Libro buscarPorTitulo(String titulo) {
        try {
            return dao.buscarPorTitulo(titulo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Libro buscarPorISBN(long isbn) {
        try {
            return dao.buscarPorISBN(isbn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Libro> buscarPorEditorial(String editorial) {
        try {
            return dao.buscarPorEditorial(editorial);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Libro> buscarPorAnio(Integer anio) {
        try {
            return dao.buscarPorAnio(anio);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Libro> buscarPorAutor(String autor) {
        try {
            return dao.buscarPorAutor(autor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Libro> listarLibros() {
        try {
            return dao.listarLibros();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean eliminarLibro(String titulo) {
        try {
            dao.eliminarLibro(titulo);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
