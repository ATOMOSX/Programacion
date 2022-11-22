package co.edu.uniquindio.ingesis.javafx.ejemplo.model;

import co.edu.uniquindio.ingesis.javafx.ejemplo.exceptions.NotaInvalidaException;
import co.edu.uniquindio.ingesis.javafx.ejemplo.exceptions.ValorRequeridoException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Estudiante {
    private final String numeroIdentificacion;
    private final String nombre;
    private final Genero genero;
    private final List<Float> notas;
    private Estudiante(String numeroIdentificacion, String nombre, Genero genero) {
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombre = nombre;
        this.genero = genero;
        notas = new ArrayList<>();
    }

    public static Estudiante of(String numeroIdentificacion, String nombre, Genero genero) throws ValorRequeridoException {
        if(Objects.requireNonNull(numeroIdentificacion,"El número de identificación es requerido").isEmpty()){
            throw new ValorRequeridoException("número de identificación");
        }
        if(Objects.requireNonNull(nombre,"El nombre es requerido").isEmpty()){
            throw new ValorRequeridoException("nombre");
        }
        Objects.requireNonNull(genero,"El genero es requerido");

        return new Estudiante(numeroIdentificacion, nombre, genero);
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public Genero getGenero() {
        return genero;
    }

    public void adicionarNota(float nota) throws NotaInvalidaException {
        if( nota < 0 || nota > 5){
            throw new NotaInvalidaException();
        }
        notas.add(nota);
    }

    public float calcularPromedio(){
        return (float) notas.stream().mapToDouble(Double::valueOf).average().getAsDouble();
    }

    public float getNota(int parcial){
        return notas.get(parcial);
    }

    public List<Float> getNotas() {
        return Collections.unmodifiableList(notas);
    }

    public String getNotasAsString(){
        return notas.stream().map(String::valueOf).collect(Collectors.joining(","));
    }

    public float getMaxNota(){
        return (float) notas.stream().mapToDouble(Double::valueOf).max().getAsDouble();
    }

    public float getMinNota(){
        return (float) notas.stream().mapToDouble(Double::valueOf).min().getAsDouble();
    }
}
