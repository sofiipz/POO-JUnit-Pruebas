package com.dam.junit.ejercicio10;

public class Coche {
    private String marca;
    private String modelo;
    private double velocidad;
    private boolean encendido;

    private static final double VELOCIDAD_MAXIMA = 200; //constante

    // constructor
    public Coche(String marca, String modelo) {

        this.marca = marca;
        this.modelo = modelo;
        this.velocidad = 0;
        this.encendido = false;
    }


    //métodos
    // arrancar el coche
    public void arrancar() {

        encendido = true;
        System.out.println("El coche está arrancado.");
    }

    // apagar el coche
    public void apagar() {
        encendido = false;
        velocidad = 0;
        System.out.println("El coche está apagado.");
    }

    // acelerar el coche
    public void acelerar(double incremento) {

        if (encendido) {

            if (velocidad + incremento <= VELOCIDAD_MAXIMA) {
                velocidad += incremento;
            } else {
                velocidad = VELOCIDAD_MAXIMA;
            }
            System.out.println("Velocidad: " + velocidad + " km/h.");
        
        } else {
            System.out.println("El coche no está arrancado.");
        }
    }

    // frenar el coche
    public void frenar(double decremento) {

        if (encendido) {

            if (velocidad - decremento >= 0) {
                velocidad -= decremento; 
            } else {
                velocidad = 0; 
            }
            System.out.println("Velocidad: " + velocidad + " km/h.");
        
        } else {
            System.out.println("El coche no está arrancado.");
        }
    }


    // la velocidad actual
    public double getVelocidad() {
        return velocidad;
    }

    // comprobar si el coche está encendido
    public boolean Encendido() {
        return encendido;
    }
}

