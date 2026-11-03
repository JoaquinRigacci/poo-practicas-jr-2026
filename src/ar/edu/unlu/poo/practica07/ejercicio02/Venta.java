package ar.edu.unlu.poo.practica07.ejercicio02;

import ar.edu.unlu.poo.practica07.ejercicio00.Vendible;

import java.util.ArrayList;
import java.util.List;

public class Venta {

    // Atributo
    private List<Vendible> prendas;

    // Constructor
    public Venta() {
        this.prendas = new ArrayList<>();
    }

    // Métodos
    public void agregarPrenda(Vendible prenda) {
        if (prenda == null) {
            throw new IllegalArgumentException("ERROR. La prenda no puede ser nula.");
        }
        this.prendas.add(prenda);
    }

    public double calcularMontoBase() {
        double total = 0;
        for (Vendible p : prendas) {
            total += p.calcularPrecio();
        }
        return total;
    }

    public double facturar(MedioDePago medio) {
        if (medio == null) {
            throw new IllegalArgumentException("ERROR. El medio no puede ser nulo.");
        }
        double base = this.calcularMontoBase();
        return medio.calcularTotal(base);
    }
}
