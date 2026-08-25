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
@Entity
public class Usuario implements Serializable {
    @Id
    private String nick;
    @Id
    private String mail;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    
    public Usuario(){
        
    }
    
    public Usuario(String ni, String m, String no, String a, Date fn){
        this.nick = ni;
        this.mail = m;
        this.nombre = no;
        this.apellido = a;
        this.fechaNacimiento = fn;
    }
    
    public String getNick(){
        return nick;
    }
    public void setNick(String ni){
        nick = ni;
    }
    
    public String getMail(){
        return mail;
    }
    public void setMail(String ni){
        mail = ni;
    }
    
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String no){
        nombre = no;
    }
    
    public String getApellido(){
        return apellido;
    }
    public void setApellido(String a){
        apellido = a;
    }
    
    public Date getFechaNacimiento(){
        return fechaNacimiento;
    }
    public void setFechaNacimiento(Date fn){
        fechaNacimiento = fn;
    }
    
}
