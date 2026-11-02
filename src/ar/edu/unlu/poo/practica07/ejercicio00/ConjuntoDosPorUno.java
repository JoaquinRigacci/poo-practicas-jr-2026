package ar.edu.unlu.poo.practica07.ejercicio00;

public class ConjuntoDosPorUno extends Conjunto{

    // Constructor
    public ConjuntoDosPorUno(Remera remera, Prenda otraPrenda) {
        super(remera, otraPrenda);
    }

    // Método
    @Override
    public double calcularPrecio() {
        double precioRemera = this.getRemera().calcularPrecio();
        double precioOtraPrenda = this.getOtraPrenda().calcularPrecio();
        return Math.max(precioRemera, precioOtraPrenda);
    }
}
