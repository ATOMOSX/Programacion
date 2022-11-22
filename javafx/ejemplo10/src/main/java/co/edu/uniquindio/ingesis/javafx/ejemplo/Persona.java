package co.edu.uniquindio.ingesis.javafx.ejemplo;

public class Persona {
    private final String numeriIdentificacion;
    private final String nombre;
    private final String apellido;

    private Persona(String numeriIdentificacion, String nombre, String apellido) {
        this.numeriIdentificacion = numeriIdentificacion;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public static Persona of(String numeriIdentificacion, String nombre, String apellido) {
        return new Persona(numeriIdentificacion, nombre, apellido);
    }

    public String getNumeriIdentificacion() {
        return numeriIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}
