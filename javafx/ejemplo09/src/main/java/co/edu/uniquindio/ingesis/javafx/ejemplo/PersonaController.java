package co.edu.uniquindio.ingesis.javafx.ejemplo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;

import java.util.Date;
import java.util.Stack;

public class PersonaController {

    @FXML
    private Label id;
    @FXML
    private TextField id1;
    @FXML
    private TextField nombre1;
    @FXML
    private TextField apellido1;
    @FXML
    private TextField email1;
    @FXML
    private DatePicker dpFecha;


   /*@FXML
    protected void onAceptarButtonClick() {
        id.setText("Hola, Sus datos son "+id1.getText() +" "+ nombre1.getText()  +" "+ apellido1.getText()
                +" "+ email1.getText()  +" "+ dpFecha.getValue());

    }*/
    public void onAceptarButtonClick(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Hola, Sus datos son "+id1.getText() +" "+ nombre1.getText()  +" "+ apellido1.getText()
                +" "+ email1.getText()  +" "+ dpFecha.getValue());
        alert.showAndWait();
    }


}