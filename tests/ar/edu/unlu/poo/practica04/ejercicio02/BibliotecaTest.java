package ar.edu.unlu.poo.practica04.ejercicio02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class BibliotecaTest {

    private Biblioteca biblioteca;
    private Libro libro1;
    private Libro libro2;
    private Libro libro3;
    private Libro libro4;

    @BeforeEach
    public void setUp() {
        // Preparamos la biblioteca con datos conocidos antes de cada prueba
        biblioteca = new Biblioteca();

        libro1 = new Libro("Cien años de soledad", 1967, "Gabriel García Márquez");
        libro2 = new Libro("El amor en los tiempos del cólera", 1985, "Gabriel García Márquez");
        libro3 = new Libro("Ficciones", 1944, "Jorge Luis Borges");
        libro4 = new Libro("Rayuela", 1963, "Julio Cortázar");

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);
        biblioteca.agregarLibro(libro4);
    }

    @Test
    @DisplayName("Debe devolver los títulos de libros publicados a partir del año indicado")
    public void testTitulosDesde() {
        List titulos = biblioteca.titulosDesde(1963);

        assertEquals(3, titulos.size());
        assertTrue(titulos.contains("Cien años de soledad"));
        assertTrue(titulos.contains("El amor en los tiempos del cólera"));
        assertTrue(titulos.contains("Rayuela"));
        assertFalse(titulos.contains("Ficciones"));
    }

    @Test
    @DisplayName("Debe devolver una lista vacía si ningún libro cumple el criterio de año")
    public void testTitulosDesdeAnioFuturo() {
        List titulos = biblioteca.titulosDesde(2030);

        assertTrue(titulos.isEmpty());
    }

    @Test
    @DisplayName("Debe devolver un Set de autores únicos sin duplicados")
    public void testAutoresUnicos() {
        Set autores = biblioteca.autoresUnicos();

        // Agregamos 4 libros pero solo hay 3 autores distintos
        assertEquals(3, autores.size());
        assertTrue(autores.contains("Gabriel García Márquez"));
        assertTrue(autores.contains("Jorge Luis Borges"));
        assertTrue(autores.contains("Julio Cortázar"));
    }

    @Test
    @DisplayName("Debe lanzar excepción al intentar agregar un libro nulo")
    public void testAgregarLibroNulo() {
        assertThrows(IllegalArgumentException.class, () -> {
            biblioteca.agregarLibro(null);
        });
    }
}
