package ar.edu.unlu.poo.practica05.ejercicio01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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


    // Tests de Transferencia
    @Test
    @DisplayName("Verificar que la transferencia entre dos billeteras sea exitosa y emita el comprobante inmutable.")
    public void testTransferenciaExitosa() throws SaldoInsuficienteException {
        Billetera billeteraDestino = new Billetera();

        // Cuentas en USD para ambas billeteras
        billetera.agregarCuenta(new Cuenta("USD"));
        billeteraDestino.agregarCuenta(new Cuenta("USD"));

        // Depósito inicial en la billetera origen
        billetera.depositar("USD", 100.0);

        // Realizamos la transferencia
        Transferencia t = billetera.transferir(billeteraDestino, "USD", 40.0, "Pago de alquiler");

        // Verificaciones
        assertEquals(60.0, billetera.obtenerSaldo("USD"), "El saldo origen debe ser 60.0");
        assertEquals(40.0, billeteraDestino.obtenerSaldo("USD"), "El saldo destino debe ser 40.0");

        // Verificación del comprobante inmutable
        assertEquals("USD", t.getDivisa());
        assertEquals(40.0, t.getMonto());
        assertEquals("Pago de alquiler", t.getDetalle());
        assertNotNull(t.getFechaHora(), "La fecha y hora deben estar registradas.");
    }

    @Test
    @DisplayName("Verificar atomicidad: si la billetera origen no tiene saldo, no se altera ningún saldo.")
    public void testTransferenciaSaldoInsuficienteNoAlteraSaldos() {
        Billetera billeteraDestino = new Billetera();
        billetera.agregarCuenta(new Cuenta("USD"));
        billeteraDestino.agregarCuenta(new Cuenta("USD"));
        billetera.depositar("USD", 30.0); // Solo tenemos $30

        // Intentamos transferir $100
        assertThrows(SaldoInsuficienteException.class, () -> {
            billetera.transferir(billeteraDestino, "USD", 100.0, "Prueba fallida");
        });

        // Verificamos que los saldos se mantengan intactos
        assertEquals(30.0, billetera.obtenerSaldo("USD"));
        assertEquals(0.0, billeteraDestino.obtenerSaldo("USD"));
    }

    @Test
    @DisplayName("Verificar que no se pueda transferir a una billetera destino que no tenga cuenta en esa divisa.")
    public void testTransferenciaDestinoSinCuentaLanzaExcepcion() {
        Billetera billeteraDestino = new Billetera(); // Billetera vacía sin cuentas
        billetera.agregarCuenta(new Cuenta("USD"));
        billetera.depositar("USD", 100.0);

        assertThrows(IllegalArgumentException.class, () -> {
            billetera.transferir(billeteraDestino, "USD", 50.0);
        });

        // El dinero debe seguir en la billetera origen
        assertEquals(100.0, billetera.obtenerSaldo("USD"));
    }

    @Test
    @DisplayName("Verificar que no se pueda transferir a sí mismo ni a un destino nulo.")
    public void testTransferenciaDestinoInvalido() {
        billetera.agregarCuenta(new Cuenta("USD"));
        billetera.depositar("USD", 100.0);

        // Destino nulo
        assertThrows(IllegalArgumentException.class, () -> {
            billetera.transferir(null, "USD", 50.0);
        });

        // Transferirse a sí mismo
        assertThrows(IllegalArgumentException.class, () -> {
            billetera.transferir(billetera, "USD", 50.0);
        });
    }
}
