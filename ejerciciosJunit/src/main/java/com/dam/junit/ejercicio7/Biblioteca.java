package com.dam.junit.ejercicio7;

import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Libro> libros;

    public Biblioteca() {
        this.libros = new ArrayList<>();
    }

    public boolean agregarLibro(Libro libro) {
        // Verifica que no se agregue un libro duplicado
        for (Libro l : libros) {
            if (l.getTitulo().equalsIgnoreCase(libro.getTitulo())) {
                return false;
            }
        }
        libros.add(libro);
        return true;
    }

    public boolean prestarLibro(String titulo) {
        for (Libro l : libros) {
            if (l.getTitulo().equalsIgnoreCase(titulo) && !l.estaPrestado()) {
                l.prestar();
                return true;
            }
        }
        return false; // No se encontró el libro disponible para préstamo
    }

    public boolean devolverLibro(String titulo) {
        for (Libro l : libros) {
            if (l.getTitulo().equalsIgnoreCase(titulo) && l.estaPrestado()) {
                l.devolver();
                return true;
            }
        }
        return false; // No se encontró el libro prestado para devolución
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }
}
