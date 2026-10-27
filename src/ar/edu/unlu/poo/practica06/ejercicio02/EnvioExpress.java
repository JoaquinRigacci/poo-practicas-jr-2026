package ar.edu.unlu.poo.practica06.ejercicio02;

public class EnvioExpress extends Envio{
    public EnvioExpress(double pesoKg, double distanciaKm) {
        super(pesoKg, distanciaKm);
    }

    @Override
    public double calcularCosto() {
        double costoBase = this.getDistanciaKm() * 90;
        double costoFijo = 500.0;
        return costoBase + costoFijo;
    }
}
