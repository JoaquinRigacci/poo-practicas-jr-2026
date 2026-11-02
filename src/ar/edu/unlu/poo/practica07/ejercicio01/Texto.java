package ar.edu.unlu.poo.practica07.ejercicio01;

public class Texto implements Dibujable{

    // Atributos
    private String contenido;
    private int tamanioFuente;

    // Constructor
    public Texto(String contenido, int tamanioFuente) {
        this.setContenido(contenido);
        this.setTamanioFuente(tamanioFuente);
    }

    // Getter
    public String getContenido() {
        return this.contenido;
    }

    public int getTamanioFuente() {
        return this.tamanioFuente;
    }

    // Setter
    public void setContenido(String contenido) {
        if (contenido == null || contenido.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR. El contenido no puede ser nulo.");
        }
        this.contenido = contenido;
    }

    public void setTamanioFuente(int tamanioFuente) {
        if (tamanioFuente <= 0) {
            throw new IllegalArgumentException("ERROR. El tamaño de la fuente debe ser mayor a 0.");
        }
        this.tamanioFuente = tamanioFuente;
    }

    // Métodos
    @Override
    public void dibujar() {
        System.out.println("Dibujando el texto que contien lo siguiente: '" + this.getContenido() + "'. El tamaño de la fuente es de " + this.getTamanioFuente() + ".");
    }
}
