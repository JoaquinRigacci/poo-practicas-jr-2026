package ar.edu.unlu.poo.practica06.ejercicio03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReservaTest {

    private Vehiculo vehiculoEstandar;
    private AutoVIP autoVip;
    private Camioneta camioneta;

    @BeforeEach
    public void setUp() {
        // Vehículo estándar: tarifa diaria $10.000,00
        this.vehiculoEstandar = new Vehiculo(10000.0);

        // Auto VIP: tarifa diaria $15.000,00 | costo fijo adicional: $5.000,00
        this.autoVip = new AutoVIP(15000.0, 5000.0);

        // Camioneta: tarifa diaria $12.000,00 | recargo/kg: $50,00 | 200 kg declarados
        this.camioneta = new Camioneta(12000.0, 50.0, 200.0);
    }

    @Test
    @DisplayName("Verificar el cálculo del monto total para un Vehículo estándar.")
    public void testCalcularMontoTotalVehiculoEstandar() {
        // 3 días * $10.000 = $30.000,00
        Reserva reserva = new Reserva(this.vehiculoEstandar, 3);
        assertEquals(30000.0, reserva.calcularMontoTotal(), 0.001);
    }

    @Test
    @DisplayName("Verificar el cálculo polimórfico del monto total para un AutoVIP.")
    public void testCalcularMontoTotalAutoVIP() {
        // (2 días * $15.000) + $5.000 adicional = $35.000,00
        Reserva reserva = new Reserva(this.autoVip, 2);
        assertEquals(35000.0, reserva.calcularMontoTotal(), 0.001);
    }

    @Test
    @DisplayName("Verificar el cálculo polimórfico del monto total para una Camioneta.")
    public void testCalcularMontoTotalCamioneta() {
        // (4 días * $12.000) + (200 kg * $50) = $48.000 + $10.000 = $58.000,00
        Reserva reserva = new Reserva(this.camioneta, 4);
        assertEquals(58000.0, reserva.calcularMontoTotal(), 0.001);
    }

    @Test
    @DisplayName("Verificar que instanciar una Reserva con vehículo nulo lance IllegalArgumentException.")
    public void testVehiculoNuloLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Reserva(null, 5);
        });
    }

    @Test
    @DisplayName("Verificar que instanciar una Reserva con días <= 0 lance IllegalArgumentException.")
    public void testDiasInvalidosLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Reserva(this.vehiculoEstandar, 0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Reserva(this.vehiculoEstandar, -3);
        });
    }
}
