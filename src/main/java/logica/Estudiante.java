/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;
import javax.persistence.Entity;
import java.util.Date;
import javax.persistence.OneToMany;

/**
 *
 * @author Nicolás
 */
@Entity
public class Estudiante extends Usuario{
    
    public Estudiante() {
        super();
    }
    
    public Estudiante(String ni, String m, String no, String a, Date fn){
        super(ni, m, no, a, fn);
    }
    
    @OneToMany
    private Inscripcion inscripcion;
    
    
    
}
