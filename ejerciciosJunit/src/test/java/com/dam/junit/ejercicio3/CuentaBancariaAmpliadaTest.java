package com.dam.junit.ejercicio3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Pruebas Paramétricas de la Clase CuentaBancariaAmpliada")
public class CuentaBancariaAmpliadaTest {


        private CuentaBancariaAmpliada cuenta;
    
        @BeforeEach
        void setUp() {
            cuenta = new CuentaBancariaAmpliada(100.0);
        }
    
        @ParameterizedTest
        @CsvSource({
            "50, 150.0",
            "30, 130.0",
            "0, 100.0",
            "-10, 100.0"
        })
        @DisplayName("Depositar diferentes cantidades")
        void testDepositar(double cantidad, double saldoEsperado) {
            cuenta.depositar(cantidad);
            assertEquals(saldoEsperado, cuenta.getSaldo(), "El saldo después del depósito no es correcto.");
        }
    
        @ParameterizedTest
        @CsvSource({
            "40, true, 60.0",
            "100, true, 0.0",
            "200, false, 100.0",
            "-20, false, 100.0"
        })
        @DisplayName("Retirar diferentes cantidades")
        void testRetirar(double cantidad, boolean resultadoEsperado, double saldoEsperado) {
            boolean resultado = cuenta.retirar(cantidad);
            assertEquals(resultadoEsperado, resultado, "El resultado del retiro no es correcto.");
            assertEquals(saldoEsperado, cuenta.getSaldo(), "El saldo después del retiro no es correcto.");
        }
    
        @ParameterizedTest
        @CsvSource({
            "10, 110.0",
            "5, 105.0",
            "0, 100.0",
            "-5, 100.0"
        })
        @DisplayName("Aplicar diferentes porcentajes de interés")
        void testAplicarInteres(double porcentaje, double saldoEsperado) {
            cuenta.aplicarInteres(porcentaje);
            assertEquals(saldoEsperado, cuenta.getSaldo(), "El saldo después de aplicar interés no es correcto.");
        }
    
        @Test
        @DisplayName("Transferencia exitosa entre cuentas")
        void testTransferenciaExitosa() {
            CuentaBancariaAmpliada destino = new CuentaBancariaAmpliada(50);
            boolean resultado = cuenta.transferir(destino, 30);
            
            assertTrue(resultado, "La transferencia debería ser exitosa.");
            assertEquals(70.0, cuenta.getSaldo(), "El saldo después de transferir no es correcto.");
            assertEquals(80.0, destino.getSaldo(), "El saldo de destino después de recibir la transferencia no es correcto.");
        }
    
        @Test
        @DisplayName("Transferencia fallida por saldo insuficiente")
        void testTransferenciaFallida() {
            CuentaBancariaAmpliada destino = new CuentaBancariaAmpliada(50);
            boolean resultado = cuenta.transferir(destino, 200);
    
            assertFalse(resultado, "La transferencia no debería ser posible.");
            assertEquals(100.0, cuenta.getSaldo(), "El saldo de origen no debería haber cambiado.");
            assertEquals(50.0, destino.getSaldo(), "El saldo de destino no debería haber cambiado.");
        }
    
        @Test
        @DisplayName("Historial de transacciones")
        void testHistorialTransacciones() {
            cuenta.depositar(20);
            cuenta.retirar(10);
            cuenta.aplicarInteres(5);
            
            assertEquals(3, cuenta.getHistorialTransacciones().size(), "El historial de transacciones debería tener 3 registros.");
            assertEquals("Depósito: +20.0", cuenta.getHistorialTransacciones().get(0));
            assertEquals("Retiro: -10.0", cuenta.getHistorialTransacciones().get(1));
        }
    }
    