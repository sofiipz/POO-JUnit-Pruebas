package com.dam.junit.ejercicio8;

import java.util.ArrayList;

public class Hotel {
    
    private ArrayList<Habitacion> habitaciones;
    private ArrayList<Reserva> reservas;

    public Hotel(int totalHabitaciones) {
        this.habitaciones = new ArrayList<>();
        this.reservas = new ArrayList<>();
        
        // Crear las habitaciones del hotel
        for (int i = 1; i <= totalHabitaciones; i++) {
            habitaciones.add(new Habitacion(i));
        }
    }

    public boolean realizarReserva(String nombreCliente, int numeroHabitacion) {
        // Buscar la habitación
        for (Habitacion h : habitaciones) {
            if (h.getNumero() == numeroHabitacion && !h.estaReservada()) {
                h.reservar();
                reservas.add(new Reserva(nombreCliente, numeroHabitacion));
                return true;
            }
        }
        return false; // Habitación no disponible o no existe
    }

    public boolean cancelarReserva(int numeroHabitacion) {
        // Buscar la reserva y eliminarla
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getNumeroHabitacion() == numeroHabitacion) {
                reservas.remove(i);
                // Marcar la habitación como disponible
                for (Habitacion h : habitaciones) {
                    if (h.getNumero() == numeroHabitacion) {
                        h.cancelarReserva();
                        return true;
                    }
                }
            }
        }
        return false; // No se encontró la reserva
    }

    public ArrayList<Reserva> obtenerReservasActivas() {
        return new ArrayList<>(reservas);
    }
}
