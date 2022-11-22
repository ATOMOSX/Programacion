# Ejemplo 05
Ejemplo de JavaFX que muestra una ventana con un botón y una lista desplegable. Al dar clic en el botón se muestra un mensaje seleccionó + el texto que de la opción seleccionada en la lista.

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
Controlador de la ventana. Contiene el método que responde a la acción de clic sobre el botón. 
De igual forma contiene el método initialize que permite inicializar los elementos a mostrar en la lista de opciones. 

```java
public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private ComboBox<String> cbOpciones;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("seleccionó "+cbOpciones.getValue());
    }

    @FXML
    public void initialize(){
        cbOpciones.getItems().add("Opcion 1");
        cbOpciones.getItems().add("Opcion 2");
        cbOpciones.getItems().add("Opcion 3");
        cbOpciones.getItems().add("Opcion 4");
    }
}
```

## Vista

### hello-view.fxml
Representa la venta. Actualmente, una ventana con un label, una lista de selección y ub botón. La ventana apunta a la clase HelloController como controlador de la ventana.

```xml
<VBox alignment="CENTER" prefHeight="147.0" prefWidth="227.0" spacing="20.0" xmlns="http://javafx.com/javafx/18" xmlns:fx="http://javafx.com/fxml/1" fx:controller="co.edu.uniquindio.ingesis.javafx.ejemplo.HelloController">
    <padding>
        <Insets bottom="20.0" left="20.0" right="20.0" top="20.0" />
    </padding>

    <Label fx:id="welcomeText" />
    <ComboBox fx:id="cbOpciones" prefHeight="25.0" prefWidth="181.0" promptText="Seleccione una opción" />
    <Button onAction="#onHelloButtonClick" text="Aceptar" />
</VBox>
```