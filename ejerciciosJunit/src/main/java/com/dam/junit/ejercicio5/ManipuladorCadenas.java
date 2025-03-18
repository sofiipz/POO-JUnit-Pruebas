package com.dam.junit.ejercicio5;

public class ManipuladorCadenas {

    public String convertirMayusculas(String texto) {
        return texto.toUpperCase();
    }

    public String invertirCadena(String texto) {
        return new StringBuilder(texto).reverse().toString();
    }

    public int contarVocales(String texto) {
        int contador = 0;
        String vocales = "aeiouAEIOU";
        for (char c : texto.toCharArray()) {
            if (vocales.indexOf(c) != -1) {
                contador++;
            }
        }
        return contador;
    }

    public String concatenar(String texto1, String texto2) {
        return texto1 + texto2;
    }

    public boolean esPalindromo(String texto) {
        String limpio = texto.replaceAll("\\s+", "").toLowerCase();
        return limpio.equals(new StringBuilder(limpio).reverse().toString());
    }
}
