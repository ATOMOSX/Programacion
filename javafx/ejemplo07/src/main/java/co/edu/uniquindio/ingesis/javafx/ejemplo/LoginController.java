package co.edu.uniquindio.ingesis.javafx.ejemplo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private Button btnLogin;
    @FXML
    protected void onLoginButtonClick() throws IOException {
        Parent parent = FXMLLoader.load(MainApp.class.getResource("principal-view.fxml"));
        Scene scene = new Scene(parent, 320, 240);
        Stage stage = new Stage();
        stage.setTitle("Principal");
        stage.setScene(scene);
        stage.initOwner(btnLogin.getScene().getWindow());
        btnLogin.getScene().getWindow().hide();
        stage.show();
    }
}
