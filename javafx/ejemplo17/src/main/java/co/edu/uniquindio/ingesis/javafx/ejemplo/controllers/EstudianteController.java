package co.edu.uniquindio.ingesis.javafx.ejemplo.controllers;

import co.edu.uniquindio.ingesis.javafx.ejemplo.exceptions.NotaInvalidaException;
import co.edu.uniquindio.ingesis.javafx.ejemplo.model.Estudiante;
import co.edu.uniquindio.ingesis.javafx.ejemplo.model.Genero;
import co.edu.uniquindio.ingesis.javafx.ejemplo.utils.TextFormatterUtil;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

import static co.edu.uniquindio.ingesis.javafx.ejemplo.controllers.AppController.INSTANCE;

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