package com.dam.junit.ejercicio10;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CocheTest {

    private Coche coche;

    @BeforeAll
    static void iniciarPruebas() {
        System.out.println("Iniciando pruebas de Coche...");
    }

    @BeforeEach
    void setUp() {
        coche = new Coche("Toyota", "Corolla");
    }

    @ParameterizedTest
    @CsvSource({
        "50, 50",   
        "70, 30",   
        "100, 0",   
        "150, 0"    
    })

    void testFrenar(double frenar, double velocidadEsperada) {

        coche.arrancar();  
        coche.acelerar(100); //la velocidad inicial es de 100
        
        //va frenando según los valores parametrizados
        coche.frenar(frenar);  
        assertEquals(velocidadEsperada, coche.getVelocidad());

    }

    @Test
    void testAcelerarMasDeLaVelocidadMaxima() {
        coche.arrancar();
        coche.acelerar(250);  

        // no se puede superar la velocidad máx
        assertEquals(200, coche.getVelocidad());
    }

    @Test
    void testFrenarSinAcelerar() {

        coche.arrancar();
        coche.frenar(50);  
        assertEquals(0, coche.getVelocidad());
    }


    @Test
    void testFrenarMasDeLoQueSeTiene() {
        coche.arrancar();
        coche.acelerar(50);  
        coche.frenar(60);  
        assertEquals(0, coche.getVelocidad());
    }

    @Test
    void testApagarCocheMientrasSeConduce() {
        coche.arrancar();
        coche.acelerar(100);  
        coche.apagar();  
        assertEquals(0, coche.getVelocidad());
        assertFalse(coche.Encendido(), "El coche debería estar apagado.");
    }

    @Test
    void testArrancarCocheDespuesDeApagar() {
        coche.arrancar(); 
        coche.apagar();  
        coche.arrancar();  
        assertTrue(coche.Encendido());
    }

    @AfterEach
    void tearDown() {
        System.out.println("Prueba terminado.");
    }

    @AfterAll
    static void finalizarPruebas() {
        System.out.println("Las pruebas de Coche han terminado.");
    }
}



