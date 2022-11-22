package co.edu.uniquindio.ingesis.javafx.ejemplo;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class ImageController {
    @FXML
    private ImageView image;

    @FXML
    protected void onHelloButtonClick() {
        image.setVisible(true);
    }
}