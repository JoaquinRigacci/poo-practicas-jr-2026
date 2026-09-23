package ar.edu.unlu.poo.practica04.ejercicio02;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Biblioteca {

    // Atributo
    private List<Libro> libros;

    // Constructor
    public Biblioteca() {
        this.libros = new ArrayList<>();
    }

    // Métodos
    public List<String> titulosDesde(int anioPublicacion) {
        return this.libros.stream().filter(a -> a.getAnioPublicacion() >= anioPublicacion)
                        .map(Libro::getTitulo).toList();
    }

    public Set<String> autoresUnicos() {
        return this.libros.stream().map(Libro::getNombreAutorPrincipal).collect(Collectors.toSet());
    }

    // Método para agregar libros
    public void agregarLibro(Libro libro) {
        if (libro != null) {
            this.libros.add(libro);
        } else {
            throw new IllegalArgumentException("ERROR. El libro no puede ser nulo.");
        }
    }
}
