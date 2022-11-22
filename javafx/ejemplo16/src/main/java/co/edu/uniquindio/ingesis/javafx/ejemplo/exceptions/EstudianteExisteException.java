package co.edu.uniquindio.ingesis.javafx.ejemplo.exceptions;

import co.edu.uniquindio.ingesis.javafx.ejemplo.model.Estudiante;

public class EstudianteExisteException extends Exception{
    public EstudianteExisteException(Estudiante estudiante) {
        super(String.format("El estududiante con número de identificación %s ya existe",estudiante.getNumeroIdentificacion()));
    }
}
