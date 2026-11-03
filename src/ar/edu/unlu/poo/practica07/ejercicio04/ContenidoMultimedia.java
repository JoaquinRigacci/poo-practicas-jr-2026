package ar.edu.unlu.poo.practica07.ejercicio04;

public abstract class ContenidoMultimedia {

    // Atributos
    private String titulo;
    private int duracionSegundos;
    private String creador;

    // Constructor
    public ContenidoMultimedia(String titulo, int duracionSegundos, String creador) {
        this.setTitulo(titulo);
        this.setDuracionSegundos(duracionSegundos);
        this.setCreador(creador);
    }

    // Getter
    public String getTitulo() {
        return this.titulo;
    }

    public int getDuracionSegundos() {
        return this.duracionSegundos;
    }

    public String getCreador() {
        return this.creador;
    }

    // Setter
    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR. El título no puede ser nulo.");
        }
        this.titulo = titulo;
    }

    public void setDuracionSegundos(int duracionSegundos) {
        if (duracionSegundos <= 0) {
            throw new IllegalArgumentException("ERROR. La duración en segundos debe ser mayor a 0.");
        }
        this.duracionSegundos = duracionSegundos;
    }

    public void setCreador(String creador) {
        if (creador == null || creador.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR. El creador no puede ser nulo.");
        }
        this.creador = creador;
    }

    // Método
    public abstract String reproducir();
}
