package ar.edu.unlu.poo.practica1.ejercicio02;

public class Cancion {

    // Atributos
    private String titulo;
    private String autor;
    private int segundos;

    // Constructor
    public Cancion(String titulo, String autor, int segundos) {
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setSegundos(segundos);
    }

    // Métodos

    // Getter
    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public int getSegundos() {
        return this.segundos;
    }

    // Setter
    public void setTitulo(String titulo) {
        if (titulo != null && !titulo.isEmpty()) {
            this.titulo = titulo;
        } else {
            throw new IllegalArgumentException("ERROR. Titulo no ingresado.");
        }
    }

    public void setAutor(String autor) {
        if (autor != null &&    !autor.isEmpty()) {
            this.autor = autor;
        } else {
            throw new IllegalArgumentException("ERROR. Autor no ingresado.");
        }
    }

    public void setSegundos(int segundos) {
        if (segundos > 0) {
            this.segundos = segundos;
        } else {
            throw new DuracionInvalidaException("ERROR. Los segundos deben ser mayores a 0.");
        }
    }


}
