package com.dam.junit.ejercicio6;

import java.util.ArrayList;

public class Curso {
    
    private String nombre;
    private ArrayList<Estudiante> estudiantes;
    private double notaMinimaAprobacion;

    public Curso(String nombre, double notaMinimaAprobacion) {
        this.nombre = nombre;
        this.notaMinimaAprobacion = notaMinimaAprobacion;
        this.estudiantes = new ArrayList<>();
    }

    public boolean inscribirEstudiante(Estudiante estudiante) {
        // Verificar que no se inscriba dos veces
        for (Estudiante e : estudiantes) {
            if (e.getNombre().equals(estudiante.getNombre())) {
                return false;
            }
        }
        estudiantes.add(estudiante);
        return true;
    }

    public double calcularPromedioGeneral() {
        if (estudiantes.isEmpty()) return 0.0;
        double suma = 0;
        for (Estudiante e : estudiantes) {
            suma += e.calcularPromedio();
        }
        return suma / estudiantes.size();
    }

    public ArrayList<Estudiante> obtenerEstudiantesAprobados() {
        ArrayList<Estudiante> aprobados = new ArrayList<>();
        for (Estudiante e : estudiantes) {
            if (e.estaAprobado(notaMinimaAprobacion)) {
                aprobados.add(e);
            }
        }
        return aprobados;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }
}
