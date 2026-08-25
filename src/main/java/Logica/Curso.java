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
import java.util.Date;

/**
 *
 * @author Nicolás
 */

@Entity
public class Curso implements Serializable {
    @Id
    private String nombre;
    private String url;
    private String descripcion;
    private int cantCreditos;
    private int cantHoras;
    private int duracion;
    private Date fechaRegistro;
    private Date fechaInstancia;
    
    public Curso(){
        
    }
    
    public Curso(String n,
                 String url,
                 String desc,
                 int cred,
                 int horas,
                 int dur,
                 Date fechaReg,
                 Date fechaInst){
        
        this.nombre = n;
        this.url = url;
        this.descripcion = desc;
        this.cantCreditos = cred;
        this.cantHoras = horas;
        this.duracion = dur;
        this.fechaRegistro = fechaReg;
        this.fechaInstancia = fechaInst;
                
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String n){
        this.nombre = n;
    }
    
    public String getUrl(){
        return url;
    }
    
    public void setUrl(String url){
        this.url = url;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public void setDescripcion(String desc){
        this.descripcion = desc;
    }
    
    public int getCantCreditos(){
        return cantCreditos;
    }
    
    public void setCantCreditos(int cantC){
        this.cantCreditos = cantC;
    }
    
    public int getCantHoras(){
        return cantHoras;
    }
    
    public void setCantHoras(int cantH){
        this.cantHoras = cantH;
    }
    
    public int getDuracion(){
        return duracion;
    }
    
    public void setDuracion(int d){
        this.duracion = d;
    }
    
    public Date getFechaRegistro(){
        return fechaRegistro;
    }
    
    public void setFechaRegistro(Date fr){
        this.fechaRegistro = fr;
    }
    
    public Date getFechaInstancia(){
        return fechaInstancia;
    }
    
    public void setFechaInstancia(Date fi){
        this.fechaInstancia = fi;
    }
   
    
    
}
