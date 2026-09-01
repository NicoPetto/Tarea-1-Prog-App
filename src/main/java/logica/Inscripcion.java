/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;
import java.util.Date;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Id;
import javax.persistence.Entity;

/**
 *
 * @author Nicolás
 */
@Entity
public class Inscripcion {
    
    @Id
    private Date fechaInscripcion;
    
    public Date getFechaInscripcion(){
        return fechaInscripcion;
    }
    
    public void setFechaInscripcion(Date fechaInscripcion){
        this.fechaInscripcion = fechaInscripcion;
    }
    
    @ManyToOne
    @JoinColumn(name = "edicion_nombre")
    private EdicionCurso edicion;
    
    @ManyToOne
    private ProgramaFormacion programa;
    
    public EdicionCurso getEdicionCurso(){
        return edicion;
    }
    
    public void setEdicionCurso(EdicionCurso edicion){
        this.edicion = edicion;
    }
    
    public ProgramaFormacion getProgramaFormacion(){
        return programa;
    }
    
    public void setProgramaFormacion(ProgramaFormacion programa){
        this.programa = programa;
    }
    
}
