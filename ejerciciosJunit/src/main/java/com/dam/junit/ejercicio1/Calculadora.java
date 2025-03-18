package com.dam.junit.ejercicio1;

    public class Calculadora {
    
        public int sumar(int a, int b) {
            return a + b;
        }
    
        public int restar(int a, int b) {
            return a - b;
        }
    
        public int multiplicar(int a, int b) {
            return a * b;
        }
    
        public double dividir(int a, int b) {
            if (b == 0) {
                return Double.NaN; // En lugar de lanzar una excepción, devolvemos Double.NaN.
            }
            return (double) a / b;
        }

        /*  public double dividir(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }
        return (double) a / b;
        } */

    }

