package ar.edu.unlu.poo.practica10.ejercicio02;

import java.util.ArrayList;
import java.util.List;

public class GestorTareas implements Observable{

    // Atributos
    private final List<Tarea> tareas;
    private final List<Observer> observadores;

    // Constructor
    public GestorTareas() {
        this.tareas = new ArrayList<>();
        this.observadores = new ArrayList<>();
    }

    // Getter
    public Tarea[] getTareas() {
        return this.tareas.toArray(new Tarea[0]);
    }

    // Implementación de Observable
    @Override
    public void addObserver(Observer observador) {
        if (observador != null && !this.observadores.contains(observador)) {
            this.observadores.add(observador);
        }
    }

    @Override
    public void removeObserver(Observer observador) {
        this.observadores.remove(observador);
    }

    @Override
    public void notifyObservers(EventoTarea evento) {
        for (Observer obs : this.observadores) {
            obs.update(evento, this);
        }
    }

    // Métodos de Negocio
    public void crearTarea(String descripcion) {
        Tarea nuevaTarea = new Tarea(descripcion);
        this.tareas.add(nuevaTarea);
        this.notifyObservers(EventoTarea.TAREA_CREADA);
    }

    public void completarTarea(int id) {
        Tarea tareaEncontrada = this.buscarPorId(id);
        if (tareaEncontrada != null && !tareaEncontrada.isCompletada()) {
            tareaEncontrada.marcarComoCompletada();
            this.notifyObservers(EventoTarea.TAREA_COMPLETADA);
        }
    }

    public void eliminarTarea(int id) {
        Tarea tareaEncontrada = this.buscarPorId(id);
        if (tareaEncontrada != null) {
            this.tareas.remove(tareaEncontrada);
            this.notifyObservers(EventoTarea.TAREA_ELIMINADA);
        }
    }

    // Método privado auxiliar
    private Tarea buscarPorId(int id) {
        for (Tarea t : this.tareas) {
            if (t.getId() == id) {
                return t; // Encontrada
            }
        }
        return null; // No existe
    }
}
