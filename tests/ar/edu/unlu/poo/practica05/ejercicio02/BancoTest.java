package ar.edu.unlu.poo.practica05.ejercicio02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BancoTest {

    private Banco banco;

    @BeforeEach
    public void setUp() {
        this.banco = new Banco();
    }

    @Test
    @DisplayName("Verificar que registrar un cliente válido aumente la cantidad de clientes del banco.")
    public void testRegistrarClienteExitoso() {
        this.banco.registrarCliente("47.259.923", "Joaquin Bautista Rigacci");

        assertEquals(1, this.banco.getClientes().size());

        Cliente registrado = this.banco.buscarCliente("47.259.923");
        assertNotNull(registrado);
        assertEquals("Joaquin Bautista Rigacci", registrado.getNombre());
    }

    @Test
    @DisplayName("Verificar que intentar registrar dos clientes con el mismo DNI lance ClienteDuplicadoException.")
    public void testRegistrarClienteDuplicadoLanzaExcepcion() {
        this.banco.registrarCliente("47.259.923", "Joaquin Bautista Rigacci");

        assertThrows(ClienteDuplicadoException.class, () -> {
            this.banco.registrarCliente("47.259.923", "Otro Nombre Mismo DNI");
        });
    }

    @Test
    @DisplayName("Verificar que asociar una tarjeta a un cliente registrado funcione correctamente.")
    public void testAsociarTarjetaExitoso() {
        this.banco.registrarCliente("47.259.923", "Joaquin Bautista Rigacci");
        this.banco.asociarTarjeta("47.259.923", "4512-8899-0012-3456");

        Cliente cliente = this.banco.buscarCliente("47.259.923");
        assertEquals(1, cliente.getTarjetas().size());
        assertEquals("4512-8899-0012-3456", cliente.getTarjetas().get(0).getNumero());
    }

    @Test
    @DisplayName("Verificar que intentar asociar una tarjeta a un DNI no registrado lance IllegalArgumentException.")
    public void testAsociarTarjetaClienteInexistenteLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.banco.asociarTarjeta("99.999.999", "4512-8899-0012-3456");
        });
    }

    @Test
    @DisplayName("Verificar que no se pueda asociar la misma tarjeta a dos clientes distintos (Unicidad Global).")
    public void testAsociarTarjetaDuplicadaLanzaExcepcion() {
        // Registramos dos clientes distintos
        this.banco.registrarCliente("47.259.923", "Joaquin Bautista Rigacci");
        this.banco.registrarCliente("18.122.022", "Lionel Andrés Messi");

        // Asociamos la tarjeta al primer cliente
        this.banco.asociarTarjeta("47.259.923", "4512-8899-0012-3456");

        // Intentamos asociar la misma tarjeta al segundo cliente
        assertThrows(TarjetaDuplicadaException.class, () -> {
            this.banco.asociarTarjeta("18.122.022", "4512-8899-0012-3456");
        });
    }

    @Test
    @DisplayName("Verificar que buscar un cliente con DNI nulo lance IllegalArgumentException.")
    public void testBuscarClienteDniNuloLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.banco.buscarCliente(null);
        });
    }
}
