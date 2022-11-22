package co.edu.uniquindio.ingesis.javafx.ejemplo.utils;

import co.edu.uniquindio.ingesis.javafx.ejemplo.model.Estudiante;
import co.edu.uniquindio.ingesis.javafx.ejemplo.model.Genero;

import java.util.function.Predicate;

public class EstudianteBusquedaUtil {
    public static Predicate<Estudiante> buscarPorNumeroIdentificacion(String numeroIdentificacion){
        return estudiante -> estudiante.getNumeroIdentificacion().equals(numeroIdentificacion);
    }

    public static Predicate<Estudiante> buscarPorNombre(String nombre){
        return estudiante -> estudiante.getNombre().contains(nombre);
    }
    public static Predicate<Estudiante> buscarPorGenero(Genero genero) {
        return estudiante -> estudiante.getGenero() == genero;
    }
    public static Predicate<Estudiante> buscarPorTodo(String numeroIdentificacion, String nombre, Genero genero) {
        Predicate<Estudiante> predicado = estudiante -> true;
        if( numeroIdentificacion != null && !numeroIdentificacion.isEmpty() ){
            predicado = predicado.and(buscarPorNumeroIdentificacion(numeroIdentificacion));
        }
        if( nombre != null && !nombre.isEmpty() ){
            predicado = predicado.and(buscarPorNombre(nombre));
        }
        if( genero != null ){
            predicado = predicado.and(buscarPorGenero(genero));
        }
        return predicado;
    }
}
