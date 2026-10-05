package ar.edu.unlu.poo.practica04.ejercicio03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.OptionalDouble;

import static org.junit.jupiter.api.Assertions.*;

public class    GestorSensoresTest {

    private GestorSensores gestor;
    private Medicion m1;
    private Medicion m2;
    private Medicion m3;

    @BeforeEach
    public void setUp() {
        gestor = new GestorSensores();
        LocalDateTime ahora = LocalDateTime.now();

        // Creamos tres mediciones: 15.0°C, 25.0°C y 20.0°C
        m1 = new Medicion(15.0, ahora);
        m2 = new Medicion(25.0, ahora.plusMinutes(10));
        m3 = new Medicion(20.0, ahora.plusMinutes(20));

        gestor.agregarMedicion(m1);
        gestor.agregarMedicion(m2);
        gestor.agregarMedicion(m3);
    }

    @Test
    @DisplayName("Debe calcular el promedio de temperatura correctamente")
    public void testObtenerPromedio() {
        OptionalDouble promedio = gestor.obtenerPromedio();

        assertTrue(promedio.isPresent(), "El promedio debe estar presente");
        // Promedio entre 15.0, 25.0 y 20.0 es 20.0
        assertEquals(20.0, promedio.getAsDouble(), 0.001);
    }

    @Test
    @DisplayName("Debe retornar OptionalDouble vacío al calcular promedio sin mediciones")
    public void testObtenerPromedioListaVacia() {
        GestorSensores gestorVacio = new GestorSensores();
        OptionalDouble promedio = gestorVacio.obtenerPromedio();

        assertTrue(promedio.isEmpty(), "El OptionalDouble debe estar vacío");
    }

    @Test
    @DisplayName("Debe obtener la temperatura máxima de las mediciones registradas")
    public void testObtenerMaxima() {
        OptionalDouble maxima = gestor.obtenerMaxima();

        assertTrue(maxima.isPresent(), "La máxima debe estar presente");
        assertEquals(25.0, maxima.getAsDouble(), 0.001);
    }

    @Test
    @DisplayName("Debe retornar OptionalDouble vacío al buscar la máxima sin mediciones")
    public void testObtenerMaximaListaVacia() {
        GestorSensores gestorVacio = new GestorSensores();
        OptionalDouble maxima = gestorVacio.obtenerMaxima();

        assertFalse(maxima.isPresent(), "El OptionalDouble no debe contener valor");
    }

    @Test
    @DisplayName("Debe lanzar excepción al intentar agregar una medición nula")
    public void testAgregarMedicionNula() {
        assertThrows(IllegalArgumentException.class, () -> {
            gestor.agregarMedicion(null);
        });
    }
}
