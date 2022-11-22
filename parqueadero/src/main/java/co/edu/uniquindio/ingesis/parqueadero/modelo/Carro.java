package co.edu.uniquindio.ingesis.parqueadero.modelo;

public class Carro extends Vehiculo{

    public Carro(String placa) {
        super(placa);
    }

    @Override
    public int getTarifaHora() {
        return 1800;
    }

    @Override
    public int getTarifaMinuto() {
        return 500;
    }
}
