package ar.edu.unlu.poo.practica07.ejercicio02;

public class Efectivo implements MedioDePago{

    // Método
    @Override
    public double calcularTotal(double montoBase) {
        if (montoBase <= 0) {
            throw new IllegalArgumentException("ERROR. El monto debe ser mayor a 0.");
        }
        return montoBase * 0.90;
    }
}
