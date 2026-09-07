package ar.edu.unlu.poo.practica1.ejercicio01;

public class Viaje {

    // Atributos
    private double distanciaEnKm;
    private Motor motor;

    // Constructor
    public Viaje(double distanciaEnKm, Motor motor) {
        this.setDistanciaEnKm(distanciaEnKm);
        this.setMotor(motor);
    }

    // Métodos
    public double obtenerConsumoVehiculo() {
        return getMotor().calcularConsumo(getDistanciaEnKm());
    }

    // Getter
    public double getDistanciaEnKm() {
        return this.distanciaEnKm;
    }

    public Motor getMotor() {
        return this.motor;
    }

    // Setter
    public void setDistanciaEnKm(double distanciaEnKm) {
        if (distanciaEnKm > 0) {
            this.distanciaEnKm = distanciaEnKm;
        } else {
            throw new IllegalArgumentException("La distancia en km debe ser mayor a 0.");
        }
    }

    public void setMotor(Motor motor) {
        if (motor != null) {
            this.motor = motor;
        } else {
            throw new IllegalArgumentException("El viaje debe tener un motor asociado.");
        }
    }
}
