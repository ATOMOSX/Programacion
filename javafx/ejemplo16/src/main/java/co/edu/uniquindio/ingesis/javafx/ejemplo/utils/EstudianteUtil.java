package co.edu.uniquindio.ingesis.javafx.ejemplo.utils;

import co.edu.uniquindio.ingesis.javafx.ejemplo.model.Estudiante;
import co.edu.uniquindio.ingesis.javafx.ejemplo.model.EstudianteNotaDTO;

import java.util.function.Function;

public class EstudianteUtil {
    public static Function<Estudiante,EstudianteNotaDTO> toEstudianteNotaDTO(int parcial){
        return estudiante -> EstudianteNotaDTO.of(estudiante.getNumeroIdentificacion(), estudiante.getNombre(), estudiante.getNota(parcial));
    }
}
