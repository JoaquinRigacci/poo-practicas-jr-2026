package ar.edu.unlu.poo.practica07.ejercicio00;

public class Tarjeta {

    // Método
    public double aplicarDescuento(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("ERROR. El monto debe ser mayor a 0.");
        }
        return monto; // La tarjeta estándar devuelve el monto sin descuento
    }
}
