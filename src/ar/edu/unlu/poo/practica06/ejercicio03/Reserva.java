package ar.edu.unlu.poo.practica06.ejercicio03;

public class Reserva {

    // Atributos
    private Vehiculo vehiculo;
    private int diasAlquiler;

    // Constructor
    public Reserva(Vehiculo vehiculo, int diasAlquiler) {
        this.setVehiculo(vehiculo);
        this.setDiasAlquiler(diasAlquiler);
    }

    // Getters
    public Vehiculo getVehiculo() {
        return this.vehiculo;
    }

    public int getDiasAlquiler() {
        return this.diasAlquiler;
    }

    // Setters
    public void setVehiculo(Vehiculo vehiculo) {
        if (vehiculo == null) {
            throw new IllegalArgumentException("ERROR. El vehículo no puede ser nulo.");
        }
        this.vehiculo = vehiculo;
    }

    public void setDiasAlquiler(int diasAlquiler) {
        if (diasAlquiler <= 0) {
            throw new IllegalArgumentException("ERROR. Los días de alquiler tienen que ser mayor a 0.");
        }
        this.diasAlquiler = diasAlquiler;
    }

    // Método
    public double calcularMontoTotal() {
        return this.getVehiculo().calcularTarifa(this.getDiasAlquiler());
    }

}
