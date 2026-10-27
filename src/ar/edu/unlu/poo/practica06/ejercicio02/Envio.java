package ar.edu.unlu.poo.practica06.ejercicio02;

public class Envio {

    // Atributos
    private double pesoKg;
    private double distanciaKm;

    // Constructor
    public Envio(double pesoKg, double distanciaKm) {
        this.setPesoKg(pesoKg);
        this.setDistanciaKm(distanciaKm);
    }

    // Getter
    public double getPesoKg() {
        return this.pesoKg;
    }

    public double getDistanciaKm() {
        return this.distanciaKm;
    }

    // Setter
    public void setPesoKg(double pesoKg) {
        if (pesoKg > 0) {
            this.pesoKg = pesoKg;
        } else {
            throw new IllegalArgumentException("ERROR. El peso debe ser mayor a 0.");
        }
    }

    public void setDistanciaKm(double distanciaKm) {
        if (distanciaKm > 0) {
            this.distanciaKm = distanciaKm;
        } else {
            throw new IllegalArgumentException("ERROR. La distancia debe ser mayor a 0.");
        }
    }

    // Métodos
    public double calcularCosto() {
        return 0.0;
    }
}
