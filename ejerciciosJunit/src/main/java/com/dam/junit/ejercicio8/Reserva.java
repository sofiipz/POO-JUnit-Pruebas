package com.dam.junit.ejercicio8;

public class Reserva {
    private String nombreCliente;
    private int numeroHabitacion;

    public Reserva(String nombreCliente, int numeroHabitacion) {
        this.nombreCliente = nombreCliente;
        this.numeroHabitacion = numeroHabitacion;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }
}
