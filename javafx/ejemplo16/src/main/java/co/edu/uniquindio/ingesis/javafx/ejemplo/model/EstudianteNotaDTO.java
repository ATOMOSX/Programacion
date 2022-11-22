package co.edu.uniquindio.ingesis.javafx.ejemplo.model;

import java.util.Objects;

public class EstudianteNotaDTO {
    private final String numeroIdentificacion;
    private final String nombre;
    private final float nota;
    private EstudianteNotaDTO(String numeroIdentificacion, String nombre, float nota) {
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombre = nombre;
        this.nota = nota;
    }

    public static EstudianteNotaDTO of(String numeroIdentificacion, String nombre, float nota) {
        Objects.requireNonNull(numeroIdentificacion,"El número de identificación es requerido");
        Objects.requireNonNull(nombre,"El nombre es requerido");
        return new EstudianteNotaDTO(numeroIdentificacion, nombre, nota);
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public float getNota() {
        return nota;
    }
}
