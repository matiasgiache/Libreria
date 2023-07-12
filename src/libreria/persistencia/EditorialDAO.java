package libreria.persistencia;

import java.util.List;
import libreria.entidades.Editorial;

/**
 *
 * @author matia
 */
public class EditorialDAO extends DAO<Editorial>{
    
    @Override
    public void guardar(Editorial editorial){
        super.guardar(editorial);
    }
    
    public void eliminar(String nombre){
        Editorial editorial = buscarPorNombre(nombre);
        super.eliminar(editorial);
    }
    
    public Editorial buscarPorNombre(String nombre){
        conectar();
        Editorial editorial = (Editorial) em.createQuery("SELECT ed FROM Editorial ed WHERE ed.nombre LIKE '" + nombre + "'")
                .getSingleResult();
        desconectar();
        return editorial;
    }
    
    public List<Editorial> listarEditoriales(){
        conectar();
        List<Editorial> editoriales = em.createQuery("SELECT ed from Editorial ed")
                .getResultList();
        desconectar();
        return editoriales;
    }
    
}
