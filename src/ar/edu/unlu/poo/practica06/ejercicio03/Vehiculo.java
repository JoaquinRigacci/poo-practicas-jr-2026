package ar.edu.unlu.poo.practica06.ejercicio03;

public class Vehiculo {

    // Atributos
    private double tarifaDiaria;

    // Constructor
    public Vehiculo(double tarifaDiaria) {
        this.setTarifaDiaria(tarifaDiaria);
    }

    // Getter
    public double getTarifaDiaria() {
        return this.tarifaDiaria;
    }


    // Setter
    public void setTarifaDiaria(double tarifaDiaria) {
        if (tarifaDiaria <= 0) {
            throw new IllegalArgumentException("ERROR. La tarifa diaria tiene que ser mayor a 0.");
        }
        this.tarifaDiaria = tarifaDiaria;
    }

    // Método
    public double calcularTarifa(int diasAlquiler) {
        if (diasAlquiler <= 0) {
            throw new IllegalArgumentException("ERROR. Los dias de alquiler tienen que ser mayor a 0.");
        }
        return diasAlquiler * this.getTarifaDiaria();
    }
}
