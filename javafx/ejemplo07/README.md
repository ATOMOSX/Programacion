# Ejemplo 07
Ejemplo de JavaFX que muestra una ventana con un botón, al dar clic en el botón se muestra una segunda ventana cerrando la primera.

## Tools

- java 11
- junit 5.4.0
- JavaFX 19
- maven


## Class and Interfaces

### MainApp
Inicia la aplicación cargando la ventana login-view

```java
public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
```


### LoginController
Controlador de la ventana. Contiene el método que responde a la acción de clic sobre el botón. 

```java
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
```
### PrincipalController
Controlador de la ventana principal. No contiene elementos.

```java
public class PrincipalController {

}
```
## Vista

### login-view.fxml
Representa la venta. Actualmente, una ventana con un botón. La ventana apunta a la clase LoginController como controlador de la ventana.
De igual forma apunta al método onLoginButtonClick de la clase LoginController para ser ejecutado cuando el usuario de clic en el botón.

```xml
<VBox alignment="CENTER" spacing="20.0" xmlns:fx="http://javafx.com/fxml/1" xmlns="http://javafx.com/javafx/18" fx:controller="co.edu.uniquindio.ingesis.javafx.ejemplo.LoginController">
    <padding>
        <Insets bottom="20.0" left="20.0" right="20.0" top="20.0" />
    </padding>
    <Button onAction="#onLoginButtonClick" text="Aceptar" fx:id="btnLogin" />
</VBox>
```

### principal-view.fxml
Representa la venta principal. Actualmente, una ventana con una etiqueta. La ventana apunta a la clase PrincipalController como controlador de la ventana.

```xml
<VBox alignment="CENTER" spacing="20.0" xmlns:fx="http://javafx.com/fxml"
      fx:controller="co.edu.uniquindio.ingesis.javafx.ejemplo.PrincipalController">
    <padding>
        <Insets bottom="20.0" left="20.0" right="20.0" top="20.0"/>
    </padding>

    <Label text="Ventana Principal"/>
</VBox>
```
