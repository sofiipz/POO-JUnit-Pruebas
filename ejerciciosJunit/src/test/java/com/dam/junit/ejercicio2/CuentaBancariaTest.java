package com.dam.junit.ejercicio2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

@DisplayName("Pruebas de la Clase CuentaBancaria")
class CuentaBancariaTest {
    private CuentaBancaria cuenta;

    @BeforeAll
    static void iniciarPruebas() {
        System.out.println("Iniciando pruebas de CuentaBancaria...");
    }

    @AfterAll
    static void finalizarPruebas() {
        System.out.println("Todas las pruebas han finalizado.");
    }

    @BeforeEach
    void setUp() {
        cuenta = new CuentaBancaria(100.0); // Cada prueba empieza con saldo de 100
        System.out.println("Nueva cuenta creada con saldo: " + cuenta.getSaldo());
    }

    @AfterEach
    void tearDown() {
        System.out.println("Prueba finalizada, saldo final: " + cuenta.getSaldo());
    }

    @Test
    @DisplayName("Depositar dinero en la cuenta")
    void testDepositar() {
        cuenta.depositar(50);
        assertEquals(150.0, cuenta.getSaldo(), "El saldo después del depósito debería ser 150.");
    }

    @Test
    @DisplayName("Retirar dinero con saldo suficiente")
    void testRetirarConSaldoSuficiente() {
        boolean resultado = cuenta.retirar(40);
        assertTrue(resultado, "El retiro debería ser exitoso.");
        assertEquals(60.0, cuenta.getSaldo(), "El saldo después del retiro debería ser 60.");
    }

    @Test
    @DisplayName("Intentar retirar más dinero del que hay")
    void testRetirarSinSaldoSuficiente() {
        boolean resultado = cuenta.retirar(200);
        assertFalse(resultado, "El retiro no debería ser posible.");
        assertEquals(100.0, cuenta.getSaldo(), "El saldo no debería haber cambiado.");
    }

    @Test
    @DisplayName("Intentar retirar una cantidad negativa")
    void testRetirarCantidadNegativa() {
        boolean resultado = cuenta.retirar(-20);
        assertFalse(resultado, "No se puede retirar una cantidad negativa.");
        assertEquals(100.0, cuenta.getSaldo(), "El saldo no debería haber cambiado.");
    }

    @Test
    @Disabled("Funcionalidad en desarrollo")
    @DisplayName("Test en construcción: funcionalidad futura")
    void testFuncionalidadFutura() {
        fail("Este test está deshabilitado porque aún no se ha implementado.");
    }
}