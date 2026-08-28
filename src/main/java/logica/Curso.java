/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

/**
 *
 * @author elizeth
 */
@Entity
@Table(name = "cursos")
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String nombre; // Único

    private String descripcion;
    private String duracion;
    private int cantidadHoras;
    private int creditos;
    private String url;

    @ManyToMany(mappedBy = "cursos")
    private Set<ProgramaFormacion> programas;
    
    @ManyToOne
    @JoinColumn(name = "instituto_id")
    private Instituto instituto;
    
    @ManyToMany
    @JoinTable(
        name = "previas_curso",
        joinColumns = @JoinColumn(name = "curso_id"),
        inverseJoinColumns = @JoinColumn(name = "previa_id")
    )
    private Set<Curso> previas;
    
    @OneToMany(mappedBy = "curso")
    private Set<EdicionCurso> ediciones;
    

    public Curso() {}
    
    @Override
    public String toString() {
        return nombre;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public Set<ProgramaFormacion> getProgramasFormacion() {
        return programas;
    }
    
    public void setProgramaFormacion(Set<ProgramaFormacion> programas){
        this.programas = programas;
    }

    public void setInstituto(Instituto instituto) {
        this.instituto = instituto;
    }
    
    public Instituto getInstituto() {
    return instituto;
    }

    public Set<Curso> getPrevias() {
        return previas;
    }
    
    public void setPrevias(Set<Curso> previas){
        this.previas = previas;
    }
    
    public Set<EdicionCurso> getEdiciones() {
        return ediciones;
    }
    
    public void setEdiciones(Set<EdicionCurso> ediciones){
        this.ediciones = ediciones;
    }
}
