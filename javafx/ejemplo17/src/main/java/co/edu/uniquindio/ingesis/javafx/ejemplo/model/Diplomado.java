package co.edu.uniquindio.ingesis.javafx.ejemplo.model;

import co.edu.uniquindio.ingesis.javafx.ejemplo.exceptions.EstudianteExisteException;
import co.edu.uniquindio.ingesis.javafx.ejemplo.exceptions.EstudianteNoExisteException;
import co.edu.uniquindio.ingesis.javafx.ejemplo.utils.EstudianteBusquedaUtil;
import co.edu.uniquindio.ingesis.javafx.ejemplo.utils.EstudianteUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Diplomado {
    private final String nombre;
    private final List<Estudiante> estudiantes;
    private final int cupo;

    public Diplomado(String nombre, int cupo) {
        this.nombre = nombre;
        this.cupo = cupo;
        estudiantes = new ArrayList<>();
    }

    public void registrarEstudiante(Estudiante nuevoEstudiante) throws EstudianteExisteException {
        if( buscarEstudiante(nuevoEstudiante.getNumeroIdentificacion()).isPresent() ){
            throw new EstudianteExisteException(nuevoEstudiante);
        }
        estudiantes.add(nuevoEstudiante);
    }

    public void cancelarRegistro(String numeroIdentificacion) throws EstudianteNoExisteException {
        Estudiante estudiante = buscarEstudiante(numeroIdentificacion).orElseThrow(EstudianteNoExisteException::new);
        estudiantes.remove(estudiante);
    }
    public Optional<Estudiante> buscarEstudiante(String numeroIdentificacion ){
        return estudiantes.stream()
                .filter(estudiante -> estudiante.getNumeroIdentificacion().equals(numeroIdentificacion))
                .findFirst();
    }

    public List<Estudiante> buscarGanaron(int parcial){
        return estudiantes.stream()
                .filter(estudiante -> estudiante.getNota(parcial)>=3)
                .collect(Collectors.toList());
    }

    public List<Estudiante> buscarPerdieron(int parcial){
        return estudiantes.stream()
                .filter(estudiante -> estudiante.getNota(parcial)<3)
                .collect(Collectors.toList());
    }

    public Reporte generarReporte(int parcial){
        return new Reporte("Reporte: Parcial "+parcial,
                estudiantes.stream()
                        .map(EstudianteUtil.toEstudianteNotaDTO(parcial))
                        .collect(Collectors.toList())
        );
    }

    public List<Estudiante> buscar(String numeroIdentificacion,String nombre,Genero genero){
        return estudiantes.stream()
                .filter(EstudianteBusquedaUtil.buscarPorTodo(numeroIdentificacion, nombre, genero))
                .collect(Collectors.toUnmodifiableList());
    }
}
