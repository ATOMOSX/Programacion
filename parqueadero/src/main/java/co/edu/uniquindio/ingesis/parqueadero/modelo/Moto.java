package co.edu.uniquindio.ingesis.parqueadero.modelo;

public class Moto extends Vehiculo{

    public Moto(String placa) {
        super(placa);
    }

    @Override
    public int getTarifaHora() {
        return 700;
    }

    @Override
    public int getTarifaMinuto() {
        return 200;
    }
}
