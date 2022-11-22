package co.edu.uniquindio.ingesis.javafx.ejemplo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField tfTexto;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Bienvenido "+tfTexto.getText());
    }
}