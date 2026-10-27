package ar.edu.unlu.poo.practica06.ejercicio03;

public class AutoVIP extends Vehiculo{

    // Atributos
    private double consumoFijo;

    // Constructor
    public AutoVIP(double tarifaDiaria, double consumoFijo) {
        super(tarifaDiaria);
        this.setConsumoFijo(consumoFijo);
    }

    // Get
    public double getConsumoFijo() {
        return this.consumoFijo;
    }

    // Set
    public void setConsumoFijo(double consumoFijo) {
        if(consumoFijo <= 0) {
            throw new IllegalArgumentException("ERROR. El consumo fijo debe ser mayor a 0.");
        }
        this.consumoFijo = consumoFijo;
    }

    // Método
    @Override
    public double calcularTarifa(int diasAlquiler) {
        return super.calcularTarifa(diasAlquiler) + this.getConsumoFijo();
    }
}
