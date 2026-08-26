package logica;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Clase que conserva la colección global de los usuarios del sistema.
 * Los usuarios se identifican por su nick.
 */
public class ManejadorUsuario {
    private Map<String, Usuario> usuariosNick;
    private static ManejadorUsuario instancia = null;
    private EntityManager em;

    private ManejadorUsuario() {
        usuariosNick = new HashMap<String, Usuario>();
    }

    public static ManejadorUsuario getinstance() {
        if (instancia == null)
            instancia = new ManejadorUsuario();
        return instancia;
    }

    public void addUsuario(Usuario usu) {
        String nick = usu.getNick();
        usuariosNick.put(nick, usu);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SwingDemoPU");
        em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        try{
            t.begin();
            em.persist(usu);
            t.commit();
            
        }
        catch(Exception e){
            t.rollback();    
        }
        em.close();
        
    }

    public Usuario obtenerUsuario(String nick) {
        return ((Usuario) usuariosNick.get(nick));
    }

    public Usuario[] getUsuarios() {
        if (usuariosNick.isEmpty())
            return null;
        else {
            Collection<Usuario> usrs = usuariosNick.values();
            Object[] o = usrs.toArray();
            Usuario[] usuarios = new Usuario[o.length];
            for (int i = 0; i < o.length; i++) {
                usuarios[i] = (Usuario) o[i];
            }
            return usuarios;
        }
    }

}
