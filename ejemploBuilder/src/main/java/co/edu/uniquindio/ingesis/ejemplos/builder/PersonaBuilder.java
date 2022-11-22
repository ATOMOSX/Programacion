package co.edu.uniquindio.ingesis.ejemplos.builder;

public class PersonaBuilder {
    private String cedula;
    private String nombre;
    private String apellido;

    public PersonaBuilder cedula(String cedula) {
        this.cedula = cedula;
        return this;
    }

    public PersonaBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public PersonaBuilder apellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public Persona build(){
        return new Persona(cedula,nombre,apellido);
    }
}
