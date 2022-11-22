package co.edu.uniquindio.ingesis.ejemplos.builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonaBuilderTest {

    @Test
    void build() {
        Persona personaOld = new Persona("1094234566","Pedro","Perez");
        Persona nuevaPersona = Persona.builder().cedula("1094234566").nombre("Pedro").apellido("Perez").build();
        assertNotNull(nuevaPersona);
        assertEquals("1094234566",nuevaPersona.getCedula());
        assertEquals("Pedro",nuevaPersona.getNombre());
        assertEquals("Perez",nuevaPersona.getApellido());
    }
}