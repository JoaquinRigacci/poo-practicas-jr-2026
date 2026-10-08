package ar.edu.unlu.poo.practica05.ejercicio02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    private Cliente cliente1;
    private Cliente cliente2;

    @BeforeEach
    public void setUp() {
        this.cliente1 = new Cliente("47.259.923", "Joaquin Bautista Rigacci");
        this.cliente2 = new Cliente("47.259.923", "Joaquin Bautista Rigacci");
    }

    @Test
    @DisplayName("Verificar que un cliente válido guarde y devuelva correctamente su DNI y nombre.")
    public void testCreacionYGetters() {
        assertEquals("47.259.923", this.cliente1.getDni());
        assertEquals("Joaquin Bautista Rigacci", this.cliente1.getNombre());
    }


    @Test
    @DisplayName("Verificar que dos instancias creadas con el mismo DNI sean consideradas iguales.")
    public void testIgualdadPordni() {
        assertEquals(this.cliente2, this.cliente1);
    }

    @Test
    @DisplayName("Verificar que tire error al instanciar un cliente con DNI `null` o vacío.")
    public void testDniInvalidoLanzaException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Cliente cliente3 = new Cliente(null, "Leonel Messi");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Cliente cliente3 = new Cliente("", "Leonel Messi");
        });
    }

    @Test
    @DisplayName("Verificar que tire error al instanciar un cliente con nombre `null` o vacío.")
    public void testNombreInvalidoLanzaException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Cliente cliente3 = new Cliente("18.122.022", null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Cliente cliente3 = new Cliente("18.122.022", "");
        });
    }
}
