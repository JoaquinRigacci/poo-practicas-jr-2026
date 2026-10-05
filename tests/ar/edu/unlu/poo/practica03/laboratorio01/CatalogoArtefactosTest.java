package ar.edu.unlu.poo.practica03.laboratorio01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CatalogoArtefactosTest {

    private CatalogoArtefactos catalogo;
    private Artefacto varita;
    private Artefacto pocion;
    private Artefacto amuleto;
    private Artefacto varitaPoderosa;

    @BeforeEach
    public void setUp() {
        // Preparamos el catálogo y artefactos de prueba antes de cada test
        catalogo = new CatalogoArtefactos();
        varita = new Artefacto("Varita de Saúco", 90, "Varita");
        pocion = new Artefacto("Poción de Curación", 30, "Poción");
        amuleto = new Artefacto("Amuleto de Protección", 50, "Amuleto");
        varitaPoderosa = new Artefacto("Varita de Fuego", 100, "Varita");

        catalogo.agregarArtefacto(varita);
        catalogo.agregarArtefacto(pocion);
        catalogo.agregarArtefacto(amuleto);
        catalogo.agregarArtefacto(varitaPoderosa);
    }

    @Test
    @DisplayName("Debe agregar artefactos correctamente y verificar el tamaño")
    public void testAgregarArtefacto() {
        assertEquals(4, catalogo.obtenerArtefactosUnicos().size());
    }

    @Test
    @DisplayName("Debe evitar añadir artefactos duplicados por nombre y tipo")
    public void testNoAgregaDuplicados() {
        // Intentamos agregar un artefacto con mismo nombre y tipo que 'varita'
        Artefacto varitaRepetida = new Artefacto("Varita de Saúco", 70, "Varita");
        boolean agregado = catalogo.agregarArtefacto(varitaRepetida);

        assertFalse(agregado, "No debe agregar un artefacto duplicado");
        assertEquals(4, catalogo.obtenerArtefactosUnicos().size(), "El tamaño del conjunto único no debe cambiar");
    }

    @Test
    @DisplayName("Debe buscar artefactos por tipo y retornarlos ordenados de menor a mayor poder")
    public void testBuscarArtefactosPorTipoOrdenados() {
        List<Artefacto> varitas = catalogo.buscarArtefactosPorTipo("Varita");

        assertEquals(2, varitas.size());
        // La Varita de Saúco (poder 90) debe ir antes que la Varita de Fuego (poder 100)
        assertEquals("Varita de Saúco", varitas.get(0).getNombre());
        assertEquals("Varita de Fuego", varitas.get(1).getNombre());
    }

    @Test
    @DisplayName("Debe contar la cantidad de artefactos por cada tipo")
    public void testContarArtefactosPorTipo() {
        Map<String, Integer> conteo = catalogo.contarArtefactosPorTipo();

        assertEquals(2, conteo.get("Varita"));
        assertEquals(1, conteo.get("Poción"));
        assertEquals(1, conteo.get("Amuleto"));
    }

    @Test
    @DisplayName("Debe lanzar excepción al ingresar valores nulos o vacíos")
    public void testValidacionExcepciones() {
        assertThrows(IllegalArgumentException.class, () -> {
            catalogo.agregarArtefacto(null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            catalogo.buscarArtefactosPorTipo(" ");
        });
    }
}
