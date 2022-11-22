# Ejemplo 10
Ejemplo que muestra una tabla con los datos de un listado de personas.

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
    private TableView tblPersonas;
    @FXML
    private TableColumn<Persona,String> colNumeroIdentificacion;
    @FXML
    private TableColumn<Persona,String> colNombre;
    @FXML
    private TableColumn<Persona,String> colApellido;

    @FXML
    public void initialize(){
        tblPersonas.setItems(FXCollections.observableArrayList(
                Persona.of("12345","Pedro","Perez"),
                Persona.of("13458","Juan","Ramirez"),
                Persona.of("63096","Jenny","Roa")
        ));

        colNumeroIdentificacion.setCellValueFactory(new PropertyValueFactory<>("numeriIdentificacion"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
    }
}
```

## Vista

### persona-view.fxml
Representa la venta. Actualmente, una ventana con una tabla para mostrar los datos de las personas. La ventana apunta a la clase PersonaController como controlador de la ventana.

```xml
<VBox alignment="CENTER" spacing="20.0" xmlns="http://javafx.com/javafx/18" xmlns:fx="http://javafx.com/fxml/1"
      fx:controller="co.edu.uniquindio.ingesis.javafx.ejemplo.PersonaController">
    <padding>
        <Insets bottom="20.0" left="20.0" right="20.0" top="20.0"/>
    </padding>
    <children>
        <TableView fx:id="tblPersonas" prefHeight="200.0" prefWidth="200.0">
            <columns>
                <TableColumn fx:id="colNumeroIdentificacion" prefWidth="75.0" text="Número Identificación"/>
                <TableColumn fx:id="colNombre" prefWidth="75.0" text="Nombre"/>
                <TableColumn fx:id="colApellido" prefWidth="75.0" text="Apellido"/>
            </columns>
        </TableView>
    </children>
</VBox>
```