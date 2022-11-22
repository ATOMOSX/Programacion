package co.edu.uniquindio.ingesis.javafx.ejemplo.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Reporte {
    private final float notaMaxima;
    private final float notaMinima;
    private final float notaPromedio;
    private final int numeroGanaron;
    private final int numeroPerdieron;
    private final String nombre;
    private final List<EstudianteNotaDTO> estudiantes;

    public Reporte(String nombre, List<EstudianteNotaDTO> estudiantes) {
        this.nombre = nombre;
        this.estudiantes = estudiantes;
        DoubleStream stream = estudiantes.stream().mapToDouble(EstudianteNotaDTO::getNota);
        DoubleSummaryStatistics statistics = stream.summaryStatistics();
        notaMaxima = (float) statistics.getMax();
        notaMinima = (float) statistics.getMin();
        notaPromedio = (float) statistics.getAverage();
        numeroPerdieron = (int) stream.filter(nota->nota<3).count();
        numeroGanaron = estudiantes.size() - numeroPerdieron;
    }

    public float getNotaMaxima() {
        return notaMaxima;
    }

    public float getNotaMinima() {
        return notaMinima;
    }

    public float getNotaPromedio() {
        return notaPromedio;
    }

    public int getNumeroGanaron() {
        return numeroGanaron;
    }

    public int getNumeroPerdieron() {
        return numeroPerdieron;
    }

    public String getNombre() {
        return nombre;
    }

    public List<EstudianteNotaDTO> getEstudiantes() {
        return Collections.unmodifiableList(estudiantes);
    }

    public List<EstudianteNotaDTO> ordenarPorNombre() {
        return estudiantes.stream()
                .sorted(Comparator.comparing(EstudianteNotaDTO::getNombre))
                .collect(Collectors.toList());
    }

    public List<EstudianteNotaDTO> ordenarPorNumeroIdentificacion() {
        return estudiantes.stream()
                .sorted(Comparator.comparing(EstudianteNotaDTO::getNumeroIdentificacion))
                .collect(Collectors.toList());
    }

    public List<EstudianteNotaDTO> ordenarPorNota() {
        return estudiantes.stream()
                .sorted(Comparator.comparingDouble(EstudianteNotaDTO::getNota))
                .collect(Collectors.toList());
    }

}
