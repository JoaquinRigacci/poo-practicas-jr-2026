package ar.edu.unlu.poo.practica06.ejercicio02;

public class EnvioEstandar extends Envio{

    // Constructor
    public EnvioEstandar(double pesoKg, double distanciaKm) {
        super(pesoKg, distanciaKm);
    }

    // Método
    @Override
    public double calcularCosto() {
        double costoBase = this.getDistanciaKm() * 50;
        if (this.getPesoKg() > 10) {
            double recargo = costoBase * 0.2;
            costoBase += recargo;
        }

        return costoBase;
    }
}
