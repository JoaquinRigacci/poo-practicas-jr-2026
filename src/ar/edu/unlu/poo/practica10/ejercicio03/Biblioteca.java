package ar.edu.unlu.poo.practica10.ejercicio03;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca implements ObservableBiblioteca{

    // Atributos
    private List<Prestamo> prestamos;
    private List<ObserverBiblioteca> observadores;
    private int contadorId;

    // Constructor
    public Biblioteca() {
        this.prestamos = new ArrayList<>();
        this.observadores = new ArrayList<>();
        this.contadorId = 0;
    }

    // Métodos Observer
    @Override
    public void addObserver(ObserverBiblioteca observer) {
        if (observer == null) {
            throw new IllegalArgumentException("ERROR: El observer no puede ser nulo.");
        }
        this.observadores.add(observer);
    }

    @Override
    public void removeObserver(ObserverBiblioteca observer) {
        if (observer == null) {
            throw new IllegalArgumentException("ERROR: El observer no puede ser nulo.");
        }
        this.observadores.remove(observer);
    }

    @Override
    public void notifyObservers(EventosBiblioteca evento, TransaccionPrestamo transaccion) {
        for (ObserverBiblioteca obs : observadores) {
            obs.update(evento, transaccion);
        }
    }

    // Métodos de Negocio
    public TransaccionPrestamo registrarPrestamo(Recurso recurso, Socio socio) {
        Prestamo nuevo = new Prestamo(++contadorId, recurso, socio);
        this.prestamos.add(nuevo);
        notifyObservers(EventosBiblioteca.PRESTAMO_REGISTRADO, nuevo);
        return nuevo;
    }

    public double registrarDevolucion(int idPrestamo, int diasMora) {
        Prestamo encontrado = buscarPrestamoPorId(idPrestamo);
        if (encontrado == null) {
            throw new IllegalArgumentException("ERROR: No se encontró el prestamos.");
        }
        double penalizacion = encontrado.registrarDevolucion(diasMora);
        notifyObservers(EventosBiblioteca.DEVOLUCION_REGISTRADA, encontrado);
        return penalizacion;
    }

    // Método auxiliar de búsqueda por ID
    private Prestamo buscarPrestamoPorId(int id) {
        for (Prestamo p : this.prestamos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}
