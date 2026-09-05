package persistencia;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.*;

public class CargarDatosPrueba {

public static void main(String[] args) {

    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("edEXTPU");

    EntityManager em = emf.createEntityManager();

    System.out.println("CONEXION EXITOSA");

    try {

        em.getTransaction().begin();

        // =========================
        // USUARIOS
        // =========================

        Estudiante EL =
                new Estudiante(
                        "eleven11",
                        "eleven11@gmail.com",
                        "Eleven",
                        "Twelve",
                        new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1971")
                );

        Estudiante CO =
                new Estudiante(
                        "costas",
                        "gcostas@gmail.com",
                        "Gerardo",
                        "Costas",
                        new SimpleDateFormat("dd/MM/yyyy").parse("15/11/1983")
                );

        Estudiante RO =
                new Estudiante(
                        "roro",
                        "rcotelo@yahoo.com",
                        "Rodrigo",
                        "Cotelo",
                        new SimpleDateFormat("dd/MM/yyyy").parse("02/08/1975")
                );

        Estudiante CH =
                new Estudiante(
                        "chechi",
                        "cgarrido@hotmail.com",
                        "Cecilia",
                        "Garrido",
                        new SimpleDateFormat("dd/MM/yyyy").parse("12/09/1987")
                );

        Estudiante JW =
                new Estudiante(
                        "jeffw",
                        "jwilliams@gmail.com",
                        "Jeff",
                        "Williams",
                        new SimpleDateFormat("dd/MM/yyyy").parse("27/11/1964")
                );

        Estudiante WE =
                new Estudiante(
                        "weiss",
                        "aweiss@hotmail.com",
                        "Adrian",
                        "Weiss",
                        new SimpleDateFormat("dd/MM/yyyy").parse("23/12/1978")
                );

        Docente WW =
                new Docente(
                        "heisenberg",
                        "heisenberg@gmail.com",
                        "Walter",
                        "White",
                        new SimpleDateFormat("dd/MM/yyyy").parse("07/03/1956")
                );

        Docente OK =
                new Docente(
                        "benkenobi",
                        "benKenobi@gmail.com",
                        "Obi-Wan",
                        "Kenobi",
                        new SimpleDateFormat("dd/MM/yyyy").parse("02/04/1914")
                );

        Docente EW =
                new Docente(
                        "waston",
                        "e.watson@gmail.com",
                        "Emma",
                        "Watson",
                        new SimpleDateFormat("dd/MM/yyyy").parse("15/04/1990")
                );

        Docente GH =
                new Docente(
                        "house",
                        "greghouse@gmail.com",
                        "Gregory",
                        "House",
                        new SimpleDateFormat("dd/MM/yyyy").parse("15/05/1959")
                );

        Docente TC =
                new Docente(
                        "timmy",
                        "tim.cook@apple.com",
                        "Tim",
                        "Cook",
                        new SimpleDateFormat("dd/MM/yyyy").parse("01/11/1960")
                );

        Docente DR =
                new Docente(
                        "danny",
                        "dan.riccio@gmail.com",
                        "Daniel",
                        "Riccio",
                        new SimpleDateFormat("dd/MM/yyyy").parse("05/07/1963")
                );

        Docente PS =
                new Docente(
                        "phils",
                        "schiller@gmail.com",
                        "Philip",
                        "Schiller",
                        new SimpleDateFormat("dd/MM/yyyy").parse("07/10/1961")
                );

        Docente BS =
                new Docente(
                        "bruces",
                        "sewell@gmail.com",
                        "Bruce",
                        "Sewell",
                        new SimpleDateFormat("dd/MM/yyyy").parse("03/12/1959")
                );

        Docente AG =
                new Docente(
                        "adri",
                        "agarcia@gmail.com",
                        "Adriana",
                        "García",
                        new SimpleDateFormat("dd/MM/yyyy").parse("28/07/1978")
                );
        
        // =========================
        // INSTITUTOS
        // =========================
        
        Instituto IN =
                    new Instituto("INCO");
        Instituto IL =
                    new Instituto("IMERL");
        Instituto IF =
                    new Instituto("Física");
        Instituto IM =
                    new Instituto("IMPII");
        Instituto IE =
                    new Instituto("Eléctrica");
        Instituto DI =
                    new Instituto("DISI");
        
        // =========================
        // DATOS ADICIONALES DE DOCENTES
        // =========================
        
        WW.agregoInstituto(IN);
        OK.agregoInstituto(IN);
        EW.agregoInstituto(IN);
        GH.agregoInstituto(IE);
        TC.agregoInstituto(IL);
        DR.agregoInstituto(IL);
        PS.agregoInstituto(IM);
        BS.agregoInstituto(DI);
        AG.agregoInstituto(DI);
        
        // =========================
        // CURSOS
        // =========================
        
        Curso C1 = new Curso("Talleres plenarios",
                "3 semanas",
                15,
                1,
                "01/02/2026", "*Talleres plenarios*: presentados por cuatro reconocidos\n" +
"matemáticos uruguayos, plantearán diversos tópicos de matemática\n" +
"en el marco de los cuales se realizarán actividades fomentando la\n" +
"integración entre\n" +
"estudiantes, docentes e investigadores.", "WWW.TMU.EDU.UY");
        Curso C2 = new Curso("", "", , , "", "", "");
        Curso C3 = new Curso("", "", , , "", "", "");
        Curso C4 = new Curso("", "", , , "", "", "");
        Curso C5 = new Curso("", "", , , "", "", "");
        Curso C6 = new Curso("", "", , , "", "", "");
        Curso C7 = new Curso("", "", , , "", "", "");
        Curso C8 = new Curso("", "", , , "", "", "");
        Curso C9 = new Curso("", "", , , "", "", "");
        Curso C10 = new Curso("", "", , , "", "", "");
        
        //em.persist();
        


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