package ar.edu.unlu.poo.practica06.ejercicio01;

import java.util.ArrayList;
import java.util.List;

public class Venta {

    // Atributos
    private final List<Prenda> prendas;

    // Constructor
    public Venta() {
        this.prendas = new ArrayList<>();
    }

    // Métodos
    public void agregarPrenda(Prenda prenda) {
        if (prenda == null) {
            throw new IllegalArgumentException("ERROR. La prenda no puede ser nula.");
        }

        this.prendas.add(prenda);
    }

    public double calcularTotal() {
        double total = 0;
        for (Prenda prenda : prendas) {
            total += prenda.calcularPrecioFinal();
        }
        return total;
    }
}
