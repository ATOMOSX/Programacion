package co.edu.uniquindio.ingesis;

import java.util.Arrays;
import java.util.Objects;

public class Diplomado {
    private final String nombre;
    private final Estudiante[] estudiantes;
    private final int cupo;
    private int indiceEstudiantes;

    public Diplomado(String nombre, int cupo) {
        this.nombre = nombre;
        this.cupo = cupo;
        this.estudiantes = new Estudiante[cupo];
    }

    public void registrar(String numeroIdentificacion,String nombre){
        Objects.requireNonNull(numeroIdentificacion,"El número de identificación no puede ser null");
        Objects.requireNonNull(nombre,"El nombre no puede ser null");
        if( indiceEstudiantes == estudiantes.length ){
            throw new RuntimeException("No hay cupo en el diplomado");
        }
        estudiantes[indiceEstudiantes] = new Estudiante(numeroIdentificacion,nombre);
    }

    public Estudiante buscarEstudiante(String numeroIdentificacion){
        Objects.requireNonNull(numeroIdentificacion,"El número de identificación no puede ser null");
        for (int i = 0; i < indiceEstudiantes; i++) {
            if( numeroIdentificacion.equals(estudiantes[i].getNumeroIdentificacion()) ){
                return estudiantes[i];
            }
        }
        return null;
    }

    public String getNombre() {
        return nombre;
    }

    public Estudiante[] getEstudiantes() {
        return Arrays.copyOf(estudiantes,indiceEstudiantes);
    }

    public int getCupo() {
        return cupo;
    }
}
