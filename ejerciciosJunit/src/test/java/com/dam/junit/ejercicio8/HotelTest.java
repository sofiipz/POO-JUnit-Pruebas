package com.dam.junit.ejercicio8;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;

public class HotelTest {

    private Hotel hotel;
    
    @BeforeAll
    static void iniciarPruebas() {
        System.out.println("Iniciando pruebas de Hotel...");
    }

    @BeforeEach
    void setUp() {

        //creación de un hotel con 3 habitaciones
        hotel = new Hotel(3);
        System.out.println("Nueva prueba iniciada.");
    }


    @Test
    @DisplayName("Verificar que una habitación no pueda ser reservada dos veces")
    void testReservaDuplicada() {
        //rserva 1
        assertTrue(hotel.realizarReserva("Mario López", 1));
        
        // reserva 2 pero de la misma habitación, no se podrá volver a reservar 
        assertFalse(hotel.realizarReserva("Marta Martín", 1));
    }


    @Test
    @DisplayName("Verificar que al cancelar una reserva, la habitación queda disponible")
    void testCancelarReserva() {
        // hacer reserva
        assertTrue(hotel.realizarReserva("Mario López", 1));
        
        // cancelar reserva
        assertTrue(hotel.cancelarReserva(1));
        
        // habitación dsponible después de la cancelación
        assertTrue(hotel.realizarReserva("Marta Martín", 1));
    }


    @Test
    @DisplayName("Verificar que el sistema devuelve todas las reservas activas")
    void testObtenerReservasActivas() {

        // hacer varias reservas
        hotel.realizarReserva("Mario López", 1);
        hotel.realizarReserva("Marta Martín", 2);
        
        // reservas activas
        ArrayList<Reserva> reservasActivas = hotel.obtenerReservasActivas();
        
        //tienen que aparecer 2 reservas
        assertEquals(2, reservasActivas.size());
        
        // reservas correctas
        //el primer cliente tiene que ser Mario López, habitación 1
        assertEquals("Mario López", reservasActivas.get(0).getNombreCliente());
        assertEquals(1, reservasActivas.get(0).getNumeroHabitacion());
        
        //2ª clienta Marta Martín, habitación 2
        assertEquals("Marta Martín", reservasActivas.get(1).getNombreCliente());
        assertEquals(2, reservasActivas.get(1).getNumeroHabitacion());
    
    }

    @AfterEach
    void tearDown() {
        System.out.println("Prueba terminada.");
    }

    @AfterAll
    static void finalizarPruebas() {
        System.out.println("Todas las pruebas de Hotel han terminado.");
    }








}
