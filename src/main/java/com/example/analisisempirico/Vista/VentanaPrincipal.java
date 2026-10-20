package com.example.analisisempirico.Vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class VentanaPrincipal extends BorderPane {
    private Button botonIterativo;
    private Button botonRecursivo;
    private Button botonGauss;
    private Grafica grafica;

    public VentanaPrincipal() {
        grafica = new Grafica();

        botonIterativo = new Button("Gráfica iterativa");
        botonRecursivo = new Button("Gráfica recursiva");
        botonGauss = new Button("Gráfica usando el método de Gauss");

        HBox panelBotones = new HBox(15);
        panelBotones.setAlignment(Pos.CENTER);
        panelBotones.setPadding(new Insets(10));
        panelBotones.getChildren().addAll(botonIterativo, botonRecursivo, botonGauss);

        setTop(panelBotones);
        setCenter(grafica.getGraficaLineal());
    }

    public void alGraficarMetodoIterativo(Runnable accion) {
        botonIterativo.setOnAction(e -> accion.run());
    }

    public void alGraficarMetodoRecursivo(Runnable accion) {
        botonRecursivo.setOnAction(e -> accion.run());
    }

    public void alGraficarMetodoGaussiano(Runnable accion) {
        botonGauss.setOnAction(e -> accion.run());
    }

    public Grafica getGrafica() {
        return grafica;
    }
}
