package ar.edu.unlu.poo.practica1.ejercicio01;

public class Motor {

    // Atributos
    private double cilindradaEnLitros;
    private double factorDeEficiencia;

    // Constructor
    public Motor(double cilindradaEnLitros, double factorDeEficiencia) {
        this.setCilindradaEnLitros(cilindradaEnLitros);
        this.setFactorDeEficiencia(factorDeEficiencia);
    }

    // Métodos
    public double calcularConsumo(double distancia) {
        return (getCilindradaEnLitros() * 0.05 + getFactorDeEficiencia()) * (distancia / 100);
    }

    // Getter
    public double getCilindradaEnLitros() {
        return this.cilindradaEnLitros;
    }

    public double getFactorDeEficiencia() {
        return this.factorDeEficiencia;
    }

    // Setter
    public void setCilindradaEnLitros(double cilindradaEnLitros) {
        if (cilindradaEnLitros > 0) {
            this.cilindradaEnLitros = cilindradaEnLitros;
        } else {
            throw new IllegalArgumentException("La cilindrada en Litro debe ser mayor a 0.");
        }
    }

    public void setFactorDeEficiencia(double factorDeEficiencia) {
        if (factorDeEficiencia >= 0) {
            this.factorDeEficiencia = factorDeEficiencia;
        } else {
            throw new IllegalArgumentException("El factor de eficiencia no puede ser negativo.");
        }
    }
}
