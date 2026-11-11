package ar.edu.unlu.poo.practica10.ejercicio02;

public interface VistaTareas {
    void iniciar();
    void mostrarInformacion(Tarea[] tareas);
    void mostrarError(String error);
    void setControlador(ControladorTareas controlador);
}
