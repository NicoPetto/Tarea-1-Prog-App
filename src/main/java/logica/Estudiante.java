/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;
import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Nicolás
 */
@Entity
public class Estudiante extends Usuario{
    
    public Estudiante() {
        super();
    }
    
    private List<String> edicionesInscriptas;
    private List<String> programasInscriptos;
    
    public Estudiante(String ni, String m, String no, String a, Date fn){
        super(ni, m, no, a, fn);
    }
    
    public List<String> getEdicionesInscriptas() {
        return edicionesInscriptas;
    }

    public List<String> getProgramasInscriptos() {
        return programasInscriptos;
    }
    
}
