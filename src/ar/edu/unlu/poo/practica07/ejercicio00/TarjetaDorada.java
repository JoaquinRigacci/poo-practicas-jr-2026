package ar.edu.unlu.poo.practica07.ejercicio00;

public class TarjetaDorada extends Tarjeta{

    @Override
    public double aplicarDescuento(double monto) {
        double montoBase = super.aplicarDescuento(monto);
        return montoBase * 0.85;
    }
}
