package co.edu.uniquindio.ingesis.javafx.ejemplo.controllers;

import co.edu.uniquindio.ingesis.javafx.ejemplo.model.Persona;
import co.edu.uniquindio.ingesis.javafx.ejemplo.utils.TextFormatterUtil;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

import static co.edu.uniquindio.ingesis.javafx.ejemplo.controllers.AppController.INSTANCE;

public class PersonaController {
    @FXML
    private TableView<Persona> tblPersonas;
    @FXML
    private TableColumn<Persona, String> colNumeroIdentificacion;
    @FXML
    private TableColumn<Persona, String> colNombre;
    @FXML
    private TableColumn<Persona, String> colApellido;
    @FXML
    private TextField tfNumeroIdentificacion;
    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfApellido;

    @FXML
    public void initialize() {
        llenarTabla(INSTANCE.getBus().buscar(null, null, null));
        colNumeroIdentificacion.setCellValueFactory(new PropertyValueFactory<>("numeriIdentificacion"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));

        tblPersonas.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> llenarCampos(newValue));
        tfNumeroIdentificacion.setTextFormatter(new TextFormatter<>(TextFormatterUtil::integerFormat));
        tfNombre.setTextFormatter(new TextFormatter<>(TextFormatterUtil::upperCaseFormat));
        tfApellido.setTextFormatter(new TextFormatter<>(TextFormatterUtil::upperCaseFormat));
    }

    public void onGuardarClick() {
        try {
            Persona persona = Persona.of(tfNumeroIdentificacion.getText(), tfNombre.getText(), tfApellido.getText());
            INSTANCE.getBus().adicionarPersona(persona);
            llenarTabla(INSTANCE.getBus().buscar(null, null, null));
            limpiarCampos();
            mostrarInformacion("La persona fue aceptada en el bus");
        } catch (Exception e) {
            mostrarMensaje(e.getMessage());
        }
    }

    public void onCancelarClick() {
        limpiarCampos();
        tblPersonas.getSelectionModel().clearSelection();
    }

    public void onRemoverClick() {
        try {
            INSTANCE.getBus().removerPersona(tfNumeroIdentificacion.getText());
            llenarTabla(INSTANCE.getBus().buscar(null, null, null));
            limpiarCampos();
            mostrarInformacion("La persona fue retirada del bus");
        } catch (Exception e) {
            mostrarMensaje(e.getMessage());
        }
    }

    public void onBuscarClick() {
        llenarTabla(
                INSTANCE.getBus().buscar(tfNumeroIdentificacion.getText(), tfNombre.getText(), tfApellido.getText())
        );
    }

    private void llenarCampos(Persona persona) {
        if (persona != null) {
            tfNumeroIdentificacion.setText(persona.getNumeriIdentificacion());
            tfNombre.setText(persona.getNombre());
            tfApellido.setText(persona.getApellido());
        }
    }

    private void limpiarCampos() {
        tfNumeroIdentificacion.setText("");
        tfNombre.setText("");
        tfApellido.setText("");
    }

    private void llenarTabla(List<Persona> personas) {
        tblPersonas.setItems(FXCollections.observableArrayList(personas));
        tblPersonas.refresh();
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
}