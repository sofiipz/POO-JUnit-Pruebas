package com.dam.junit.ejercicio9;
import java.time.LocalDate;

public class Contrato {
    private static int totalContratos = 0;
    private String empresa;
    private String empleado;
    private String puesto;
    private double salario;
    private LocalDate fechaInicio;
    private int duracionMeses;
    private boolean esIndefinido;

    //constructor 1 para contratos con duración
    public Contrato(String empresa, String empleado, String puesto, double salario, LocalDate fechaInicio, int duracionMeses) {
        this.empresa = empresa;
        this.empleado = empleado;
        this.puesto = puesto;
        this.salario = salario;
        this.fechaInicio = fechaInicio;
        this.duracionMeses = duracionMeses;
        this.esIndefinido = false;
        totalContratos++;
    
    }

    //constructor 2 para contratos indefinidos
    public Contrato(String empresa, String empleado, String puesto, double salario, LocalDate fechaInicio) {

        this.empresa = empresa;
        this.empleado = empleado;
        this.puesto = puesto;
        this.salario = salario;
        this.fechaInicio = fechaInicio;
        this.esIndefinido = true;
        totalContratos++;

    }

    //métodos
    public void mostrarContrato() {

        System.out.println("Detalles del contrato: ");
        System.out.println("Empresa: " + empresa);
        System.out.println("Empleado: " + empleado);
        System.out.println("Puesto: " + puesto);
        System.out.println("Salario: " + salario + " euros/mes.");
        System.out.println("Fecha de inicio: " + fechaInicio);

        if (esIndefinido) {

            System.out.println("Duración: Indefinido");
        } else {
            System.out.println("Duración: " + duracionMeses + " meses.");
        }

        System.out.println();


    }

    public void aumentarSalario(double porcentaje) {
        salario += salario * porcentaje / 100;
    }

    public void renovarContrato(int meses) {
        if (!esIndefinido) {
            duracionMeses += meses;
        }
    }

    public String compararSalario(Contrato otroContrato) {
        if (this.salario > otroContrato.salario) {
            return "El contrato de " + empleado + " tiene un salario mayor.";

        } else if (this.salario < otroContrato.salario) {
            return "El contrato de " + otroContrato.empleado + " tiene un salario mayor.";
            
        } else {
            return "Los dos contratos tienen el mismo salario.";
        }
    }

    public void rescindirContrato() {
        totalContratos--;
    }

    public static int getTotalContratos() {
        return totalContratos;
    }

    public double getSalario() {
        return salario;
    }

    public int getDuracionMeses() {
        return duracionMeses;
    }

    public boolean esIndefinido() {
        return esIndefinido;
    }

    
    public static void resetTotalContratos() {
        totalContratos = 0;
    }



}

