package ar.edu.unlu.poo.practica06.ejercicio01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VentaTest {

    private Venta venta;

    @BeforeEach
    public void setUp() {
        this.venta = new Venta();
    }

    @Test
    @DisplayName("Verificar que una venta sin prendas empiece con un total de 0.0.")
    public void testVentaVaciaTotalCero() {
        assertEquals(0.0, this.venta.calcularTotal(), 0.001);
    }

    @Test
    @DisplayName("Verificar el cálculo polimórfico del total mezclando distintas prendas, remeras y pantalones.")
    public void testCalcularTotalPolimorficoExitoso() {
        // Prenda base: $1000.0 -> Final = $1000.0
        Prenda camisa = new Prenda("Camisa Lisa", 1000.0);

        // Remera común: $2000.0 -> Final = $2000.0
        Remera remeraComun = new Remera("Remera Lisa", 2000.0, false, 500.0);

        // Remera importada: $2000.0 + $500.0 recargo -> Final = $2500.0
        Remera remeraImportada = new Remera("Remera Estampada Imp", 2000.0, true, 500.0);

        // Pantalón temporada actual: $5000.0 -> Final = $5000.0
        Pantalon jeanActual = new Pantalon("Jean Slim", 5000.0, false);

        // Pantalón temporada anterior: $5000.0 - 10% desc ($500.0) -> Final = $4500.0
        Pantalon jeanAnterior = new Pantalon("Jean Classic 2023", 5000.0, true);

        // Agregamos todas las prendas a la venta
        this.venta.agregarPrenda(camisa);
        this.venta.agregarPrenda(remeraComun);
        this.venta.agregarPrenda(remeraImportada);
        this.venta.agregarPrenda(jeanActual);
        this.venta.agregarPrenda(jeanAnterior);

        // Total esperado = 1000 + 2000 + 2500 + 5000 + 4500 = 15000.0
        assertEquals(15000.0, this.venta.calcularTotal(), 0.001);
    }

    @Test
    @DisplayName("Verificar que agregar una prenda nula lance IllegalArgumentException.")
    public void testAgregarPrendaNulaLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.venta.agregarPrenda(null);
        });
    }
}
