package com.dam.junit.ejercicio1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class CalculadoraTest {

    private Calculadora calculadora;

    @BeforeEach
    @DisplayName("Inicialización de la calculadora antes de cada prueba")
    void setUp() {
        calculadora = new Calculadora();
    }

    @Test
    @DisplayName("Prueba de suma con números positivos, negativos y cero")
    void testSumar() {
        assertEquals(5, calculadora.sumar(2, 3));
        assertEquals(-1, calculadora.sumar(2, -3));
        assertEquals(0, calculadora.sumar(0, 0));
    }

    @Test
    @DisplayName("Prueba de resta con números positivos, negativos y cero")
    void testRestar() {
        assertEquals(1, calculadora.restar(3, 2));
        assertEquals(5, calculadora.restar(2, -3));
        assertEquals(0, calculadora.restar(0, 0));
    }

    @Test
    @DisplayName("Prueba de multiplicación con valores positivos, negativos y cero")
    void testMultiplicar() {
        assertEquals(6, calculadora.multiplicar(2, 3));
        assertEquals(-6, calculadora.multiplicar(2, -3));
        assertEquals(0, calculadora.multiplicar(0, 3));
    }

    @Test
    @DisplayName("Prueba de división con números positivos y negativos")
    void testDividir() {
        assertEquals(2.0, calculadora.dividir(6, 3));
        assertEquals(-2.5, calculadora.dividir(-5, 2));
    }

    @Test
    @DisplayName("Prueba de división entre cero, se espera Double.NaN")
    void testDividirPorCero() {
        assertEquals(Double.NaN, calculadora.dividir(5, 0));
    }

    @Disabled
    @Test
    @DisplayName("Prueba deshabilitada: Verificación de excepción al dividir por cero")
    void testDividirPorCeroException() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculadora.dividir(5, 0);
        });
        assertEquals("No se puede dividir por cero", exception.getMessage());
    }
}
