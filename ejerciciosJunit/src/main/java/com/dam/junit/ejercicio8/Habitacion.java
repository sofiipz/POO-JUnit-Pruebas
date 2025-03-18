package com.dam.junit.ejercicio8;

public class Habitacion {
    private int numero;
    private boolean reservada;

    public Habitacion(int numero) {
        this.numero = numero;
        this.reservada = false;
    }

    public int getNumero() {
        return numero;
    }

    public boolean estaReservada() {
        return reservada;
    }

    public void reservar() {
        this.reservada = true;
    }

    public void cancelarReserva() {
        this.reservada = false;
    }
}
