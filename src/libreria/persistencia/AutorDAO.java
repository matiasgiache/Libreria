package libreria.persistencia;

import java.util.List;
import libreria.entidades.Autor;

public class AutorDAO extends DAO<Autor> {

    @Override
    public void guardar(Autor autor) {
        super.guardar(autor); 
    }
    
    public void eliminar(String nombre){
        Autor autor = buscarPorNombre(nombre);
        super.eliminar(autor);
    }
    
    public Autor buscarPorNombre(String nombre){
        conectar();
        Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE '" + nombre + "'")
                .getSingleResult();
        desconectar();
        return autor;
    }
        
    public List<Autor> listarAutores(){
        conectar();
        List<Autor> autores = em.createQuery("SELECT a FROM Autor a")
                .getResultList();
        desconectar();
        return autores;
    }
}
