package ar.edu.unlu.poo.practica05.ejercicio03;

import java.util.HashMap;
import java.util.Map;

public class Mercado {

    // Atributos
    private final Map<String, Double> cotizaciones;

    // Constructor
    public Mercado() {
        this.cotizaciones = new HashMap<>();
    }

    // Getter
    public double getCotizacion(String divisa) {
        if (divisa == null || divisa.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR. Divisa no especificada.");
        }

        String divisaLimpia = divisa.trim().toUpperCase();

        if (!this.cotizaciones.containsKey(divisaLimpia)) {
            throw new CotizacionNoEncontradaException("ERROR. No se encontró la cotización para la divisa: " + divisa);
        }

        return this.cotizaciones.get(divisaLimpia);
    }


    // Métodos
    public void actualizarCotizacion(String divisa, double valorEnUSD) {
        if (divisa == null || divisa.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR. La divisa no puede ser nula ni vacía.");
        }

        if (valorEnUSD <= 0) {
            throw new IllegalArgumentException("ERROR. Las cotizaciones deben ser estrictamente positivas.");
        }

        this.cotizaciones.put(divisa.trim().toUpperCase(), valorEnUSD);

    }

}
