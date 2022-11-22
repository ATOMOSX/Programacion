package co.edu.uniquindio.ingesis.notas.modelo;

public class Estudiante {
    private final String id;
    private final String nombre;
    private final float[] notas;

    public Estudiante(String id, String nombre,int numeroNotas) {
        this.id = id;
        this.nombre = nombre;
        notas = new float[numeroNotas];
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public float[] getNotas() {
        float[] copia = new float[notas.length];

        for (int i = 0; i < notas.length; i++) {
            copia[i] = notas[i];
        }
        return copia;
    }

    public void setNota(int indice,float nota) throws Exception {
        if (indice<0){
            throw new Exception("El indice no puede ser negativo");
        }
        if( indice>= notas.length){
            throw new Exception("El indice excede el tamaño del arreglo");
        }
        if( nota < 0){
            throw new Exception("La nota no puede ser menor a 0");
        }
        if( nota > 5){
            throw new Exception("La nota no puede ser mayor a 5");
        }
        notas[indice] = nota;
    }
}
