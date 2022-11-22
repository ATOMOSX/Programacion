package co.edu.uniquindio.ingesis.javafx.ejemplo;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

public class FechaController {
    @FXML
    private DatePicker dpFecha;
    @FXML
    private Label welcomeText;
    @FXML
    protected void onAceptarButtonClick() {
        welcomeText.setText("Hola "+dpFecha.getValue());
    }
}