package ar.edu.unlu.poo.practica05.ejercicio01;

import java.time.LocalDateTime;

public class Transferencia {
    // Clase Inmutable

    // Atributos
    private final String divisa;
    private final double monto;
    private final LocalDateTime fechaHora;
    private final String detalle;

    // Constructor
    public Transferencia(String divisa, double monto, String detalle) {
        if (divisa == null || divisa.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR. La divisa no puede ser nula ni vacía.");
        }
        if (monto <= 0) {
            throw new IllegalArgumentException("ERROR. El monto de la transferencia debe ser mayor a 0.");
        }
        this.divisa = divisa.trim().toUpperCase();
        this.monto = monto;
        this.fechaHora = LocalDateTime.now();
        this.detalle = detalle != null ? detalle : "Transferencia realizada.";
    }

    // Getter
    public String getDivisa() {
        return this.divisa;
    }

    public double getMonto() {
        return this.monto;
    }

    public LocalDateTime getFechaHora() {
        return this.fechaHora;
    }

    public String getDetalle() {
        return this.detalle;
    }
}
