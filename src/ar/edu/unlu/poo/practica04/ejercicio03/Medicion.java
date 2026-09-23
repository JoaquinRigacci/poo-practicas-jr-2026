package ar.edu.unlu.poo.practica04.ejercicio03;

import java.time.LocalDateTime;

public class Medicion {

    // Atributos
    private double temperaturaCelsius;
    private LocalDateTime fechaHoraCaptura;

    // Constructor
    public Medicion(double temperaturaCelsius, LocalDateTime fechaHoraCaptura) {
        this.setTemperaturaCelsius(temperaturaCelsius);
        this.setFechaHoraCaptura(fechaHoraCaptura);
    }

    // Getter
    public double getTemperaturaCelsius() {
        return this.temperaturaCelsius;
    }

    public LocalDateTime getFechaHoraCaptura() {
        return this.fechaHoraCaptura;
    }

    // Setter
    public void setTemperaturaCelsius(double temperaturaCelsius) {
        if (temperaturaCelsius >= -273.15) {
            this.temperaturaCelsius = temperaturaCelsius;
        } else {
            throw new IllegalArgumentException("ERROR. La temperatura no puede ser menor a -273.15");
        }
    }

    public void setFechaHoraCaptura(LocalDateTime fechaHoraCaptura) {
        if (fechaHoraCaptura != null) {
            this.fechaHoraCaptura = fechaHoraCaptura;
        } else {
            throw new IllegalArgumentException("ERROR. La fecha y hora de captura no puede ser nula.");
        }
    }
}
