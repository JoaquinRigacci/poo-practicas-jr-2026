package ar.edu.unlu.poo.practica10.ejercicio03;

public abstract class Recurso {

    // Atributos
    private String titulo;
    private boolean prestado; // Cada objeto individual sabe si está prestado (`true`) o en la biblioteca (`false`).

    // Constructor
    public Recurso(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR: El título no puede ser nulo.");
        }
        this.titulo = titulo;
        this.prestado = false;
    }

    // Getter
    public String getTitulo() {
        return this.titulo;
    }

    public boolean isPrestado() {
        return this.prestado;
    }

    // Métodos
    public void marcarComoPrestado() {
        this.prestado = true;
    }

    public void marcarComoDevuelto() {
        this.prestado = false;
    }

    // Métodos Abstractos
    public abstract int getPlazoPrestamoDias();

    public abstract double calcularPenalizacion(int diasMora);
}
