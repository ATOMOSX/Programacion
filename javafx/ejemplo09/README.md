# Ejemplo 09
Ejercicio: Ejemplo de JavaFX que muestra una ventana con un botón y un cuadro de texto. Al dar clic en el botón se muestra un mensaje hola + el texto que haya sido ingresado en la caja de texto.
Modifíquelo para que permita el ingreso de los datos de una persona (número de identificación, nombre, apellido, email y fecha de nacimiento) y al dar clic muestre los datos de la persona en un cuadro de diálogo a modo de información.

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
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("persona-view.fxml"));
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


### PersonaController
Controlador de la ventana. Contiene el método que responde a la acción de clic sobre el botón. 

```java
public class PersonaController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField tfTexto;

    @FXML
    protected void onAceptarButtonClick() {
        welcomeText.setText("Hola "+tfTexto.getText());
    }
}
```

## Vista

### persona-view.fxml
Representa la venta. Actualmente, una ventana con un label, un campo de texto y ub botón. La ventana apunta a la clase PersonaController como controlador de la ventana.

```xml
<VBox alignment="CENTER" spacing="20.0" xmlns:fx="http://javafx.com/fxml/1" xmlns="http://javafx.com/javafx/18"
      fx:controller="co.edu.uniquindio.ingesis.javafx.ejemplo.PersonaController">
    <padding>
        <Insets bottom="20.0" left="20.0" right="20.0" top="20.0"/>
    </padding>

    <Label fx:id="welcomeText"/>
    <TextField fx:id="tfTexto" promptText="Ingrese su nombre"/>
    <Button onAction="#onAceptarButtonClick" text="Aceptar"/>
</VBox>
```