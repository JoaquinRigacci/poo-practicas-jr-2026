package ar.edu.unlu.poo.practica08.ejercicio01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EnrutadorEnviosTest {

    private EnrutadorEnvios enrutador;

    @BeforeEach
    public void setUp() {
        this.enrutador = new EnrutadorEnvios();
    }

    @Test
    @DisplayName("Debe autorizar códigos postales argentinos tradicionales (4 dígitos)")
    public void testCpaTradicionalValido() {
        CodigoPostal cpLujan = new CodigoPostalArgentino("6700");
        assertTrue(this.enrutador.enrutar(cpLujan));
    }

    @Test
    @DisplayName("Debe autorizar CPA argentino moderno (8 caracteres alfanuméricos)")
    public void testCpaModernoValido() {
        CodigoPostal cpModerno = new CodigoPostalArgentino("B1636FDA");
        assertTrue(this.enrutador.enrutar(cpModerno));
    }

    @Test
    @DisplayName("Debe autorizar ZIP codes de Estados Unidos simples y con formato extendido")
    public void testZipCodeUsaValido() {
        ValidadorCodigoPostal validadorUsa = new ValidadorZipCodeUsa();
        CodigoPostal cpSimple = new CodigoPostal("90210", validadorUsa);
        CodigoPostal cpExtendido = new CodigoPostal("12345-6789", validadorUsa);

        assertTrue(this.enrutador.enrutar(cpSimple));
        assertTrue(this.enrutador.enrutar(cpExtendido));
    }

    @Test
    @DisplayName("Debe lanzar CodigoPostalInvalidoException cuando el código postal argentino no respeta la sintaxis")
    public void testCpaInvalidoLanzaExcepcion() {
        CodigoPostal cpErroneo = new CodigoPostalArgentino("670A"); // Letra en formato de 4 caracteres
        assertThrows(CodigoPostalInvalidoException.class, () -> {
            this.enrutador.enrutar(cpErroneo);
        });
    }

    @Test
    @DisplayName("Debe permitir cambiar en caliente la estrategia de validación mediante setValidador")
    public void testIntercambioDinamicoEstrategia() {
        CodigoPostal cp = new CodigoPostal("90210", new ValidadorCodigoPostalArgentino());
        assertFalse(cp.esValido()); // Falla porque no es argentino

        cp.setValidador(new ValidadorZipCodeUsa());
        assertTrue(cp.esValido()); // Ahora pasa porque se ajustó la estrategia a USA
    }
}
