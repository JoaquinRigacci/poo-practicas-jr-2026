package ar.edu.unlu.poo.practica06.ejercicio02;

import java.util.ArrayList;
import java.util.List;

public class EmpresaLogistica {

    // Atributos
    private final List<Envio> envios;

    // Constructor
    public EmpresaLogistica() {
        this.envios = new ArrayList<>();
    }

    // Métodos
    public void agregarEnvio(Envio envio) {
        if (envio == null) {
            throw new IllegalArgumentException("ERROR. El envío no puede ser nulo.");
        }
        this.envios.add(envio);
    }

    public double calcularCostoTotal() {
        double costoTotal = 0.0;
        for (Envio envio : this.envios) {
            costoTotal += envio.calcularCosto();
        }

        return costoTotal;
    }
}
