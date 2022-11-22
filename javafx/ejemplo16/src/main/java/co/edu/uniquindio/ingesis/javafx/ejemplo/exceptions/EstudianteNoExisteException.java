package co.edu.uniquindio.ingesis.javafx.ejemplo.exceptions;

public class EstudianteNoExisteException extends Exception {
    public EstudianteNoExisteException() {
        super("La persona no existe");
    }
}
