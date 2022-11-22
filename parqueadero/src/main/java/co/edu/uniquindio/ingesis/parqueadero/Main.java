package co.edu.uniquindio.ingesis.parqueadero;


import co.edu.uniquindio.ingesis.parqueadero.modelo.Carro;
import co.edu.uniquindio.ingesis.parqueadero.modelo.Moto;
import co.edu.uniquindio.ingesis.parqueadero.modelo.Vehiculo;

public class Main {
    public static void main(String[] args) {
        Vehiculo carro = new Carro("CFX456");

        Vehiculo moto = new Moto("PTK23E");

        imprimirRecibo(carro,calcularValorPagarHora(3,carro));
        imprimirRecibo(moto,calcularValorPagarHora(3,moto));

    }

    public static void imprimirRecibo(Vehiculo vehiculo,int valor){
        System.out.println(String.format("El valor a pagar para %s es %d",vehiculo.getPlaca(),valor));
    }

    public static int calcularValorPagarHora(int numeroHoras,Vehiculo vehiculo){
        return numeroHoras * vehiculo.getTarifaHora();
    }
}