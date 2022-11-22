package co.edu.uniquindio.ingesis.javafx.ejemplo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Programando ventanas con Javafx");
    }
}