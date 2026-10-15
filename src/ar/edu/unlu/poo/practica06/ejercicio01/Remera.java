package ar.edu.unlu.poo.practica06.ejercicio01;

public class Remera extends Prenda{

    // Atributos
    private boolean esImportada;
    private double recargoEstampado;

    // Constructor
    public Remera(String nombre, double precioBase, boolean esImportada, double recargoEstampado) {
        super(nombre, precioBase);

        this.setEsImportada(esImportada);
        this.setRecargoEstampado(recargoEstampado);
    }

    // Getter
    public boolean isEsImportada() {
        return this.esImportada;
    }

    public double getRecargoEstampado() {
        return this.recargoEstampado;
    }

    // Setter
    public void setEsImportada(boolean esImportada) {
        this.esImportada = esImportada;
    }

    public void setRecargoEstampado(double recargoEstampado) {
        if (recargoEstampado < 0) {
            throw new IllegalArgumentException("ERROR. El recargo del estampado debe ser mayor a 0.");
        }
        this.recargoEstampado = recargoEstampado;
    }

    // Métodos
    @Override
    public double calcularPrecioFinal() {
        if (this.isEsImportada()) {
            return super.calcularPrecioFinal() + this.getRecargoEstampado();
        }
        return super.calcularPrecioFinal();
    }
}
