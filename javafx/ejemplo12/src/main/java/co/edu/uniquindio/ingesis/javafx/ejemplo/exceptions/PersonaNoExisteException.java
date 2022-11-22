package co.edu.uniquindio.ingesis.javafx.ejemplo.exceptions;

public class PersonaNoExisteException extends Exception {
    public PersonaNoExisteException() {
        super("La persona no existe");
    }
}
