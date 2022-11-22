package co.edu.uniquindio.ingesis;

import java.util.Arrays;

public class Estudiante {
    private final float[] notas;
    private final String nombre;
    private final String numeroIdentificacion;

    private int indiceNota;

    public Estudiante(String numeroIdentificacion,String nombre) {
        this.nombre = nombre;
        this.numeroIdentificacion = numeroIdentificacion;
        notas = new float[5];
        indiceNota = 0;
    }

    public float calcularPromedio(){
        float sumatoria = 0;
        if( indiceNota == 0 ){
            return 0;
        }
        for (int i = 0 ; i < indiceNota ; i++ ) {
            sumatoria += notas[i];
        }
        return sumatoria / indiceNota;
    }

    public void adicionarNota(float nota) throws Exception{
        if( nota < 0){
            throw new Exception("La nota no puede ser negativa");
        }
        if( indiceNota == notas.length ){
            throw new Exception("Ya se han ingresado todas las notas");
        }
        notas[indiceNota] = nota;
        indiceNota++;
    }

    public float[] getNotas() {
        return Arrays.copyOf(notas,indiceNota);
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }
}
