package com.dam.junit.ejercicio6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Arrays;

public class CursoTest {

    private Curso curso;
    private Estudiante estudiante1;
    private Estudiante estudiante2;
    private Estudiante estudiante3;

    @BeforeAll
    static void iniciarPruebas() {
        System.out.println("Iniciando pruebas de Curso...");
    }

    //creación del curso y estudiantes
    @BeforeEach
    void setUp() {
        curso = new Curso("Programación", 5.0);

        estudiante1 = new Estudiante("Juan Pérez", new ArrayList<>(Arrays.asList(6.0, 7.0, 8.0)));
        estudiante2 = new Estudiante("Ana Gómez", new ArrayList<>(Arrays.asList(4.0, 5.0, 4.0)));
        estudiante3 = new Estudiante("Carlos Sánchez", new ArrayList<>(Arrays.asList(5.5, 6.5, 7.0)));
    }

    @Test
    @DisplayName("Inscripción de estudiantes")
    void testInscribirEstudiante() {


        assertTrue(curso.inscribirEstudiante(estudiante1));
        assertTrue(curso.inscribirEstudiante(estudiante2));
        assertTrue(curso.inscribirEstudiante(estudiante3));

        assertEquals(3, curso.getEstudiantes().size()); //hay tres estudiantes creados
    }

    @Test
    @DisplayName("No permitir inscribir al mismo estudiante dos veces")
    void testInscripcionDuplicada() {
        curso.inscribirEstudiante(estudiante1);
        
        //se vuelve a inscribir el estudiante1
        assertFalse(curso.inscribirEstudiante(estudiante1), "El estudiante ya está en este curso.");

    }

    @Test
    @DisplayName("Calcular el promedio general del curso")
    void testCalcularPromedioGeneral() {
        curso.inscribirEstudiante(estudiante1);
        curso.inscribirEstudiante(estudiante2);
        curso.inscribirEstudiante(estudiante3);

        double promedioEsperado = (estudiante1.calcularPromedio() + estudiante2.calcularPromedio() + estudiante3.calcularPromedio()) / 3;
        assertEquals(promedioEsperado, curso.calcularPromedioGeneral());
    }

    @Test
    @DisplayName("Obtener estudiantes aprobados")
    void testObtenerEstudiantesAprobados() {
        
        curso.inscribirEstudiante(estudiante1);
        curso.inscribirEstudiante(estudiante2);
        curso.inscribirEstudiante(estudiante3);

        ArrayList<Estudiante> aprobados = curso.obtenerEstudiantesAprobados(); //solo son 2 aprobados
        
        assertTrue(aprobados.contains(estudiante1));
        assertFalse(aprobados.contains(estudiante2)); //no está aprobado
        assertTrue(aprobados.contains(estudiante3));
        
    }

    @AfterEach
    void tearDown() {
        System.out.println("Prueba terminada.");
    }

    @AfterAll
    static void finalizarPruebas() {
        System.out.println("Todas las pruebas de Curso han terminado.");
    }
}
