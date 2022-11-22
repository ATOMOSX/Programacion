# Ejemplo 00
Primer ejemplo de JavaFX, muestra una ventana con un hola mundo.

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
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("empty-view.fxml"));
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


### EmptyController
Controlador de la ventana. Actualmente no tiene contenido. 

## Vista

### empty-view.fxml
Representa la venta. Actualmente, una ventana vacía que apunta a la clase EmptyController como controlador de la ventana.

```xml
<VBox alignment="CENTER" spacing="20.0" xmlns:fx="http://javafx.com/fxml"
      fx:controller="co.edu.uniquindio.ingesis.javafx.ejemplo.EmptyController">

</VBox>
```