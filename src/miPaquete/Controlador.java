/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miPaquete;

import java.util.ArrayList;

/**
 *
 * @author leox01
 */
public class Controlador {
    
    private static ArrayList <Alumno> alumnosArray = new ArrayList<>();
    
    public static boolean registrarAlumno(int codigo, String nombre, 
                                       String carrera, int semestre, 
                                       double promedio){
    
        try{
             alumnosArray.add(new Alumno(codigo, nombre, carrera, semestre, promedio));
             return  true;
        }catch(Exception e){
            return false;
        }
        
    }
    
    
    public static ArrayList obtenerRegistros(){
    
        return alumnosArray;
        
    
    }
    
    public static Alumno buscarAlumno(int codigoBuscado){
        for (Alumno alumno : alumnosArray) {
            if(alumno.getCodigo() == codigoBuscado){
            
                return  alumno;
            }
        }
        
        //si no se encuentra el alumno buscado retornamos un 
        //objeto que el código sea -1
        Alumno a = new Alumno();
        a.setCodigo(-1);
        
        return  a;
    
    }
    
}
