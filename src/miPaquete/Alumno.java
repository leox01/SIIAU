/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miPaquete;

/**
 *
 * @author leox01
 */
public class Alumno extends Universitario{
    
    private String carrera;
    private int semestre;
    private double promedio;

    public Alumno() {
    }
    
    public Alumno(int codigo, String nombre, String carrera,int semestre, double promedio) {
        super(codigo, nombre);
        this.carrera = carrera;
        this.semestre = semestre;
        this.promedio = promedio;
    }

    
    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
    
    
    
    
    
}
