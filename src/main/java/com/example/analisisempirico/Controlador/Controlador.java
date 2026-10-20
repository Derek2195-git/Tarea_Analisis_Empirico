package com.example.analisisempirico.Controlador;

import com.example.analisisempirico.Modelo.Algoritmo;
import com.example.analisisempirico.Vista.VentanaPrincipal;
import javafx.scene.chart.XYChart;

public class Controlador {
    private VentanaPrincipal ventana;
    private final static int MAX = 100000000;

    public Controlador(VentanaPrincipal ventana) {
        this.ventana = ventana;
        inicializarBotones();
    }

    public void inicializarBotones() {
        ventana.alGraficarMetodoIterativo(this::crearGraficaIterativa);
        ventana.alGraficarMetodoRecursivo(this::crearGraficaRecursiva);
        ventana.alGraficarMetodoGaussiano(this::crearGraficaGauss);
    }

    public void crearGraficaIterativa() {
        XYChart.Series<Number, Number> serie = new XYChart.Series<>();
        for (int i = 100; i < MAX; i *= 10) {
            long startTime = System.nanoTime();
            Algoritmo.sumatoria0aN(i);
            long endTime = System.nanoTime();

            long tiempoTotal = endTime-startTime;
            serie.getData().add(new XYChart.Data<>(i, tiempoTotal));
        }

        ventana.getGrafica().mostrarGrafica("Método iterativo", serie);
    }

    public void crearGraficaRecursiva() {
        XYChart.Series<Number, Number> serie = new XYChart.Series<>();
        for (int i = 100; i < MAX; i *= 10) {
            try {
                long startTime = System.nanoTime();
                Algoritmo.sumatoria0aNRecursiva(i);
                long endTime = System.nanoTime();

                long tiempoTotal = endTime-startTime;
                serie.getData().add(new XYChart.Data<>(i, tiempoTotal));
            } catch (StackOverflowError e) {
                System.out.println("No se pudo gráficar más alla de la iteración " + i +
                        ".");
                break;
            }
        }
        ventana.getGrafica().mostrarGrafica("Método recursivo", serie);
    }

    public void crearGraficaGauss() {
        XYChart.Series<Number, Number> serie = new XYChart.Series<>();
        for (int i = 100; i < MAX; i *= 10) {
            long startTime = System.nanoTime();
            Algoritmo.sumatoria0aNGauss(i);
            long endTime = System.nanoTime();

            long tiempoTotal = endTime-startTime;
            serie.getData().add(new XYChart.Data<>(i, tiempoTotal));
        }
        ventana.getGrafica().mostrarGrafica("Método de Gauss", serie);
    }

}
