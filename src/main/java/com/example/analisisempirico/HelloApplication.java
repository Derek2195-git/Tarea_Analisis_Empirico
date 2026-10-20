package com.example.analisisempirico;

import com.example.analisisempirico.Controlador.Controlador;
import com.example.analisisempirico.Vista.VentanaPrincipal;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        VentanaPrincipal vista = new VentanaPrincipal();
        Controlador controlador = new Controlador(vista);

        Scene scene = new Scene(vista, 800, 600);
        scene.getStylesheets().add(getClass().getResource("estilos.css").toExternalForm());

        stage.setTitle("Graficas");
        stage.setScene(scene);
        stage.show();
    }
}
