package ar.edu.unlu.poo.practica05.ejercicio01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BilleteraTest {

    private Billetera billetera;

    @BeforeEach
    public void setUp() {
        billetera = new Billetera();
    }

    @Test
    @DisplayName("Verificar depositación exitosa.")
    public void testDepositacionExitosa() {
        Cuenta c1 = new Cuenta("USD");
        billetera.agregarCuenta(c1);

        billetera.depositar("USD", 100.0);
        assertEquals(100.0, billetera.obtenerSaldo("USD"));
    }

    @Test
    @DisplayName("Verificar que no haya cuentas duplicadas.")
    public void testNoCuentasDuplicadas() {
        Cuenta c1 = new Cuenta("USD");
        Cuenta c2 = new Cuenta("USD");
        billetera.agregarCuenta(c1);

        assertThrows(CuentaDuplicadaException.class, () -> {
            billetera.agregarCuenta(c2);
        });
    }

    @Test
    @DisplayName("Verificar que la extracción sea exitosa.")
    public void testExtraccionExitosa() {
        Cuenta c1 = new Cuenta("USD");
        billetera.agregarCuenta(c1);

        billetera.depositar("USD", 100.0);
        billetera.extraer("USD", 40.0);

        assertEquals(60.0, billetera.obtenerSaldo("USD"));
    }

    @Test
    @DisplayName("Verificar que no se extraiga mas del dinero que esta cargado en la billetera.")
    public void testExtraccionSaldoInsuficiente() {
        Cuenta c1 = new Cuenta("USD");
        billetera.agregarCuenta(c1);

        billetera.depositar("USD", 50.0);
        assertThrows(SaldoInsuficienteException.class, () -> {
            billetera.extraer("USD", 100.0);
        });
    }

    @Test
    @DisplayName("Verificar que si consultamos el saldo de una divisa que no agregamos, nos devuelva 0.0.")
    public void testConsultarSaldoInexistente() {
        assertEquals(0.0, billetera.obtenerSaldo("ARG"));
    }

    @Test
    @DisplayName("Verificar si intentamos depositar o extraer en una divisa no registrada, la billetera lance 'IllegalArgumentException'.")
    public void testDepositarDivisaInexistente() {
        assertThrows(IllegalArgumentException.class, () -> {
            billetera.depositar("ARG", 67.0);
        });
    }
}
