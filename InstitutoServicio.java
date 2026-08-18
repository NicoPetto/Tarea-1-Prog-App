/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tarea_1_prog_app;

/**
 *
 * @author elizeth
 */
public class InstitutoServicio {
    private InstitutoDAO dao = new InstitutoDAO();
    
    public boolean altaInstituto(String nombre){
        
        if (dao.buscarPorNombre(nombre)!=null){
            return false;
           
        }
        
        Instituto instituto = new Instituto(nombre);
        dao.guardarInsti(instituto);
        
        return true;
        
    }
    
    
    
    
    
}
