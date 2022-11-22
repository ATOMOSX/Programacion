package co.edu.uniquindio.ingesis.parqueadero.modelo;

public class Vehiculo {
    private final String placa;
    private String modelo;
    private String marca;

    public Vehiculo(String placa) {
        this.placa = placa;
    }

    public int getTarifaHora(){
        return 0;
    }

    public  int getTarifaMinuto(){
        return 0;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }
}
