package ar.edu.unlu.poo.practica07.ejercicio07;

import java.time.LocalDateTime;

public abstract class MetodoDePago {

    // Atributos
    private String idTransaccion;
    private double monto;
    private LocalDateTime fechaHora;
    private boolean exitoso;

    // Constructor
    public MetodoDePago(String idTransaccion, double monto) {
        this.setIdTransaccion(idTransaccion);
        this.setMonto(monto);
        this.setFechaHora(LocalDateTime.now());
        this.setExitoso(false);
    }

    // Getter
    public String getIdTransaccion() {
        return this.idTransaccion;
    }

    public double getMonto() {
        return this.monto;
    }

    public LocalDateTime getFechaHora() {
        return this.fechaHora;
    }

    public boolean isExitoso() {
        return this.exitoso;
    }

    // Setter
    public void setIdTransaccion(String idTransaccion) {
        if (idTransaccion == null || idTransaccion.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR. El ID de transacción no puede ser nulo.");
        }
        this.idTransaccion = idTransaccion;
    }

    public void setMonto(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("ERROR. El monto debe ser mayor a 0.");
        }
        this.monto = monto;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        if (fechaHora == null) {
            throw new IllegalArgumentException("ERROR. La fecha y hora no pueden ser nulas.");
        }
        this.fechaHora = fechaHora;
    }

    public void setExitoso(boolean exitoso) {
        this.exitoso = exitoso;
    }

    // Métodos
    protected abstract boolean validar();

    protected abstract boolean debitar();

    public boolean procesarPago() {
        if (!this.validar()) {
            this.setExitoso(false);
            return false;
        }
        if (this.debitar()) {
            this.setExitoso(true);
            return true;
        }
        this.setExitoso(false);
        return false;
    }

}
