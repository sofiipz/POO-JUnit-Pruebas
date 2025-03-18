package com.dam.junit.ejercicio7;

public class Libro {
    private String titulo;
    private boolean prestado;

    public Libro(String titulo) {
        this.titulo = titulo;
        this.prestado = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean estaPrestado() {
        return prestado;
    }

    public void prestar() {
        this.prestado = true;
    }

    public void devolver() {
        this.prestado = false;
    }
}
