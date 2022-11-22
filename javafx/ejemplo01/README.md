# Ejemplo 01
Ejemplo de JavaFX que muestra una ventana con un hola mundo en una etiqueta.

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
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("hello-view.fxml"));
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


### HelloController
Controlador de la ventana. Actualmente no tiene contenido. 

## Vista

### hello-view.fxml
Representa la venta. Actualmente, una ventana con un label el cual contiene el texto "Hola Mundo !!!". La ventana apunta a la clase HelloController como controlador de la ventana.

```xml
<VBox alignment="CENTER" spacing="20.0" xmlns:fx="http://javafx.com/fxml"
      fx:controller="co.edu.uniquindio.ingesis.javafx.ejemplo.HelloController">
    <padding>
        <Insets bottom="20.0" left="20.0" right="20.0" top="20.0"/>
    </padding>

    <Label text="Hola Mundo !!!"/>
</VBox>

```