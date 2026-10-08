package ar.edu.unlu.poo.practica05.ejercicio02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Cliente {

    // Atributos
    private final String dni;
    private final String nombre;
    private final List<Tarjeta> tarjetas;

    // Constructor
    public Cliente(String dni, String nombre) {
        if (dni != null && !dni.trim().isEmpty()) {
            this.dni = dni;
        } else {
            throw new IllegalArgumentException ("ERROR. No se ingreso el dni.");
        }

        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        } else {
            throw new IllegalArgumentException ("ERROR. No se ingreso el nombre.");
        }

        this.tarjetas = new ArrayList<>();
    }

    // Getter
    public String getDni() {
        return this.dni;
    }

    public String getNombre() {
        return this.nombre;
    }

    public List<Tarjeta> getTarjetas() {
        return Collections.unmodifiableList(this.tarjetas);
    }

    // Métodos
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return this.dni.equalsIgnoreCase(cliente.dni);
    }

    @Override
    public int hashCode() {
        return this.dni.toLowerCase().hashCode();
    }

    public void agregarTarjeta(Tarjeta tarjeta) {
        if (this.tarjetas.contains(tarjeta)) {
            throw new TarjetaDuplicadaException("El cliente ya posee esta tarjeta.");
        }
        this.tarjetas.add(tarjeta);
    }
}
