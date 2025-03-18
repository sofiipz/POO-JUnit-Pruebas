package com.dam.junit.ejercicio7;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class BibliotecaTest {

    private Biblioteca biblioteca;
    private Libro libro1;
    private Libro libro2;
    private Libro libro3;

    @BeforeAll
    static void iniciarPruebas() {
        System.out.println("Iniciando pruebas de Biblioteca...");
    }

    @BeforeEach
    void setUp() {
        biblioteca = new Biblioteca();
        libro1 = new Libro("Programando con Java");
        libro2 = new Libro("Aprendiendo Java");
        libro3 = new Libro("Programando con Java"); // libro repetido
    }

    @Test
    @DisplayName("Agregar libro a la biblioteca")
    void testAgregarLibro() {

        // agregar un libro
        assertTrue(biblioteca.agregarLibro(libro1));
        assertTrue(biblioteca.agregarLibro(libro2));
        
        //no se podrá añadir el libro repetido
        assertFalse(biblioteca.agregarLibro(libro3)); 
    }


    @Test
    @DisplayName("Prestar un libro disponible")
    void testPrestarLibro() {
        biblioteca.agregarLibro(libro1);
        
        // prestar un libro disponible
        assertTrue(biblioteca.prestarLibro("Programando con Java"));
        
        // este libro ya se ha prestado
        assertFalse(biblioteca.prestarLibro("Programando con Java")); 
    }

    @Test
    @DisplayName("Prestar un libro no disponible")
    void testPrestarLibroNoDisponible() {
        biblioteca.agregarLibro(libro1);
        
        // prestar un libro por primera vez
        biblioteca.prestarLibro("Programando con Java");
        
        //prestar un libro no disponible
        assertFalse(biblioteca.prestarLibro("Programando con Java")); 
    }

    @Test
    @DisplayName("Devolver un libro")
    void testDevolverLibro() {
        biblioteca.agregarLibro(libro1);

        biblioteca.prestarLibro("Programando con Java");
        
        // devolver un libro
        assertTrue(biblioteca.devolverLibro("Programando con Java"));
        
        // el libro vuelve a estar dispnible
        assertFalse(libro1.estaPrestado());
    }


    @Test
    @DisplayName("Devolver un libro no prestado")
    void testDevolverLibroNoPrestado() {
        biblioteca.agregarLibro(libro1);
        
        //libro no prestado
        assertFalse(biblioteca.devolverLibro("Programando con Java"));
    }

    @AfterEach
    void tearDown() {
        System.out.println("Prueba terminada.");
    }

    @AfterAll
    static void finalizarPruebas() {
        System.out.println("Todas las pruebas de Biblioteca han terminado.");
    }

 
}
