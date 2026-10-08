package ar.edu.unlu.poo.practica05.ejercicio02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Banco {

    // Atributos
    private final List<Cliente> clientes;

    // Constructor
    public Banco() {
        this.clientes = new ArrayList<>();
    }

    // Getter
    public List<Cliente> getClientes() {
        return Collections.unmodifiableList(this.clientes);
    }

    // Métodos
    public void registrarCliente(String dni, String nombre) {
        Cliente nuevoCliente = new Cliente(dni, nombre);

        if (this.clientes.contains(nuevoCliente)) {
            throw new ClienteDuplicadoException("ERROR. Ya existe un cliente registrado con el DNI: " + dni);
        }

        clientes.add(nuevoCliente);
    }

    public void asociarTarjeta(String dni, String numeroTarjeta) {
        Cliente cliente = buscarCliente(dni);

        if (existeTarjetaEnBanco(numeroTarjeta)) {
            throw new TarjetaDuplicadaException("ERROR. La tarjeta " + numeroTarjeta +
                    " ya se encuentra registrada en el banco.");
        }

        Tarjeta tarjetaLimpia = new Tarjeta(numeroTarjeta.trim());
        cliente.agregarTarjeta(tarjetaLimpia);
    }

    private boolean existeTarjetaEnBanco(String numeroTarjeta) {
        if (numeroTarjeta == null) return false;

        for (Cliente cliente : this.clientes) {
            for (Tarjeta tarjeta : cliente.getTarjetas()) {
                if (tarjeta.getNumero().equalsIgnoreCase(numeroTarjeta.trim())) {
                    return true; // La tarjeta ya tiene algún cliente.
                }
            }
        }
        return false;
    }

    public Cliente buscarCliente(String dni) {
        if (dni == null) {
            throw new IllegalArgumentException("ERROR. El DNI no puede ser nulo.");
        }

        String dniLimpio = dni.trim();
        for (Cliente cliente : clientes) {
            if(cliente.getDni().trim().equalsIgnoreCase(dniLimpio)) {
                return cliente;
            }
        }
        throw new IllegalArgumentException("ERROR. No se encuentra registrado el cliente con DNI: " + dni);
    }
}
