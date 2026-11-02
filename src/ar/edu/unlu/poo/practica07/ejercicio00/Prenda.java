package ar.edu.unlu.poo.practica07.ejercicio00;

public class Prenda implements Vendible{

    // Atributo
    private double precioDeLista;

    // Constructor
    public Prenda(double precioDeLista) {
        this.setPrecioDeLista(precioDeLista);
    }

    // Get
    public double getPrecioDeLista() {
        return this.precioDeLista;
    }

    // Set
    public void setPrecioDeLista(double precioDeLista) {
        if (precioDeLista <= 0) {
            throw new IllegalArgumentException("ERROR. El precio de la prenda tiene que ser mayor a 0.");
        }
        this.precioDeLista = precioDeLista;
    }

    // Métodos
    public double calcularPrecio() {
        return this.getPrecioDeLista();
    }

    public double calcularPrecio(Tarjeta tarjeta) {
        if (tarjeta == null) {
            throw new IllegalArgumentException("ERROR. La tarjeta no puede ser nula.");
        }
        return tarjeta.aplicarDescuento(this.calcularPrecio());
    }
}
