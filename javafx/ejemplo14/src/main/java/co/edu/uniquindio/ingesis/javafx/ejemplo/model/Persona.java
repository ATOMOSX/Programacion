package co.edu.uniquindio.ingesis.javafx.ejemplo.model;

import co.edu.uniquindio.ingesis.javafx.ejemplo.exceptions.ValorRequeridoException;

import java.util.Objects;

public class Persona {
    private final String numeriIdentificacion;
    private final String nombre;
    private final String apellido;
    private final Genero genero;
    private Persona(String numeriIdentificacion, String nombre, String apellido,Genero genero) {
        this.numeriIdentificacion = numeriIdentificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
    }

    public static Persona of(String numeroIdentificacion, String nombre, String apellido,Genero genero) throws ValorRequeridoException {
        if(Objects.requireNonNull(numeroIdentificacion,"El número de identificación es requerido").isEmpty()){
            throw new ValorRequeridoException("número de identificación");
        }
        if(Objects.requireNonNull(nombre,"El nombre es requerido").isEmpty()){
            throw new ValorRequeridoException("nombre");
        }
        if(Objects.requireNonNull(apellido,"El apellido es requerido").isEmpty()){
            throw new ValorRequeridoException("apellido");
        }
        Objects.requireNonNull(genero,"El genero es requerido");

        return new Persona(numeroIdentificacion, nombre, apellido,genero);
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

    public Genero getGenero() {
        return genero;
    }
}
