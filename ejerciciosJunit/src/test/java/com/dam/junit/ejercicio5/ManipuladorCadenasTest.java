package com.dam.junit.ejercicio5;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ManipuladorCadenasTest {

    private ManipuladorCadenas manipulador;

    @BeforeAll
    static void iniciarPruebas() {
        System.out.println("Iniciando pruebas de ManipuladorCadenas...");
    }

    @BeforeEach
    void setUp() {
        manipulador = new ManipuladorCadenas();
        System.out.println("Nueva prueba iniciada.");
    }

    @ParameterizedTest
    @CsvSource({
        "'hola', 'HOLA'",
        "'Java', 'JAVA'",
        "'Pruebas', 'PRUEBAS'"
    })
    @DisplayName("Convertir una cadena a mayúsculas")
    void testConvertirMayusculas(String inicio, String resultadoEsperado) {

        assertEquals(resultadoEsperado, manipulador.convertirMayusculas(inicio), 
            "La conversión a mayúsculas de '" + inicio + "' debería ser '" + resultadoEsperado + "'.");
    }

    @Test
    @DisplayName("Invertir una cadena de texto")
    void testInvertirCadena() {

        assertEquals("aloh", manipulador.invertirCadena("hola"));
        assertEquals("avaJ", manipulador.invertirCadena("Java"));
        assertEquals("sabeurP", manipulador.invertirCadena("Pruebas"));
    
    }


    @Test
    @DisplayName("Contar las vocales en una cadena de texto")
    void testContarVocales() {
        assertEquals(2, manipulador.contarVocales("hola"));  // o, a
        assertEquals(2, manipulador.contarVocales("Java"));  // a, a
        assertEquals(3, manipulador.contarVocales("pruebas")); // u, e, a
    
    }

    @Test
    @DisplayName("Concatenar dos cadenas")
    void testConcatenar() {

        assertEquals("HolaMundo", manipulador.concatenar("Hola", "Mundo"));
        assertEquals("JavaProgramacion", manipulador.concatenar("Java", "Programacion"));
        assertEquals("abc123", manipulador.concatenar("abc", "123"));
    }


    
    @Test
    @DisplayName("Verificar si una cadena es un palíndromo")
    void testEsPalindromo() {

        assertTrue(manipulador.esPalindromo("La sal"));  // con espacios
        assertTrue(manipulador.esPalindromo("La ruta Natural"));  // con mayúsculs
        assertFalse(manipulador.esPalindromo("java"));  // no palídromo
    
    }


    @AfterEach
    void tearDown() {
        System.out.println("Prueba terminada.");
    }

    @AfterAll
    static void finalizarPruebas() {

        System.out.println("Todas las pruebas de ManipuladorCadenas han terminando.");
    }
}
