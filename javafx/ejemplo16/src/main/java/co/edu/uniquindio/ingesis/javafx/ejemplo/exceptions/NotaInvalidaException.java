package co.edu.uniquindio.ingesis.javafx.ejemplo.exceptions;

public class NotaInvalidaException extends Exception{
    public NotaInvalidaException() {
        super("Nota invalida: la nota debe ser mayor o igual a 0 y menor o igual a 5");
    }
}
