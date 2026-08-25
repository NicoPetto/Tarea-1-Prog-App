/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.io.Serializable;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Nicolás
 */
@Entity
public class Instituto implements Serializable{
    @Id
    private String nombre;
    
    public Instituto(){
        
    }
    
    public Instituto(String n){
        this.nombre = n;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String n) {
        nombre = n;
    }
}
