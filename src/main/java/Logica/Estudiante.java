/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;
import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import java.util.Date;

/**
 *
 * @author Nicolás
 */
public class Estudiante extends Usuario{
    
    public Estudiante(String ni, String m, String no, String a, Date fn){
        super(ni, m, no, a, fn);
    }
    
}
