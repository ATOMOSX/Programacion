package co.edu.uniquindio.ingesis.javafx.ejemplo;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private ComboBox<String> cbOpciones;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText(" "+cbOpciones.getValue());
    }

    @FXML
    public void initialize(){
        cbOpciones.getItems().add("Jugar");
        cbOpciones.getItems().add("Estudiar");
        cbOpciones.getItems().add("Dormir");
        cbOpciones.getItems().add("Bañar la perrita");
    }
}