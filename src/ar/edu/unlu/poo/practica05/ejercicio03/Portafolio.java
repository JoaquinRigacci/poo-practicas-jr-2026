package ar.edu.unlu.poo.practica05.ejercicio03;

import java.util.HashMap;
import java.util.Map;

public class Portafolio {

    // Atributos
    private final Mercado mercado;
    private final Map<String, Double> posiciones;

    // Constructor
    public Portafolio(Mercado mercado) {
        if (mercado == null) {
            throw new IllegalArgumentException("ERROR. El mercado no puede ser nulo.");
        }

        this.mercado = mercado;
        this.posiciones = new HashMap<>();
    }

    // Getter
    public double getPosicion(String divisa) {
        if (divisa == null || divisa.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR. La divisa no puede ser nula ni vacía.");
        }

        String divisaLimpia = divisa.trim().toUpperCase();

        return this.posiciones.getOrDefault(divisaLimpia, 0.0);
    }

    // Métodos
    public void agregarPosicion(String divisa, double cantidad) {
        if (divisa == null || divisa.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR. La divisa no puede ser nula ni vacía.");
        }

        if (cantidad <= 0) {
            throw new IllegalArgumentException("ERROR. La cantidad a agregar debe ser mayor a 0.");
        }

        String divisaLimpia = divisa.trim().toUpperCase();

        double cantidadActual = this.posiciones.getOrDefault(divisaLimpia, 0.0);
        this.posiciones.put(divisaLimpia, cantidadActual + cantidad);
    }

    public double calcularValorTotalUSD() {
        double totalUSD = 0.0;

        for (Map.Entry<String, Double> entry : this.posiciones.entrySet()) {
            String divisa = entry.getKey();
            Double cantidad = entry.getValue();

            // Le pedimos la cotización en vivo al mercado
            double cotizacion = this.mercado.getCotizacion(divisa);

            // Sumamos el valor convertido a USD
            totalUSD += cantidad * cotizacion;
        }

        return totalUSD;
    }
}
