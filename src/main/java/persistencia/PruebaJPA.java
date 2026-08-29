package persistencia;

import java.util.Date;
import java.util.HashSet;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.Curso;
import logica.EdicionCurso;
import logica.Instituto;

public class PruebaJPA {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("edEXTPU");

        EntityManager em = emf.createEntityManager();

        System.out.println("CONEXION EXITOSA");

        try {

            em.getTransaction().begin();

            // =========================
            // INSTITUTOS
            // =========================

            Instituto instituto1 =
                    new Instituto("Instituto de Informática");

            Instituto instituto2 =
                    new Instituto("Instituto de Ciencias");

            Instituto instituto3 =
                    new Instituto("Instituto de Tecnología");

            em.persist(instituto1);
            em.persist(instituto2);
            em.persist(instituto3);


            // =========================
            // CURSOS
            // =========================

            Curso curso1 = new Curso();
            curso1.setNombre("Programación Avanzada");
            curso1.setInstituto(instituto1);

            Curso curso2 = new Curso();
            curso2.setNombre("Bases de Datos");
            curso2.setInstituto(instituto1);

            Curso curso3 = new Curso();
            curso3.setNombre("Redes");
            curso3.setInstituto(instituto2);

            Curso curso4 = new Curso();
            curso4.setNombre("Inteligencia Artificial");
            curso4.setInstituto(instituto3);

            em.persist(curso1);
            em.persist(curso2);
            em.persist(curso3);
            em.persist(curso4);


            // =========================
            // EDICIONES
            // =========================

            EdicionCurso edicion1 = new EdicionCurso(
                    "Programacion Avanzada 2026",
                    new Date(),
                    new Date(),
                    new Date(),
                    30
            );

            edicion1.setCurso(curso1);
            curso1.getEdiciones().add(edicion1);


            EdicionCurso edicion2 = new EdicionCurso(
                    "Programacion Avanzada 2027",
                    new Date(),
                    new Date(),
                    new Date(),
                    25
            );

            edicion2.setCurso(curso1);
            curso1.getEdiciones().add(edicion2);


            EdicionCurso edicion3 = new EdicionCurso(
                    "Bases de Datos 2026",
                    new Date(),
                    new Date(),
                    new Date(),
                    20
            );

            edicion3.setCurso(curso2);
            curso2.getEdiciones().add(edicion3);


            EdicionCurso edicion4 = new EdicionCurso(
                    "Redes 2026",
                    new Date(),
                    new Date(),
                    new Date(),
                    35
            );

            edicion4.setCurso(curso3);
            curso3.getEdiciones().add(edicion4);


            // Como EdicionCurso tiene cascade desde Curso,
            // persistimos las ediciones mediante el curso.

            em.persist(edicion1);
            em.persist(edicion2);
            em.persist(edicion3);
            em.persist(edicion4);


            em.getTransaction().commit();

            System.out.println("DATOS GUARDADOS CORRECTAMENTE");

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