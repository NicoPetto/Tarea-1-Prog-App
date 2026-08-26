/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.Date;
import javax.persistence.Entity;
/**
 *
 * @author Nicolás
 */

@Entity
public class Docente extends Usuario{
    
    public Docente() {
        super();
    }
    
    public Docente(String ni, String m, String no, String a, Date fn){
        super(ni, m, no, a, fn);
    }
    
}
