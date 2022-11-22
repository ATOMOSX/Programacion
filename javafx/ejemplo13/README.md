# Ejemplo 13
Ejemplo de JavaFX que muestra una ventana con un botón, al dar clic en el botón se muestra una imagen.

## Tools

- java 11
- junit 5.4.0
- JavaFX 19
- maven


## Class and Interfaces

### MainApp
Inicia la aplicación cargando la ventana hello-view

```java
public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("image-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
```


### ImageController
Controlador de la ventana. Contiene el método que responde a la acción de clic sobre el botón. 

```java
public class ImageController {
    @FXML
    private ImageView image;

    @FXML
    protected void onHelloButtonClick() {
        image.setVisible(true);
    }
}
```

## Vista

### image-view.fxml
Representa la venta. Actualmente, una ventana con una imagen y ub botón. La ventana apunta a la clase ImageController como controlador de la ventana.

```xml
<VBox alignment="CENTER" spacing="20.0" xmlns:fx="http://javafx.com/fxml/1" xmlns="http://javafx.com/javafx/18" fx:controller="co.edu.uniquindio.ingesis.javafx.ejemplo.ImageController">
    <padding>
        <Insets bottom="20.0" left="20.0" right="20.0" top="20.0" />
    </padding>
    <ImageView fx:id="image" fitHeight="150.0" fitWidth="200.0" pickOnBounds="true" preserveRatio="true" visible="false">
        <Image url="@images.png"/>
    </ImageView>
    <Button onAction="#onHelloButtonClick" text="Hello!" />
</VBox>
```