package logica;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Clase que conserva la colección global de los cursos del sistema.
 * Los cursos se identifican por su nombre.
 */
public class ManejadorCurso {
    private Map<String, Curso> cursosNombre;
    private static ManejadorCurso instancia = null;
    private EntityManager em;

    private ManejadorCurso() {
        cursosNombre = new HashMap<String, Curso>();
    }

    public static ManejadorCurso getinstance() {
        if (instancia == null)
            instancia = new ManejadorCurso();
        return instancia;
    }

    public void addCurso(Curso cur) {
        String nombre = cur.getNombre();
        cursosNombre.put(nombre, cur);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SwingDemoPU");
        em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        try{
            t.begin();
            em.persist(cur);
            t.commit();
            
        }
        catch(Exception e){
            t.rollback();    
        }
        em.close();
        
    }

    public Curso obtenerCurso(String nombre) {
        return ((Curso) cursosNombre.get(nombre));
    }

    public Curso[] getCursos() {
        if (cursosNombre.isEmpty())
            return null;
        else {
            Collection<Curso> curs = cursosNombre.values();
            Object[] o = curs.toArray();
            Curso[] cursos = new Curso[o.length];
            for (int i = 0; i < o.length; i++) {
                cursos[i] = (Curso) o[i];
            }
            return cursos;
        }
    }

}
