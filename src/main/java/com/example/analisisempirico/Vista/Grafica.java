package com.example.analisisempirico.Vista;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class Grafica {
    private LineChart<Number, Number> graficaLineal;
    private NumberAxis ejeX;
    private NumberAxis ejeY;

    public Grafica() {
        ejeX = new NumberAxis();
        ejeX.setLabel("Valor de N");

        ejeY = new NumberAxis();
        ejeY.setLabel("Tiempo de ejecución (en Nanosegundos)");

        graficaLineal = new LineChart<>(ejeX, ejeY);
        graficaLineal.setTitle("Comparación de tiempos de ejecución");
        graficaLineal.setAnimated(false);
        graficaLineal.setCreateSymbols(true);
    }

    public LineChart<Number, Number> getGraficaLineal() {
        return graficaLineal;
    }

    public void mostrarGrafica(String nombreAlgoritmo,
                               XYChart.Series<Number, Number> serie) {
        graficaLineal.getData().clear();
        serie.setName(nombreAlgoritmo);
        graficaLineal.getData().add(serie);
    }
}
