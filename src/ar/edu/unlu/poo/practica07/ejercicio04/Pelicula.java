package ar.edu.unlu.poo.practica07.ejercicio04;

public class Pelicula extends ContenidoMultimedia implements Descargable{

    // Atributos
    private String resolucion;
    private boolean descargado;

    // Constructor
    public Pelicula(String titulo, int duracionSegundos, String creador, String resolucion) {
        super(titulo, duracionSegundos, creador);
        this.setResolucion(resolucion);
        this.setDescargado(false);
    }

    // Get
    public String getResolucion() {
        return this.resolucion;
    }

    // Set
    public void setResolucion(String resolucion) {
        if (resolucion == null || resolucion.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR. La resolución no puede ser nula.");
        }
        this.resolucion = resolucion;
    }

    public void setDescargado(boolean descargado) {
        this.descargado = descargado;
    }

    // Métodos
    @Override
    public String reproducir() {
        return "El título de la película es '" + this.getTitulo() + "', el director es " + this.getCreador() + " y la resolución de proyección es de " + this.getResolucion() + ".";
    }

    @Override
    public boolean isDescargado() {
        return this.descargado;
    }

    @Override
    public void descargar() {
        this.setDescargado(true);
    }
}
