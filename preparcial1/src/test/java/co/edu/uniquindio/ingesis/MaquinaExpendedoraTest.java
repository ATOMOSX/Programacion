package co.edu.uniquindio.ingesis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaquinaExpendedoraTest {

    @Test
    void calcularDevueltaValorPagarNegativo() {
        MaquinaExpendedora maquinaExpendedora = new MaquinaExpendedora();
        assertThrows(Exception.class,()->maquinaExpendedora.calcularDevuelta(-1,1));
    }

    @Test
    void calcularDevueltaValorPagadoNegativo() {
        MaquinaExpendedora maquinaExpendedora = new MaquinaExpendedora();
        assertThrows(Exception.class,()->maquinaExpendedora.calcularDevuelta(1,-1));
    }

    @Test
    void calcularDevueltaEntradasNegativas() {
        MaquinaExpendedora maquinaExpendedora = new MaquinaExpendedora();
        assertThrows(Exception.class,()->maquinaExpendedora.calcularDevuelta(-1,-1));
    }

    @Test
    void calcularDevueltaValorPagadoMenor() {
        MaquinaExpendedora maquinaExpendedora = new MaquinaExpendedora();
        assertThrows(Exception.class,()->maquinaExpendedora.calcularDevuelta(10,5));
    }

    @Test
    void calcularDevueltaValorPagarMenor() throws Exception {
        MaquinaExpendedora maquinaExpendedora = new MaquinaExpendedora();
        assertEquals(100,maquinaExpendedora.calcularDevuelta(100,200));
    }

    @Test
    void calcularDevueltaValorPagarMenorB() {
        MaquinaExpendedora maquinaExpendedora = new MaquinaExpendedora();
        try {
            assertEquals(100,maquinaExpendedora.calcularDevuelta(100,200));
        } catch (Exception e) {
            fail("Error: "+ e.getMessage());
        }
    }

    @Test
    void calcularDevueltaEntradasIguales() throws Exception {
        MaquinaExpendedora maquinaExpendedora = new MaquinaExpendedora();
        assertEquals(0,maquinaExpendedora.calcularDevuelta(100,100));
    }

}