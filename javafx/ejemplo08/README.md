# Ejemplo 08
Ejemplo de JavaFX que muestra una ventana con un botón y un calendario. Al dar clic en el botón se muestra un mensaje Fecha seleccionada + la fecha que haya sido ingresado en la caja de texto.

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
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("fecha-view.fxml"));
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


### FechaController
Controlador de la ventana. Contiene el método que responde a la acción de clic sobre el botón. 

```java
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
```

## Vista

### fecha-view.fxml
Representa la venta. Actualmente, una ventana con un label, un calendario y ub botón. La ventana apunta a la clase FechaController como controlador de la ventana.

```xml
<VBox alignment="CENTER" spacing="20.0" xmlns="http://javafx.com/javafx/18" xmlns:fx="http://javafx.com/fxml/1"
      fx:controller="co.edu.uniquindio.ingesis.javafx.ejemplo.FechaController">
    <padding>
        <Insets bottom="20.0" left="20.0" right="20.0" top="20.0"/>
    </padding>

    <Label fx:id="welcomeText"/>
    <DatePicker fx:id="dpFecha"/>
    <Button onAction="#onAceptarButtonClick" text="Aceptar"/>
</VBox>
```