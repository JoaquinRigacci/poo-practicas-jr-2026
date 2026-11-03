package ar.edu.unlu.poo.practica07.ejercicio04;

import java.util.ArrayList;
import java.util.List;

public class GestorDeDescargas {

    // Atributos
    private List<Descargable> colaDescarga;

    // Constructor
    public GestorDeDescargas() {
        this.colaDescarga = new ArrayList<>();
    }

    // Métodos
    public void encolarDescarga(Descargable descargable) {
        if (descargable == null) {
            throw new IllegalArgumentException("ERROR. Descargable no puede ser nulo.");
        }
        this.colaDescarga.add(descargable);
    }

    public int procesarDescargas() {
        int totalDeExitos = 0;
        for (Descargable d : this.colaDescarga) {
            d.descargar();
            if (d.isDescargado()) {
                totalDeExitos++;
            } else {
                System.out.println("No se pudo descargar " + d + ".");
            }
        }
            this.colaDescarga.clear();
        return totalDeExitos;
    }
}
