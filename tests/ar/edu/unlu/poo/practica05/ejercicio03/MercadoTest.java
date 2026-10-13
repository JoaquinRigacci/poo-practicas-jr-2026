package ar.edu.unlu.poo.practica05.ejercicio03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MercadoTest {

    private Mercado mercado;

    @BeforeEach
    public void setUp() {
        this.mercado = new Mercado();
    }

    @Test
    @DisplayName("Verificar que se pueda guardar y consultar la cotización de una divisa válida.")
    public void testActualizarYObtenerCotizacionExitoso() {
        this.mercado.actualizarCotizacion("EUR", 1.08);
        assertEquals(1.08, this.mercado.getCotizacion("EUR"));
    }

    @Test
    @DisplayName("Verificar que al actualizar el valor de una divisa existente se sobrescriba con la nueva cotización.")
    public void testActualizarCotizacionExistente() {
        this.mercado.actualizarCotizacion("EUR", 1.08);
        this.mercado.actualizarCotizacion("EUR", 1.10);
        assertEquals(1.10, this.mercado.getCotizacion("EUR"));
    }

    @Test
    @DisplayName("Verificar que la búsqueda de divisas no sea sensible a minúsculas ni a espacios alrededor.")
    public void testCotizacionIndependienteDeEspaciosYMayusculas() {
        this.mercado.actualizarCotizacion(" eur ", 1.08);
        assertEquals(1.08, this.mercado.getCotizacion("EUR"));
        assertEquals(1.08, this.mercado.getCotizacion("eur"));
        assertEquals(1.08, this.mercado.getCotizacion(" Eur "));
    }

    @Test
    @DisplayName("Verificar que consultar una divisa no registrada lance CotizacionNoEncontradaException.")
    public void testCotizacionNoEncontradaLanzaExcepcion() {
        assertThrows(CotizacionNoEncontradaException.class, () -> {
            this.mercado.getCotizacion("BRL");
        });
    }

    @Test
    @DisplayName("Verificar que pasar una divisa nula o vacía lance IllegalArgumentException.")
    public void testDivisaInvalidaLanzaExcepcion() {
        // En getCotizacion
        assertThrows(IllegalArgumentException.class, () -> {
            this.mercado.getCotizacion(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            this.mercado.getCotizacion(" ");
        });

        // En actualizarCotizacion
        assertThrows(IllegalArgumentException.class, () -> {
            this.mercado.actualizarCotizacion(null, 1.08);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            this.mercado.actualizarCotizacion("", 1.08);
        });
    }

    @Test
    @DisplayName("Verificar que ingresar un valor menor o igual a cero lance IllegalArgumentException.")
    public void testValorInvalidoLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.mercado.actualizarCotizacion("EUR", 0.0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            this.mercado.actualizarCotizacion("EUR", -10.5);
        });
    }
}
