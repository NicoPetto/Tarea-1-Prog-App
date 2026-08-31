 package persistencia;

import java.text.SimpleDateFormat;
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
                    new Instituto("Instituto de Carlo");

            Instituto instituto2 =
                    new Instituto("Instituto de Nicolas");

            Instituto instituto3 =
                    new Instituto("Pettorossi High School");

            em.persist(instituto1);
            em.persist(instituto2);
            em.persist(instituto3);


            // =========================
            // CURSOS
            // =========================

            Curso curso1 = new Curso();
            curso1.setNombre("Programación de Aplicaciones");
            curso1.setInstituto(instituto1);

            Curso curso2 = new Curso();
            curso2.setNombre("Bases de Datos Avanzados");
            curso2.setInstituto(instituto1);

            Curso curso3 = new Curso();
            curso3.setNombre("Redes Informaticas");
            curso3.setInstituto(instituto2);

            Curso curso4 = new Curso();
            curso4.setNombre("Inteligencia Artificial Avanzada");
            curso4.setInstituto(instituto3);

            em.persist(curso1);
            em.persist(curso2);
            em.persist(curso3);
            em.persist(curso4);


            // =========================
            // EDICIONES
            // =========================
            
            EdicionCurso edicion1 = new EdicionCurso(
                    "Edicion del 2026",
                    new SimpleDateFormat("dd/MM/yyyy").parse("08/03/2026"),
                    new SimpleDateFormat("dd/MM/yyyy").parse("10/05/2026"),
                    new Date(),
                    12
            );

            edicion1.setCurso(curso1);
            curso1.getEdiciones().add(edicion1);


            EdicionCurso edicion2 = new EdicionCurso(
                    "Edicion del 2027",
                    new SimpleDateFormat("dd/MM/yyyy").parse("10/09/2026"),
                    new SimpleDateFormat("dd/MM/yyyy").parse("12/11/2026"),
                    new Date(),
                    11
            );

            edicion2.setCurso(curso1);
            curso1.getEdiciones().add(edicion2);


            EdicionCurso edicion3 = new EdicionCurso(
                    "La del 2026",
                    new SimpleDateFormat("dd/MM/yyyy").parse("25/07/2026"),
                    new SimpleDateFormat("dd/MM/yyyy").parse("20/09/2027"),
                    new Date(),
                    74
            );

            edicion3.setCurso(curso2);
            curso2.getEdiciones().add(edicion3);


            EdicionCurso edicion4 = new EdicionCurso(
                    "Especial 2026",
                    new SimpleDateFormat("dd/MM/yyyy").parse("09/11/2026"),
                    new SimpleDateFormat("dd/MM/yyyy").parse("30/12/2028"),
                    new Date(),
                    33
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