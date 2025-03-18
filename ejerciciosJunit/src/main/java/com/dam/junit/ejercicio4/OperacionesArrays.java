package com.dam.junit.ejercicio4;

public class OperacionesArrays {

    public int suma(int[] numeros) {
        int resultado = 0;
        for (int num : numeros) {
            resultado += num;
        }
        return resultado;
    }

    public int producto(int[] numeros) {
        if (numeros.length == 0) return 0; //mejora para cuando el arrray esté vacío 
        int resultado = 1;
        for (int num : numeros) {
            resultado *= num;
        }
        return resultado;
    }

    public double promedio(int[] numeros) {
        if (numeros.length == 0) return 0;
        return (double) suma(numeros) / numeros.length;
    }

    public int maximo(int[] numeros) {
        int max = numeros[0];
        for (int num : numeros) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public int minimo(int[] numeros) {
        int min = numeros[0];
        for (int num : numeros) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
}
