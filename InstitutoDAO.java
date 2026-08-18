/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tarea_1_prog_app;

/**
 *
 * @author elizeth
 */

import java.util.ArrayList;
import java.util.List;

public class InstitutoDAO {
    
    private List<Instituto>institutos;
    //= new ArrayList<>();
    
    public InstitutoDAO(){
        institutos=new ArrayList<>();
    }
    
    public void guardarInsti(Instituto instituto){
        institutos.add(instituto);
    }
    
    public Instituto buscarPorNombre (String nombre){
        
        for (Instituto instituto : institutos){
            if (instituto.getNombre().equalsIgnoreCase(nombre)){
                return instituto;
            }
        }
        
        return null;
    }
    
}
