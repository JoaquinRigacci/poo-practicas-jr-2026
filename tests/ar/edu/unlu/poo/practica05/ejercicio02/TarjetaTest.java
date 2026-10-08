package ar.edu.unlu.poo.practica05.ejercicio02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TarjetaTest {

    private Tarjeta tarjeta1;
    private Tarjeta tarjeta2;

    @BeforeEach
    public void setUp() {
        this.tarjeta1 = new Tarjeta("4512-8899-0012-3456");
        this.tarjeta2 = new Tarjeta("4512-8899-0012-3456");
    }

    @Test
    @DisplayName("Verificar que una tarjeta válida guarde y devuelva correctamente su número.")
    public void testCreacionYGetter() {
        assertEquals("4512-8899-0012-3456", this.tarjeta1.getNumero());
    }

    @Test
    @DisplayName("Verificar que dos instancias de tarjeta con el mismo número sean consideradas iguales.")
    public void testIgualdadPorNumero() {
        assertEquals(this.tarjeta1, this.tarjeta2);
    }

    @Test
    @DisplayName("Verificar que instanciar una tarjeta con número null o vacío lance IllegalArgumentException.")
    public void testNumeroInvalidoLanzaExcepcion() {
        // Caso número nulo
        assertThrows(IllegalArgumentException.class, () -> {
            new Tarjeta(null);
        });

        // Caso número vacío
        assertThrows(IllegalArgumentException.class, () -> {
            new Tarjeta("");
        });

        // Caso número con solo espacios
        assertThrows(IllegalArgumentException.class, () -> {
            new Tarjeta(" ");
        });
    }
}
