package co.edu.uniquindio.ingesis.javafx.ejemplo;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PersonaController {
    @FXML
    private TableView<Persona> tblPersonas;
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