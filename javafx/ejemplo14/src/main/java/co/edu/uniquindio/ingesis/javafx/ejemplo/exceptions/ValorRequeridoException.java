package co.edu.uniquindio.ingesis.javafx.ejemplo.exceptions;

public class ValorRequeridoException extends Exception{
    public ValorRequeridoException(String nombre) {
        super(String.format("El %s es requerido",nombre));
    }
}
