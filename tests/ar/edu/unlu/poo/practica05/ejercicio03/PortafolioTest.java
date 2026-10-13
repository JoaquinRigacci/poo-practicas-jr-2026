package ar.edu.unlu.poo.practica05.ejercicio03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PortafolioTest {

    private Mercado mercado;
    private Portafolio portafolio;

    @BeforeEach
    public void setUp() {
        this.mercado = new Mercado();
        this.portafolio = new Portafolio(this.mercado);
    }

    @Test
    @DisplayName("Verificar que agregar posiciones acumule correctamente la tenencia de divisas.")
    public void testAgregarYConsultarPosicion() {
        this.portafolio.agregarPosicion("EUR", 100.0);
        this.portafolio.agregarPosicion("EUR", 50.0); // Acumula
        this.portafolio.agregarPosicion("USD", 200.0);

        assertEquals(150.0, this.portafolio.getPosicion("EUR"));
        assertEquals(200.0, this.portafolio.getPosicion("USD"));
        assertEquals(0.0, this.portafolio.getPosicion("BRL")); // Divisa sin tenencia
    }

    @Test
    @DisplayName("Verificar el cálculo del valor total en USD consultando las cotizaciones del mercado.")
    public void testCalcularValorTotalUSDExitoso() {
        // Cargamos cotizaciones en el mercado
        this.mercado.actualizarCotizacion("EUR", 1.10); // 1 EUR = 1.10 USD
        this.mercado.actualizarCotizacion("BRL", 0.20); // 1 BRL = 0.20 USD

        // Agregamos tenencias al portafolio
        this.portafolio.agregarPosicion("EUR", 100.0); // 100 * 1.10 = 110 USD
        this.portafolio.agregarPosicion("BRL", 500.0); // 500 * 0.20 = 100 USD

        // Total esperado = 210 USD
        assertEquals(210.0, this.portafolio.calcularValorTotalUSD());
    }

    @Test
    @DisplayName("Verificar que al actualizar la cotización en el mercado varíe la valuación del portafolio en tiempo real.")
    public void testCalcularValorTotalConCotizacionActualizadaEnVivo() {
        this.mercado.actualizarCotizacion("EUR", 1.00);
        this.portafolio.agregarPosicion("EUR", 100.0);

        assertEquals(100.0, this.portafolio.calcularValorTotalUSD());

        // El mercado actualiza el precio del Euro
        this.mercado.actualizarCotizacion("EUR", 1.20);

        // El portafolio refleja el cambio automáticamente sin modificar su estado interno
        assertEquals(120.0, this.portafolio.calcularValorTotalUSD());
    }

    @Test
    @DisplayName("Verificar que calcular la valuación con una divisa sin cotización lance CotizacionNoEncontradaException.")
    public void testCalcularValorTotalConDivisaSinCotizacionLanzaExcepcion() {
        this.portafolio.agregarPosicion("EUR", 100.0);
        // NO agregamos la cotización de EUR al mercado

        assertThrows(CotizacionNoEncontradaException.class, () -> {
            this.portafolio.calcularValorTotalUSD();
        });
    }

    @Test
    @DisplayName("Verificar que instanciar un portafolio con mercado nulo lance IllegalArgumentException.")
    public void testConstructorMercadoNuloLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Portafolio(null);
        });
    }

    @Test
    @DisplayName("Verificar que agregar una posición con parámetros inválidos lance IllegalArgumentException.")
    public void testAgregarPosicionParametrosInvalidosLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.portafolio.agregarPosicion(null, 100.0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            this.portafolio.agregarPosicion("EUR", 0.0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            this.portafolio.agregarPosicion("EUR", -50.0);
        });
    }
}
