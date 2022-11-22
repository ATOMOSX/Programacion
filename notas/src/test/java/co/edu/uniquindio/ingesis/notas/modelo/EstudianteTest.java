package co.edu.uniquindio.ingesis.notas.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


class EstudianteTest {

    @Test
    void getNotas() {
    }

    @Test
    void setNota() {
        Estudiante estudiante = new Estudiante("1094678543","Pedro Perez",5);
        try {
            estudiante.setNota(0,5.0f);
            Assertions.assertEquals(5.0f,estudiante.getNotas()[0]);
        } catch (Exception e) {
            fail("Error en la asignación de la nota "+e.getMessage());
            e.printStackTrace();
        }

        try {
            estudiante.setNota(-1,5.0f);
            fail("No valido el indice negativo");
        } catch (Exception e) {
            assertEquals("El indice no puede ser negativo",e.getMessage());
        }

        try {
            estudiante.setNota(6,5.0f);
            fail("No valido el indice correspondiente al número de notas");
        } catch (Exception e) {
            assertEquals("El indice excede el tamaño del arreglo",e.getMessage());
        }

        try {
            estudiante.setNota(1,-5.0f);
            fail("No valido la nota menor a 0");
        } catch (Exception e) {
            assertEquals("La nota no puede ser menor a 0",e.getMessage());
        }

        try {
            estudiante.setNota(1,6.0f);
            fail("No valido la nota mayor a 5");
        } catch (Exception e) {
            assertEquals("La nota no puede ser mayor a 5",e.getMessage());
        }
    }
}