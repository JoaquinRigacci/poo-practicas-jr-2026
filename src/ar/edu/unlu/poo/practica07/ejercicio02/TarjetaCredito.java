package ar.edu.unlu.poo.practica07.ejercicio02;

public class TarjetaCredito implements MedioDePago{

    // Atributo
    private double recargoPosnet;

    // Constructor
    public TarjetaCredito(double recargoPosnet) {
        this.setRecargoPosnet(recargoPosnet);
    }

    // Getter
    public double getRecargoPosnet() {
        return this.recargoPosnet;
    }

    // Setter
    public void setRecargoPosnet(double recargoPosnet) {
        if (recargoPosnet <= 0) {
            throw new IllegalArgumentException("ERROR. El recargo del Posnet debe ser mayor a 0");
        }
        this.recargoPosnet = recargoPosnet;
    }

    // Método
    @Override
    public double calcularTotal(double montoBase) {
        if (montoBase <= 0) {
            throw new IllegalArgumentException("ERROR. El monto debe ser mayor a 0.");
        }
        return (montoBase * 1.05) + this.getRecargoPosnet();
    }
}
