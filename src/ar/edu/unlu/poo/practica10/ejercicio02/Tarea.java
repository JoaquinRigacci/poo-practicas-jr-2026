package ar.edu.unlu.poo.practica10.ejercicio02;

public class Tarea {

    // Atributos
    private static int contadorId = 0;
    private final int id;
    private final String descripcion; // texto
    private boolean completada; // Completada = true , Pendiente = false

    // Constructor
    public Tarea(String descripcion) {
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR. La descripción no puede ser nula.");
        }
        this.id = ++contadorId;
        this.descripcion = descripcion;
        this.completada = false;
    }

    // Getter
    public int getId() {
        return this.id;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public boolean isCompletada() {
        return this.completada;
    }

    // Método
    public void marcarComoCompletada() {
        this.completada = true;
    }
}
