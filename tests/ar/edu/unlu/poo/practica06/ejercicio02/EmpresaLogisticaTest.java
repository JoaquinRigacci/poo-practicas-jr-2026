package ar.edu.unlu.poo.practica06.ejercicio02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmpresaLogisticaTest {

    private EmpresaLogistica empresa;

    @BeforeEach
    public void setUp() {
        this.empresa = new EmpresaLogistica();
    }

    @Test
    @DisplayName("Verificar que una empresa sin envíos empiece con costo total en 0.0.")
    public void testEmpresaVaciaCostoCero() {
        assertEquals(0.0, this.empresa.calcularCostoTotal(), 0.001);
    }

    @Test
    @DisplayName("Verificar cálculo polimórfico del costo total combinando los 3 tipos de envíos.")
    public void testCalcularCostoTotalPolimorficoExitoso() {
        // 1. Envío Estándar <= 10 kg (100 km, 5 kg): $50 * 100 = $5000.0
        Envio estandarLiviano = new EnvioEstandar(5.0, 100.0);

        // 2. Envío Estándar > 10 kg (100 km, 15 kg): ($50 * 100) + 20% recargo = $5000.0 + $1000.0 = $6000.0
        Envio estandarPesado = new EnvioEstandar(15.0, 100.0);

        // 3. Envío Express (50 km, 2 kg): ($90 * 50) + $500.0 prioridad = $4500.0 + $500.0 = $5000.0
        Envio express = new EnvioExpress(2.0, 50.0);

        // 4. Envío Internacional > 10 kg (200 km, 20 kg, tasa $1500.0):
        // Estándar pesados ($50 * 200 = $10000 + 20% = $12000) + Tasa ($1500) = $13500.0
        Envio internacional = new EnvioInternacional(20.0, 200.0, 1500.0);

        // Agregamos todos los envíos a la empresa
        this.empresa.agregarEnvio(estandarLiviano);
        this.empresa.agregarEnvio(estandarPesado);
        this.empresa.agregarEnvio(express);
        this.empresa.agregarEnvio(internacional);

        // Costo Total Esperado = 5000 + 6000 + 5000 + 13500 = 29500.0
        assertEquals(29500.0, this.empresa.calcularCostoTotal(), 0.001);
    }

    @Test
    @DisplayName("Verificar que agregar un envío nulo lance IllegalArgumentException.")
    public void testAgregarEnvioNuloLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.empresa.agregarEnvio(null);
        });
    }
}
