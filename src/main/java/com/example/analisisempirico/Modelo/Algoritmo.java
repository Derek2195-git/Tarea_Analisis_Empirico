package com.example.analisisempirico.Modelo;

public class Algoritmo {

    public static long sumatoria0aN(long n) {
        long sumatoria = 0;
        for (int i = 0; i <= n; i++) {
            sumatoria += i;
        }
        return sumatoria;
    }

    public static long sumatoria0aNRecursiva(long n) {
        if (n <= 0) return n;
        return n + sumatoria0aNRecursiva(n - 1);
    }

    public static long sumatoria0aNGauss(long n) {
        return (n * (n + 1)) / 2;
    }
}

