package ar.edu.unlu.poo.practica06.ejercicio03;

public class Camioneta extends Vehiculo{

    // Atributos
    private double recargoPorKg;
    private double kgDeclarados;

    // Constructor
    public Camioneta(double tarifaDiaria, double recargoPorKg, double kgDeclarados) {
        super(tarifaDiaria);
        this.setRecargoPorKg(recargoPorKg);
        this.setKgDeclarados(kgDeclarados);
    }

    // Getters
    public double getRecargoPorKg() {
        return this.recargoPorKg;
    }

    public double getKgDeclarados() {
        return this.kgDeclarados;
    }

    // Setters
    public void setRecargoPorKg(double recargoPorKg) {
        if (recargoPorKg <= 0) {
            throw new IllegalArgumentException("ERROR. El recargo en proporción a los kg de carga declarados, debe ser mayor a 0.");
        }
        this.recargoPorKg = recargoPorKg;
    }

    public void setKgDeclarados(double kgDeclarados) {
        if (kgDeclarados < 0) {
            throw new IllegalArgumentException("ERROR. Los kg declarados deben ser mayor o igual a 0.");
        }
        this.kgDeclarados = kgDeclarados;
    }

    // Método
    @Override
    public double calcularTarifa(int diasAlquiler) {
        return super.calcularTarifa(diasAlquiler) + this.getKgDeclarados() * this.getRecargoPorKg();
    }
}
