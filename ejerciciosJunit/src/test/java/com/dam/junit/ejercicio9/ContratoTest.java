package com.dam.junit.ejercicio9;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class ContratoTest {

    private Contrato contratoFijo;
    private Contrato contratoTemporal;

    @BeforeAll
    static void iniciarPruebas() {
        System.out.println("Iniciando pruebas de Contrato...");
    }

    @BeforeEach
    void setUp() {
        Contrato.resetTotalContratos(); 
        contratoFijo = new Contrato("Empresa A", "Juan López", "Desarrollador", 2000, LocalDate.of(2024, 1, 1));
        contratoTemporal = new Contrato("Empresa B", "Laura Sánchez", "Diseñadora", 1800, LocalDate.of(2024, 2, 1), 12);
    }

    @Test
    void testConstructorContratoIndefinido() {

        assertNotNull(contratoFijo); //se asegura de que el contrato exista
        assertEquals(2000, contratoFijo.getSalario());
        assertTrue(contratoFijo.esIndefinido());
    }

    @Test
    void testConstructorContratoTemporal() {

        assertNotNull(contratoTemporal);
        assertEquals(1800, contratoTemporal.getSalario());
        assertEquals(12, contratoTemporal.getDuracionMeses());

        //el contrato no es indefinido
        assertFalse(contratoTemporal.esIndefinido()); 
    }

    @Test
    void testAumentarSalario() {
        contratoFijo.aumentarSalario(10); // Aumento del 10%
        assertEquals(2200, contratoFijo.getSalario());
    }

    @Test
    void testRenovarContrato() {

        contratoTemporal.renovarContrato(6); // +6 meses
        assertEquals(18, contratoTemporal.getDuracionMeses());
    }

    @Test
    void testNoRenovarContratoIndefinido() {
        contratoFijo.renovarContrato(6); //en este caso no debería de cambiar nada
        
        //al contrato indefinido no se le pueden sumar meses
        assertEquals(0, contratoFijo.getDuracionMeses()); 
    }

    @Test
    void testCompararSalario() {
        assertEquals("El contrato de Juan López tiene un salario mayor.", contratoFijo.compararSalario(contratoTemporal));
        assertEquals("El contrato de Juan López tiene un salario mayor.", contratoTemporal.compararSalario(contratoFijo));

        // si los salarios son iguales
        Contrato contratoIgual = new Contrato("Empresa C", "Miguel García", "Tester", 2000, LocalDate.of(2024, 3, 1));
        assertEquals("Los dos contratos tienen el mismo salario.", contratoFijo.compararSalario(contratoIgual));
    }


    @Test
    void testRescindirContrato() {
        contratoFijo.rescindirContrato(); //se elimina contrato
        assertEquals(1, Contrato.getTotalContratos()); // solo queda 1 contrato activo
    }

    @Test
    void testTotalContratos() {
        assertEquals(2, Contrato.getTotalContratos());
    }

    @AfterEach
    void tearDown() {
        System.out.println("Prueba terminado.");
    }

    @AfterAll
    static void finalizarPruebas() {
        System.out.println("Todas las pruebas de Contrato han terminado.");
    }

}
