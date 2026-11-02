package ar.edu.unlu.poo.practica07.ejercicio00;

public class ConjuntoConDescuento extends Conjunto{

    // Atributos
    private double porcentajeDescuento;

    // Constructor
    public ConjuntoConDescuento(Remera remera, Prenda otraPrenda, double porcentajeDescuento) {
        super(remera, otraPrenda);
        this.setPorcentajeDescuento(porcentajeDescuento);
    }

    // Get
    public double getPorcentajeDescuento() {
        return this.porcentajeDescuento;
    }

    // Set
    public void setPorcentajeDescuento(double porcentajeDescuento) {
        if (porcentajeDescuento <= 0) {
            throw new IllegalArgumentException("ERROR. El porcentaje de descuento debe ser mayor a 0.");
        }
        this.porcentajeDescuento = porcentajeDescuento;
    }

    // Métodos|
    @Override
    public double calcularPrecio() {
        double descuento = 1 - (this.getPorcentajeDescuento() / 100);
        return (this.getRemera().calcularPrecio() + this.getOtraPrenda().calcularPrecio()) * descuento;
    }
}
