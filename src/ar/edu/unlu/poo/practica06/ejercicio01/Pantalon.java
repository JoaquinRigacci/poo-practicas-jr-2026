package ar.edu.unlu.poo.practica06.ejercicio01;

public class Pantalon extends Prenda{

    // Atributos
    private boolean esTemporadaAnterior;

    // Constructor
    public Pantalon(String nombre, double precioBase, boolean esTemporadaAnterior) {
        super(nombre, precioBase);

        this.setEsTemporadaAnterior(esTemporadaAnterior);
    }

    // Getter
    public boolean isEsTemporadaAnterior() {
        return this.esTemporadaAnterior;
    }

    // Setter
    public void setEsTemporadaAnterior(boolean esTemporadaAnterior) {
        this.esTemporadaAnterior = esTemporadaAnterior;
    }

    // Métodos
    @Override
    public double calcularPrecioFinal() {
        if (this.isEsTemporadaAnterior()) {
            double descuento = 0.90; // 10 %  de descuento
            return super.calcularPrecioFinal() * descuento;
        }
        return super.calcularPrecioFinal();
    }
}
