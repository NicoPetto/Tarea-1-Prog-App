package persistencia;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.Estudiante;

public class PruebaJPAEstudiantes {

public static void main(String[] args) {

    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("edEXTPU");

    EntityManager em = emf.createEntityManager();

    System.out.println("CONEXION EXITOSA");

    try {

        em.getTransaction().begin();

        // =========================
        // ESTUDIANTES
        // =========================

        Estudiante estudiante1 =
                new Estudiante(
                        "carlos123",
                        "carlos@gmail.com",
                        "Carlos",
                        "Gonzalez",
                        new SimpleDateFormat("dd/MM/yyyy").parse("15/04/2000")
                );

        Estudiante estudiante2 =
                new Estudiante(
                        "nicolas123",
                        "nicolas@gmail.com",
                        "Nicolas",
                        "Pereira",
                        new SimpleDateFormat("dd/MM/yyyy").parse("20/08/2001")
                );

        Estudiante estudiante3 =
                new Estudiante(
                        "lucas123",
                        "lucas@gmail.com",
                        "Lucas",
                        "Rodriguez",
                        new SimpleDateFormat("dd/MM/yyyy").parse("10/12/1999")
                );

        Estudiante estudiante4 =
                new Estudiante(
                        "sofia123",
                        "sofia@gmail.com",
                        "Sofia",
                        "Martinez",
                        new SimpleDateFormat("dd/MM/yyyy").parse("05/06/2002")
                );


        // =========================
        // PERSISTIR ESTUDIANTES
        // =========================

        em.persist(estudiante1);
        em.persist(estudiante2);
        em.persist(estudiante3);
        em.persist(estudiante4);


        em.getTransaction().commit();

        System.out.println("ESTUDIANTES GUARDADOS CORRECTAMENTE");

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