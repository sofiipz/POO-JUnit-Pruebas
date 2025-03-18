package com.dam.junit.ejercicio3;


import java.util.ArrayList;
import java.util.List;


public class CuentaBancariaAmpliada {
    
    private double saldo;
    private double saldoMinimo = 0; // No permite saldo negativo
    private List<String> historialTransacciones = new ArrayList<>();

    public CuentaBancariaAmpliada(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            historialTransacciones.add("Depósito: +" + cantidad);
        }
    }

    public boolean retirar(double cantidad) {
        if (cantidad > 0 && saldo - cantidad >= saldoMinimo) {
            saldo -= cantidad;
            historialTransacciones.add("Retiro: -" + cantidad);
            return true;
        }
        return false;
    }

    public boolean transferir(CuentaBancariaAmpliada destino, double cantidad) {
        if (retirar(cantidad)) {
            destino.depositar(cantidad);
            historialTransacciones.add("Transferencia: -" + cantidad + " a " + destino);
            return true;
        }
        return false;
    }

    public List<String> getHistorialTransacciones() {
        return historialTransacciones;
    }

    public void aplicarInteres(double porcentaje) {
        if (porcentaje > 0) {
            double interes = saldo * (porcentaje / 100);
            depositar(interes);
        }
    }
}
