package com.dam.junit.ejercicio1mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.dam.junit.ejercicio1.Calculadora;

class CalculadoraTest {

    @Test
    void testSumaConMockito() {
        //  ¿POR QUÉ USAMOS UN MOCK?
        //  En algunas situaciones, no podemos usar un objeto real. Por ejemplo:
        //  La clase Calculadora aún NO ESTÁ IMPLEMENTADA o está incompleta.
        //  La clase Calculadora depende de una BASE DE DATOS o de una API externa.
        //  Queremos AISLAR la prueba para verificar solo una parte del código.
        //  Necesitamos controlar lo que devuelve el método para simular distintos escenarios.
        
        // SOLUCIÓN: Creamos un "Mock" (una versión falsa de la Calculadora) con Mockito.
        Calculadora calculadoraMock = mock(Calculadora.class);

        //  ¿QUÉ ESTAMOS HACIENDO AQUÍ?
        // Estamos diciéndole a Mockito que si alguien llama a sumar(2,3), devuelva 10.
        // Normalmente, 2 + 3 = 5, pero aquí forzamos que devuelva 10.
        when(calculadoraMock.sumar(2, 3)).thenReturn(10);

        // LLAMAMOS AL MÉTODO SUMAR
        int resultado = calculadoraMock.sumar(2, 3);

        // ¿QUÉ ESTAMOS PROBANDO?
        // Estamos verificando que el método devuelve el valor que hemos indicado con Mockito.
        assertEquals(10, resultado);

        // VERIFICAMOS QUE EL MÉTODO FUE LLAMADO
        // Esto nos asegura de que realmente se ha ejecutado sumar(2,3) una vez.
        verify(calculadoraMock).sumar(2, 3);
    }
}
