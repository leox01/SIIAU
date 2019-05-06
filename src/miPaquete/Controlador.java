/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miPaquete;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author leox01
 */
public class Controlador {
    
    private static ArrayList <Alumno> alumnosArray = new ArrayList<>();
    
    public static boolean primeraVezQueAbroElPrograma = true;
    
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
    
    
    public static void guardarAlumnoEditado(Alumno alumnoEditado,int codigoDeAlumno){
        int index = 0;
        for (Alumno alumno : alumnosArray) {
            
            if(alumno.getCodigo() == codigoDeAlumno){
                
                alumnosArray.remove(index);
                alumnosArray.add(alumnoEditado);
                break;
            }
            index++;
        }
    
    }
    
    
    public static boolean eliminarAlumno(int codigoDelAlumnoAEliminar){
        int index = 0;
        for (Alumno alumno : alumnosArray) {
            if(alumno.getCodigo() == codigoDelAlumnoAEliminar){
                alumnosArray.remove(index);
                return  true;
            }
            index++;
        }
        return false;
    }
    
    
    public static void cargarArchivo(){
        
        
        if(primeraVezQueAbroElPrograma){
            
            File file = new File("miArchivo.txt");
            BufferedReader reader = null;

            try {
                FileReader fl = new FileReader(file);
                reader = new BufferedReader(fl);
                String text;

                while ((text = reader.readLine()) != null) {
                    Alumno a = new Alumno();
                    StringTokenizer st1 = new StringTokenizer(text, "|");
                    int contador = 0;
                    while (st1.hasMoreElements()) {
                        switch(contador){

                            case 0 : a.setNombre((String)st1.nextElement());break;
                            case 1 : a.setCodigo(Integer.parseInt((String)st1.nextElement()));break;
                            case 2 : a.setCarrera((String)st1.nextElement());break;
                            case 3 : a.setSemestre(Integer.parseInt((String)st1.nextElement()));break;
                            case 4 : a.setPromedio(Double.parseDouble((String)st1.nextElement()));break;
                        }
                        contador++;
                       
                    }
                     alumnosArray.add(a);
                    
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                }
            }
        
        
            primeraVezQueAbroElPrograma = false;
        }
        
        
        
    
    
    }
    
    
    public static void guardarArchivo(){
        
        
        String alumnosConcatenados = "";
        for (Alumno alumno : alumnosArray) {
            alumnosConcatenados = alumnosConcatenados+alumno.getNombre()+"|"
                                   +alumno.getCodigo()+"|"+alumno.getCarrera()+"|"
                                   +alumno.getSemestre()+"|"+alumno.getPromedio()+"\n";
        }
        
    
        try {
            
            File newTextFile = new File("miArchivo.txt");
            FileWriter fw = new FileWriter(newTextFile);
            fw.write(alumnosConcatenados);
            fw.close();
            //mostrarMensajeEmergente("Mensaje", "Archivo Guardado");

        } catch (IOException iox) {
            //do stuff with exception
            iox.printStackTrace();
        }
    
    
    }
    
}
