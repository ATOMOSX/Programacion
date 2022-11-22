package co.edu.uniquindio.ingesis.javafx.ejemplo.exceptions;

public class PersonaExisteException extends Exception{
    public PersonaExisteException() {
        super("La persona ya esta en el bus");
    }
}
