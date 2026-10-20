module com.example.analisisempirico {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.analisisempirico to javafx.fxml;
    exports com.example.analisisempirico;
}