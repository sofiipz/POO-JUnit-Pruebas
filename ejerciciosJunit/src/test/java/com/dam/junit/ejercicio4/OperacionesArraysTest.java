
package com.dam.junit.ejercicio4;
 

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class OperacionesArraysTest {

    private OperacionesArrays operaciones;
    private int[] valores;
    private int[] vacio;
    private int[] negativos;

    @BeforeAll //se ejecuta antes de todas las pruebas
    static void iniciarPruebas() {
        System.out.println("Iniciando pruebas de OperacionesArrays...");
    }

    @BeforeEach //prepara los datos antes de cada prueba.
    void setUp() {
        operaciones = new OperacionesArrays();
        valores = new int[]{1, 2, 3, 4, 5};  
        vacio = new int[]{};                 
        negativos = new int[]{-3, -1, -7, -5};
    }

    @Test
    @DisplayName("Sumar los elementos de un array")
    void testSuma() {

        assertEquals(15, operaciones.suma(valores));
        assertEquals(0, operaciones.suma(vacio));  
        assertEquals(-16, operaciones.suma(negativos));
    }

    @Test
    @DisplayName("Multiplicar los elementos de un array")
    void testProducto() {

        assertEquals(120, operaciones.producto(valores)); 
        assertEquals(0, operaciones.producto(vacio)); 
        assertEquals(105, operaciones.producto(negativos));
      
    }

    @Test
    @DisplayName("Calcular el promedio de un array")
    void testPromedio() {

        assertEquals(3.0, operaciones.promedio(valores));  
        assertEquals(0.0, operaciones.promedio(vacio));
        assertEquals(-4.0, operaciones.promedio(negativos));
       
    }

    @Test
    @DisplayName("Obtener el máximo de un array")
    void testMaximo() {

        assertEquals(5, operaciones.maximo(valores)); 
        assertEquals(-1, operaciones.maximo(negativos));
       
    }

    @Test
    @DisplayName("Obtener el mínimo de un array")
    void testMinimo() {
        assertEquals(1, operaciones.minimo(valores)); 
        assertEquals(-7, operaciones.minimo(negativos));
       
    }

    @AfterEach //se ejecuta después de cada prueba
    void tearDown() {
        System.out.println("Prueba finalizada.");
    }

    @AfterAll //se ejecuta después de todas las pruebas
    static void finalizarPruebas() {
        System.out.println("Todas las pruebas de OperacionesArrays han finalizado.");
    }
}
