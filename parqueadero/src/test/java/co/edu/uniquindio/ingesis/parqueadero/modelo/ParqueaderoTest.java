package co.edu.uniquindio.ingesis.parqueadero.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParqueaderoTest {

    void calcularValorPagarCarro(int numeroHoras,int numeroMinutos,int resultadoEsperado) {
        Parqueadero parqueadero = new Parqueadero();
        int resultado = parqueadero.calcularValorPagarCarro(numeroHoras,numeroMinutos);
        assertEquals(resultadoEsperado,resultado);
    }

    void calcularValorPagarCarro(int numeroHoras,int numeroMinutos,String  mensajeEsperado) {
        Parqueadero parqueadero = new Parqueadero();
        Exception e = assertThrows(Exception.class,
                ()->parqueadero.calcularValorPagarCarro(numeroHoras,numeroMinutos) );
        assertEquals(mensajeEsperado,e.getMessage());
    }

    @Test
    void calcularValorPagarCarroH0M0RE() {
        calcularValorPagarCarro(0,0,"De indicar un numero de horas y minutos");
    }

    @Test
    void calcularValorPagarCarroH_1M0RE() {
        calcularValorPagarCarro(-1,0,"Debe tener un número de horas valido");
    }

    @Test
    void calcularValorPagarCarroH0M_1RE() {
        calcularValorPagarCarro(0,0,"Debe tener un número de minutos valido");
    }

    @Test
    void calcularValorPagarCarroH1M80RE() {
        calcularValorPagarCarro(0,80,"Debe tener un número de minutos valido");
    }

    @Test
    void calcularValorPagarCarroH_1M_1RE() {
        calcularValorPagarCarro(0,0,"Debe tener un número de horas valido");
    }
    @Test
    void calcularValorPagarCarroH1M0R1800() {
        calcularValorPagarCarro(1,0,1800);
    }

    @Test
    void calcularValorPagarCarroH0M15R500() {
        calcularValorPagarCarro(0,15,500);
    }

    @Test
    void calcularValorPagarCarroH0M46R1800() {
        calcularValorPagarCarro(0,46,1800);
    }

    @Test
    void calcularValorPagarCarroH0M16R1000() {
        calcularValorPagarCarro(0,16,1000);
    }

    @Test
    void calcularValorPagarCarroH0M31R1500() {
        calcularValorPagarCarro(0,31,1500);
    }

    @Test
    void calcularValorPagarCarroH1M1R3600() {
        calcularValorPagarCarro(1,1,3600);
    }


}