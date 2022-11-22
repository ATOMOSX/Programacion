# Ejemplo16
EJERCICIO PREPARCIAL

El proyecto permite registrar los estudiantes de un diplomado. De cada estudiante que se va a registrar en el diplomado se le solicita número de identificación, nombre y género (Masculino/ Femenenino).
El género de la persona es ingresado mediante el uso de un combobox.

Debe desarrollar la clase EstudianteController para la interfaz de usuario de la aplicación con sus respectivos métodos.


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
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("diplomado-estudiante-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 450);
        stage.setTitle("Diplomado de Programación!!!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
```


### PersonaController
Controlador de la ventana. Contiene los métodos y lógica de interacción con el usuario. 

```java
public class EstudianteController {
    @FXML
    private TableView<Estudiante> tblEstudiantes;
    @FXML
    private TableColumn<Estudiante, String> colNumeroIdentificacion;
    @FXML
    private TableColumn<Estudiante, String> colNombre;
    @FXML
    private TableColumn<Estudiante, Genero> colGenero;
    @FXML
    private TextField tfNumeroIdentificacion;
    @FXML
    private TextField tfNombre;
    @FXML
    private ComboBox<Genero> cbGenero;
    @FXML
    public TextField tfNota;
    @FXML
    public Label lbNotas;
    private Estudiante estudianteSeleccionado;

    @FXML
    public void initialize() {
        llenarTabla(INSTANCE.getDiplomado().buscar( null, null,null));
        colNumeroIdentificacion.setCellValueFactory(new PropertyValueFactory<>("numeroIdentificacion"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        tblEstudiantes.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> llenarCampos(newValue));
        tfNumeroIdentificacion.setTextFormatter(new TextFormatter<>(TextFormatterUtil::integerFormat));
        tfNombre.setTextFormatter(new TextFormatter<>(TextFormatterUtil::upperCaseFormat));
        cbGenero.setItems(FXCollections.observableArrayList(Genero.values()));
        tfNota.setTextFormatter(new TextFormatter<>(TextFormatterUtil::decimalFormat));
        estudianteSeleccionado = null;
    }

    public void onRegistrarClick() {
        try {
            Estudiante estudiante = Estudiante.of(tfNumeroIdentificacion.getText(), tfNombre.getText(), cbGenero.getValue());
            INSTANCE.getDiplomado().registrarEstudiante(estudiante);
            llenarTabla(INSTANCE.getDiplomado().buscar(null, null, null));
            limpiarCampos();
            mostrarInformacion("El estudiante fue aceptado en el diplomado");
        } catch (Exception e) {
            mostrarMensaje(e.getMessage());
        }
    }

    public void onCancelarClick() {
        limpiarCampos();
        tblEstudiantes.getSelectionModel().clearSelection();
    }

    public void onRemoverClick() {
        try {
            INSTANCE.getDiplomado().cancelarRegistro(tfNumeroIdentificacion.getText());
            llenarTabla(INSTANCE.getDiplomado().buscar(null, null,null));
            limpiarCampos();
            mostrarInformacion("El estudiante fue retirado del diplomado");
        } catch (Exception e) {
            mostrarMensaje(e.getMessage());
        }
    }

    public void onBuscarClick() {
        llenarTabla(
                INSTANCE.getDiplomado().buscar(tfNumeroIdentificacion.getText(), tfNombre.getText(),cbGenero.getValue())
        );
    }

    private void llenarCampos(Estudiante estudiante) {
        estudianteSeleccionado = estudiante;
        if (estudiante != null) {
            tfNumeroIdentificacion.setText(estudiante.getNumeroIdentificacion());
            tfNombre.setText(estudiante.getNombre());
            cbGenero.setValue(estudiante.getGenero());
            lbNotas.setText(estudiante.getNotasAsString());
        }
    }

    private void limpiarCampos() {
        tfNumeroIdentificacion.setText("");
        tfNombre.setText("");
        cbGenero.setValue(null);
        lbNotas.setText("");
    }

    private void llenarTabla(List<Estudiante> estudiantes) {
        tblEstudiantes.setItems(FXCollections.observableArrayList(estudiantes));
        tblEstudiantes.refresh();
    }

    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Error");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void mostrarInformacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public void adicionarNota() {
        if( estudianteSeleccionado != null ){
            try {
                estudianteSeleccionado.adicionarNota(Float.parseFloat(tfNota.getText()));
                lbNotas.setText(estudianteSeleccionado.getNotasAsString());
            } catch (NotaInvalidaException e) {
                mostrarMensaje(e.getMessage());
            }
        }
    }
}
```

### AppController
Clase que contiene los elementos generales de la lógica de la aplicación y permite a la gui acceder a ellos.

```java
public enum AppController {
    INSTANCE;
    private final Diplomado diplomado;

    AppController() {
        diplomado = new Diplomado("Programación",10);
    }

    public Diplomado getDiplomado() {
        return diplomado;
    }
}
```

### EstudianteExisteException
Excepción generada cuando se intenta ingresar un estudiante que ya se ha registrado previamente.

```java
public class EstudianteExisteException extends Exception{
    public EstudianteExisteException(Estudiante estudiante) {
        super(String.format("El estududiante con número de identificación %s ya existe",estudiante.getNumeroIdentificacion()));
    }
}
```

### EstudianteNoExisteException
Excepción generada cuando se intenta remover un estudiante que no se ha registrado previamente.

```java
public class EstudianteNoExisteException extends Exception {
    public EstudianteNoExisteException() {
        super("La persona no existe");
    }
}
```
### NotaInvalidaException
Excepción generada cuando se ingresa una nota no válida.

```java
public class NotaInvalidaException extends Exception{
    public NotaInvalidaException() {
        super("Nota invalida: la nota debe ser mayor o igual a 0 y menor o igual a 5");
    }
}
```
### ValorRequeridoException
Excepción generada cuando se omite un valor requerido en alguna de las operaciones.

```java
public class ValorRequeridoException extends Exception{
    public ValorRequeridoException(String nombre) {
        super(String.format("El %s es requerido",nombre));
    }
}
```
### Genero
Enumeración que representa el género dela persona.

```java
public enum Genero {
    FEMENINO,
    MASCULINO
}
```

### Diplomado
Clase que representa el diplomado en el que se registraran los estudiantes.

```java
public class Diplomado {
    private final String nombre;
    private final List<Estudiante> estudiantes;
    private final int cupo;

    public Diplomado(String nombre, int cupo) {
        this.nombre = nombre;
        this.cupo = cupo;
        estudiantes = new ArrayList<>();
    }

    public void registrarEstudiante(Estudiante nuevoEstudiante) throws EstudianteExisteException {
        if( buscarEstudiante(nuevoEstudiante.getNumeroIdentificacion()).isPresent() ){
            throw new EstudianteExisteException(nuevoEstudiante);
        }
        estudiantes.add(nuevoEstudiante);
    }

    public void cancelarRegistro(String numeroIdentificacion) throws EstudianteNoExisteException {
        Estudiante estudiante = buscarEstudiante(numeroIdentificacion).orElseThrow(EstudianteNoExisteException::new);
        estudiantes.remove(estudiante);
    }
    public Optional<Estudiante> buscarEstudiante(String numeroIdentificacion ){
        return estudiantes.stream()
                .filter(estudiante -> estudiante.getNumeroIdentificacion().equals(numeroIdentificacion))
                .findFirst();
    }

    public List<Estudiante> buscarGanaron(int parcial){
        return estudiantes.stream()
                .filter(estudiante -> estudiante.getNota(parcial)>=3)
                .collect(Collectors.toList());
    }

    public List<Estudiante> buscarPerdieron(int parcial){
        return estudiantes.stream()
                .filter(estudiante -> estudiante.getNota(parcial)<3)
                .collect(Collectors.toList());
    }

    public Reporte generarReporte(int parcial){
        return new Reporte("Reporte: Parcial "+parcial,
                estudiantes.stream()
                        .map(EstudianteUtil.toEstudianteNotaDTO(parcial))
                        .collect(Collectors.toList())
        );
    }

    public List<Estudiante> buscar(String numeroIdentificacion,String nombre,Genero genero){
        return estudiantes.stream()
                .filter(EstudianteBusquedaUtil.buscarPorTodo(numeroIdentificacion, nombre, genero))
                .collect(Collectors.toUnmodifiableList());
    }
}
```

### Estudiante
Clase que representa los estudiantes registrados en el diplomado.

```java
public class Estudiante {
    private final String numeroIdentificacion;
    private final String nombre;
    private final Genero genero;
    private final List<Float> notas;
    private Estudiante(String numeroIdentificacion, String nombre, Genero genero) {
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombre = nombre;
        this.genero = genero;
        notas = new ArrayList<>();
    }

    public static Estudiante of(String numeroIdentificacion, String nombre, Genero genero) throws ValorRequeridoException {
        if(Objects.requireNonNull(numeroIdentificacion,"El número de identificación es requerido").isEmpty()){
            throw new ValorRequeridoException("número de identificación");
        }
        if(Objects.requireNonNull(nombre,"El nombre es requerido").isEmpty()){
            throw new ValorRequeridoException("nombre");
        }
        Objects.requireNonNull(genero,"El genero es requerido");

        return new Estudiante(numeroIdentificacion, nombre, genero);
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public Genero getGenero() {
        return genero;
    }

    public void adicionarNota(float nota) throws NotaInvalidaException {
        if( nota < 0 || nota > 5){
            throw new NotaInvalidaException();
        }
        notas.add(nota);
    }

    public float calcularPromedio(){
        return (float) notas.stream().mapToDouble(Double::valueOf).average().getAsDouble();
    }

    public float getNota(int parcial){
        return notas.get(parcial);
    }

    public List<Float> getNotas() {
        return Collections.unmodifiableList(notas);
    }

    public String getNotasAsString(){
        return notas.stream().map(String::valueOf).collect(Collectors.joining(","));
    }

    public float getMaxNota(){
        return (float) notas.stream().mapToDouble(Double::valueOf).max().getAsDouble();
    }

    public float getMinNota(){
        return (float) notas.stream().mapToDouble(Double::valueOf).min().getAsDouble();
    }
}
```

### EstudianteNotaDTO
Clase auxiliar empleada para representar información parcial de un estudiante.

```java
public class EstudianteNotaDTO {
    private final String numeroIdentificacion;
    private final String nombre;
    private final float nota;
    private EstudianteNotaDTO(String numeroIdentificacion, String nombre, float nota) {
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombre = nombre;
        this.nota = nota;
    }

    public static EstudianteNotaDTO of(String numeroIdentificacion, String nombre, float nota) {
        Objects.requireNonNull(numeroIdentificacion,"El número de identificación es requerido");
        Objects.requireNonNull(nombre,"El nombre es requerido");
        return new EstudianteNotaDTO(numeroIdentificacion, nombre, nota);
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public float getNota() {
        return nota;
    }
}
```

### Reporte
Clase usada para modelar un reporte de las notas de los estudiantes en un parcial.

```java
public class Reporte {
    private final float notaMaxima;
    private final float notaMinima;
    private final float notaPromedio;
    private final int numeroGanaron;
    private final int numeroPerdieron;
    private final String nombre;
    private final List<EstudianteNotaDTO> estudiantes;

    public Reporte(String nombre, List<EstudianteNotaDTO> estudiantes) {
        this.nombre = nombre;
        this.estudiantes = estudiantes;
        DoubleStream stream = estudiantes.stream().mapToDouble(EstudianteNotaDTO::getNota);
        DoubleSummaryStatistics statistics = stream.summaryStatistics();
        notaMaxima = (float) statistics.getMax();
        notaMinima = (float) statistics.getMin();
        notaPromedio = (float) statistics.getAverage();
        numeroPerdieron = (int) stream.filter(nota->nota<3).count();
        numeroGanaron = estudiantes.size() - numeroPerdieron;
    }

    public float getNotaMaxima() {
        return notaMaxima;
    }

    public float getNotaMinima() {
        return notaMinima;
    }

    public float getNotaPromedio() {
        return notaPromedio;
    }

    public int getNumeroGanaron() {
        return numeroGanaron;
    }

    public int getNumeroPerdieron() {
        return numeroPerdieron;
    }

    public String getNombre() {
        return nombre;
    }

    public List<EstudianteNotaDTO> getEstudiantes() {
        return Collections.unmodifiableList(estudiantes);
    }

    public List<EstudianteNotaDTO> ordenarPorNombre() {
        return estudiantes.stream()
                .sorted(Comparator.comparing(EstudianteNotaDTO::getNombre))
                .collect(Collectors.toList());
    }

    public List<EstudianteNotaDTO> ordenarPorNumeroIdentificacion() {
        return estudiantes.stream()
                .sorted(Comparator.comparing(EstudianteNotaDTO::getNumeroIdentificacion))
                .collect(Collectors.toList());
    }

    public List<EstudianteNotaDTO> ordenarPorNota() {
        return estudiantes.stream()
                .sorted(Comparator.comparingDouble(EstudianteNotaDTO::getNota))
                .collect(Collectors.toList());
    }

}
```

### EstudianteBusquedaUtil
Clase utilitaria que permite crear predicados para realizar búsquedas basadas en estudiantes.

```java
public class EstudianteBusquedaUtil {
    public static Predicate<Estudiante> buscarPorNumeroIdentificacion(String numeroIdentificacion){
        return estudiante -> estudiante.getNumeroIdentificacion().equals(numeroIdentificacion);
    }

    public static Predicate<Estudiante> buscarPorNombre(String nombre){
        return estudiante -> estudiante.getNombre().contains(nombre);
    }
    public static Predicate<Estudiante> buscarPorGenero(Genero genero) {
        return estudiante -> estudiante.getGenero() == genero;
    }
    public static Predicate<Estudiante> buscarPorTodo(String numeroIdentificacion, String nombre, Genero genero) {
        Predicate<Estudiante> predicado = estudiante -> true;
        if( numeroIdentificacion != null && !numeroIdentificacion.isEmpty() ){
            predicado = predicado.and(buscarPorNumeroIdentificacion(numeroIdentificacion));
        }
        if( nombre != null && !nombre.isEmpty() ){
            predicado = predicado.and(buscarPorNombre(nombre));
        }
        if( genero != null ){
            predicado = predicado.and(buscarPorGenero(genero));
        }
        return predicado;
    }
}
```

### EstudianteUtil
Clase utilitaria que permite convertir un Estudiante en un EstudianteNotaDTO.

```java
public class EstudianteUtil {
    public static Function<Estudiante,EstudianteNotaDTO> toEstudianteNotaDTO(int parcial){
        return estudiante -> EstudianteNotaDTO.of(estudiante.getNumeroIdentificacion(), estudiante.getNombre(), estudiante.getNota(parcial));
    }
}
```

### TextFormatterUtil
Clase utilitaria que permite contiene métodos usados para dar formato a las entradas en los campos de textos.

```java
public class TextFormatterUtil {
    public static Change upperCaseFormat(Change change){
        change.setText(change.getText().toUpperCase());
        return change;
    }

    public static Change integerFormat(Change change){
        if (change.getText().matches("[0-9]*")) {
            return change;
        }
        return null;
    }

    public static Change decimalFormat(Change change){
        if (change.getControlNewText().matches("^\\d*\\.\\d+|\\d+\\.\\d*|\\d+$")) {
            return change;
        }
        return null;
    }
}
```

## Vista

### diplomado-estudiante-view.fxml
Representa la venta. Actualmente, una ventana con una tabla, campos de texto para el ingreso de estudiantes y los botones para la interacción del usuario. 
La ventana apunta a la clase EstudianteController como controlador de la ventana.

```xml
<VBox alignment="CENTER" prefHeight="460.0" prefWidth="432.0" spacing="20.0" xmlns="http://javafx.com/javafx/18" xmlns:fx="http://javafx.com/fxml/1" fx:controller="co.edu.uniquindio.ingesis.javafx.ejemplo.controllers.EstudianteController">
    <padding>
        <Insets bottom="20.0" left="20.0" right="20.0" top="20.0" />
    </padding>
    <GridPane>
        <columnConstraints>
            <ColumnConstraints hgrow="SOMETIMES" minWidth="10.0" prefWidth="100.0" />
            <ColumnConstraints hgrow="SOMETIMES" minWidth="10.0" prefWidth="100.0" />
        </columnConstraints>
        <rowConstraints>
            <RowConstraints minHeight="10.0" prefHeight="40.0" vgrow="SOMETIMES" />
            <RowConstraints minHeight="10.0" prefHeight="40.0" vgrow="SOMETIMES" />
            <RowConstraints minHeight="10.0" prefHeight="40.0" vgrow="SOMETIMES" />
            <RowConstraints minHeight="10.0" prefHeight="40.0" vgrow="SOMETIMES" />
            <RowConstraints minHeight="10.0" prefHeight="40.0" vgrow="SOMETIMES" />
        </rowConstraints>
        <Label text="Número de Identificación:" />
        <Label text="Nombre:" GridPane.rowIndex="1" />
        <Label text="Genero:" GridPane.rowIndex="2" />
        <Label text="Notas:" GridPane.rowIndex="3" />
        <TextField fx:id="tfNumeroIdentificacion" GridPane.columnIndex="1" />
        <TextField fx:id="tfNombre" GridPane.columnIndex="1" GridPane.rowIndex="1" />
        <ComboBox fx:id="cbGenero" promptText="Seleccione el género" GridPane.columnIndex="1" GridPane.rowIndex="2" />
        <Label fx:id="lbNotas" prefHeight="17.0" prefWidth="154.0" GridPane.columnIndex="1" GridPane.rowIndex="3" />
        <HBox alignment="CENTER_LEFT" prefHeight="45.0" prefWidth="392.0" GridPane.columnIndex="1" GridPane.rowIndex="4">
            <TextField fx:id="tfNota" prefHeight="25.0" prefWidth="97.0" />
            <Button mnemonicParsing="false" onAction="#adicionarNota" text="Adicionar Nota" />
        </HBox>
    </GridPane>
    <HBox prefHeight="41.0" prefWidth="301.0">
        <Button mnemonicParsing="false" onAction="#onRegistrarClick" text="Registrar" />
        <Button mnemonicParsing="false" onAction="#onCancelarClick" text="Cancelar" />
        <Button mnemonicParsing="false" onAction="#onRemoverClick" text="Retirar" />
        <Button mnemonicParsing="false" onAction="#onBuscarClick" text="Buscar" />
    </HBox>
    <TableView fx:id="tblEstudiantes" prefHeight="200.0" prefWidth="200.0">
        <columns>
            <TableColumn fx:id="colNumeroIdentificacion" prefWidth="126.0" text="Número Identificación" />
            <TableColumn fx:id="colNombre" prefWidth="177.0" text="Nombre" />
            <TableColumn fx:id="colGenero" prefWidth="79.0" text="Genero" />
        </columns>
    </TableView>
</VBox>
```