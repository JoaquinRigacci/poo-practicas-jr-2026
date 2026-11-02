package ar.edu.unlu.poo.practica07.ejercicio00;

public abstract class Conjunto implements Vendible{

    // Atributos
    private Remera remera;
    private Prenda otraPrenda;

    // Constructor
    public Conjunto(Remera remera, Prenda otraPrenda) {
        this.setRemera(remera);
        this.setOtraPrenda(otraPrenda);
    }

    // Get
    public Remera getRemera() {
        return this.remera;
    }

    public Prenda getOtraPrenda() {
        return this.otraPrenda;
    }

    // Set
    public void setRemera(Remera remera) {
        if (remera == null) {
            throw new IllegalArgumentException("ERROR. La remera no puede ser nula.");
        }
        this.remera = remera;
    }

    public void setOtraPrenda(Prenda otraPrenda) {
        if (otraPrenda == null) {
            throw new IllegalArgumentException("ERROR. La otra prenda no puede ser nula.");
        }
        this.otraPrenda = otraPrenda;
    }

    // Métodos
    @Override
    public abstract double calcularPrecio();

    @Override
    public double calcularPrecio(Tarjeta tarjeta) {
        if (tarjeta == null) {
            throw new IllegalArgumentException("ERROR. La tarjeta no puede ser nula.");
        }
        return tarjeta.aplicarDescuento(this.calcularPrecio());
    }
}
