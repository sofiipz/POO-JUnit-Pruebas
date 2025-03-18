
package com.dam.junit.ejercicio6;

import java.util.ArrayList;

public class Estudiante {
    private String nombre;
    private ArrayList<Double> notas;

    public Estudiante(String nombre, ArrayList<Double> notas) {
        this.nombre = nombre;
        this.notas = notas;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Double> getNotas() {
        return notas;
    }

    public double calcularPromedio() {
        if (notas.isEmpty()) return 0.0;
        double suma = 0;
        for (double nota : notas) {
            suma += nota;
        }
        return suma / notas.size();
    }

    public boolean estaAprobado(double notaMinima) {
        return calcularPromedio() >= notaMinima;
    }
}
