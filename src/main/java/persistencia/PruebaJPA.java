package persistencia;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.Estudiante;
import logica.Instituto;

public class PruebaJPA {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("Persistence");

        EntityManager em = emf.createEntityManager();

        System.out.println("CONEXION EXITOSA");

        try {

            em.getTransaction().begin();

            Estudiante estudiante = new Estudiante(
                    "nico125",
                    "nico3@gmail.com",
                    "Nicolas",
                    "Pettorossi",
                    new Date()
            );
            
            Instituto instituto = new Instituto("Insti2");

            em.persist(estudiante);
            em.persist(instituto);

            em.getTransaction().commit();

            System.out.println("ESTUDIANTE GUARDADO CORRECTAMENTE");

        } catch (Exception e) {

            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            e.printStackTrace();

        } finally {
            em.close();
            emf.close();
        }
    }
}