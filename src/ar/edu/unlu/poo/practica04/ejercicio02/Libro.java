package ar.edu.unlu.poo.practica04.ejercicio02;

public class Libro {

    // Atributos
    private String titulo;
    private int anioPublicacion;
    private String nombreAutorPrincipal;

    // Constructor
    public Libro(String titulo, int anioPublicacion, String nombreAutorPrincipal) {
        this.setTitulo(titulo);
        this.setAnioPublicacion(anioPublicacion);
        this.setNombreAutorPrincipal(nombreAutorPrincipal);
    }

    // Getter
    public String getTitulo() {
        return this.titulo;
    }

    public int getAnioPublicacion() {
        return this.anioPublicacion;
    }

    public String getNombreAutorPrincipal() {
        return this.nombreAutorPrincipal;
    }

    // Setter
    public void setTitulo(String titulo) {
        if (titulo != null && !titulo.trim().isEmpty()) {
            this.titulo = titulo;
        } else {
            throw new IllegalArgumentException("ERROR. No se ingreso el titulo del libro.");
        }
    }

    public void setAnioPublicacion(int anioPublicacion) {
        if (anioPublicacion > 0) {
            this.anioPublicacion = anioPublicacion;
        } else {
            throw new IllegalArgumentException("ERROR. Año no válido.");
        }
    }

    public void setNombreAutorPrincipal(String nombreAutorPrincipal) {
        if (nombreAutorPrincipal != null && !nombreAutorPrincipal.trim().isEmpty()) {
            this.nombreAutorPrincipal = nombreAutorPrincipal;
        } else {
            throw new IllegalArgumentException("ERROR. No se ingreso el nombre del autor principal del libro.");
        }
    }

}
