package ar.edu.unlu.poo.practica05.ejercicio01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CuentaTest {

    private Cuenta cuenta;

    @BeforeEach
    public void setUp() {

        this.cuenta = new Cuenta("USD");
    }

    @Test
    @DisplayName("Verifica que la creación de la cuenta sea exitosa.")
    public void testCreacionDeCuentaExitosa() {
        assertEquals(0.0, cuenta.getSaldo());
        assertEquals("USD", cuenta.getDivisa());
    }

    @Test
    @DisplayName("Verifica depositación exitosa.")
    public void testDepositacionExitosa() {
        cuenta.depositar(100.0);
        assertEquals(100.0, cuenta.getSaldo());
    }

    @Test
    @DisplayName("Verificar extracción exitosa.")
    public void testExtraccionExitosa() {
        cuenta.depositar(100.0);
        cuenta.extraer(40.0);
        assertEquals(60.0, cuenta.getSaldo());
    }


    @Test
    @DisplayName("Verifica extracció con saldo insuficiente.")
    public void testExtraccionConSaldoInsuficiente() {
        cuenta.depositar(100.0);
        assertThrows(SaldoInsuficienteException.class, () -> {
            cuenta.extraer(150.0);
        });
    }
}
