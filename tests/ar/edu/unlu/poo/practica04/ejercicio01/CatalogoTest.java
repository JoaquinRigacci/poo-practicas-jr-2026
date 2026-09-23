package ar.edu.unlu.poo.practica04.ejercicio01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class CatalogoTest {

    private Catalogo catalogo;
    private Artefacto iphone;
    private Artefacto macbook;
    private Artefacto galaxy;

    @BeforeEach
    public void setUp() {
        // Preparamos los objetos de prueba antes de cada test
        catalogo = new Catalogo();
        iphone = new Artefacto("Apple", "iPhone 15", 999.99);
        macbook = new Artefacto("Apple", "MacBook Pro", 1999.99);
        galaxy = new Artefacto("Samsung", "Galaxy S24", 899.99);

        catalogo.agregarArtefacto(iphone);
        catalogo.agregarArtefacto(macbook);
        catalogo.agregarArtefacto(galaxy);
    }

    @Test
    @DisplayName("Debe filtrar los artefactos por marca correctamente")
    public void testFiltrarPorMarca() {
        List<Artefacto> deApple = catalogo.filtrarPorMarca("Apple");

        assertEquals(2, deApple.size());
        assertTrue(deApple.contains(iphone));
        assertTrue(deApple.contains(macbook));
    }

    @Test
    @DisplayName("Debe retornar únicamente los nombres de los modelos para una marca")
    public void testObtenerModelos() {
        List<String> modelosApple = catalogo.obtenerModelos("Apple");

        assertEquals(2, modelosApple.size());
        assertEquals("iPhone 15", modelosApple.get(0));
        assertEquals("MacBook Pro", modelosApple.get(1));
    }

    @Test
    @DisplayName("Debe encontrar el artefacto más caro presente en el Optional")
    public void testBuscarMasCaroExistente() {
        Optional<Artefacto> masCaroApple = catalogo.buscarMasCaro("Apple");

        assertTrue(masCaroApple.isPresent());
        assertEquals("MacBook Pro", masCaroApple.get().getModelo());
        assertEquals(1999.99, masCaroApple.get().getPrecioUSD());
    }

    @Test
    @DisplayName("Debe retornar un Optional vacío al buscar el más caro de una marca inexistente")
    public void testBuscarMasCaroInexistente() {
        Optional<Artefacto> masCaroSony = catalogo.buscarMasCaro("Sony");

        assertFalse(masCaroSony.isPresent());
        assertTrue(masCaroSony.isEmpty());
    }

    @Test
    @DisplayName("Debe lanzar excepción al intentar agregar un artefacto nulo")
    public void testAgregarArtefactoNulo() {
        assertThrows(IllegalArgumentException.class, () -> {
            catalogo.agregarArtefacto(null);
        });
    }
}