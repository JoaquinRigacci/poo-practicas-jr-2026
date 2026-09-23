package ar.edu.unlu.poo.practica04.ejercicio03;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class GestorSensores {

    // Atributps
    private List<Medicion> mediciones;

    // Constructor
    public GestorSensores() {
        this.mediciones = new ArrayList<>();
    }

    // Métodos
    public OptionalDouble obtenerPromedio() {
        return this.mediciones.stream().mapToDouble(Medicion::getTemperaturaCelsius).average();
    }

    public OptionalDouble obtenerMaxima() {
        return this.mediciones.stream().mapToDouble(Medicion::getTemperaturaCelsius).max();
    }

    // Método para agregar medicion
    public void agregarMedicion(Medicion medicion) {
        if (medicion != null) {
            this.mediciones.add(medicion);
        } else {
            throw new IllegalArgumentException("ERROR. La medición no puede ser nula.");
        }
    }
}
