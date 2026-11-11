package ar.edu.unlu.poo.practica10.ejercicio02;

/**
 * Doble de Prueba Artesanal (Test Spy) que implementa VistaTareas.
 * Registra las interacciones visuales para permitir aserciones en JUnit 5.
 */
public class VistaTareasSpy implements VistaTareas {

    private ControladorTareas controlador;

    private boolean llamadoInformacion = false;
    private int cantidadLlamadasInformacion = 0;
    private Tarea[] ultimasTareasRecibidas = null;

    private boolean llamadoError = false;
    private String ultimoErrorRecibido = null;

    @Override
    public void setControlador(ControladorTareas controlador) {
        this.controlador = controlador;
    }

    @Override
    public void mostrarInformacion(Tarea[] tareas) {
        this.llamadoInformacion = true;
        this.cantidadLlamadasInformacion++;
        this.ultimasTareasRecibidas = tareas;
    }

    @Override
    public void mostrarError(String error) {
        this.llamadoError = true;
        this.ultimoErrorRecibido = error;
    }

    @Override
    public void iniciar() {
        // En los tests no abrimos consolas ni bucles de lectura
    }

    // =========================================================================
    // MÉTODOS DE INSPECCIÓN (Exclusivos para las aserciones de JUnit 5)
    // =========================================================================

    public boolean fueLlamadoMostrarInformacion() {
        return this.llamadoInformacion;
    }

    public int getCantidadLlamadasInformacion() {
        return this.cantidadLlamadasInformacion;
    }

    public Tarea[] getUltimasTareasRecibidas() {
        return this.ultimasTareasRecibidas;
    }

    public boolean fueLlamadoMostrarError() {
        return this.llamadoError;
    }

    public String getUltimoErrorRecibido() {
        return this.ultimoErrorRecibido;
    }

    public void reiniciar() {
        this.llamadoInformacion = false;
        this.cantidadLlamadasInformacion = 0;
        this.ultimasTareasRecibidas = null;
        this.llamadoError = false;
        this.ultimoErrorRecibido = null;
    }
}
