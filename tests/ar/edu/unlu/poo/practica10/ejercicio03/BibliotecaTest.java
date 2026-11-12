package ar.edu.unlu.poo.practica10.ejercicio03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BibliotecaTest {

    private Biblioteca biblioteca;
    private AuditorEstadistico auditor;
    private MonitorPreventivo monitor;
    private Socio socio;
    private Libro libro;
    private EquipamientoTecnologico laptop;

    @BeforeEach
    public void setUp() {
        // Inicializamos el modelo y los observadores
        this.biblioteca = new Biblioteca();
        this.auditor = new AuditorEstadistico();
        this.monitor = new MonitorPreventivo();

        // Suscribimos los observadores al sujeto observable
        this.biblioteca.addObserver(this.auditor);
        this.biblioteca.addObserver(this.monitor);

        // Preparamos datos de prueba
        this.socio = new Socio(1, "Joaquín");
        this.libro = new Libro("Cien Años de Soledad");
        this.laptop = new EquipamientoTecnologico("Laptop ThinkPad");
    }

    @Test
    @DisplayName("Verificar que al registrar préstamos se notifique correctamente al auditor y al monitor preventivo")
    public void testRegistrarPrestamoNotificaObservadores() {
        // 1. Prestamos un libro convencional
        this.biblioteca.registrarPrestamo(this.libro, this.socio);

        // Verificamos que el auditor sumó 1 préstamo y el monitor 0 alertas (no es equipo tecnológico)
        assertEquals(1, this.auditor.getCantidadPrestamosRegistrados());
        assertEquals(0, this.monitor.getCantidadAlertas());

        // 2. Prestamos un equipo tecnológico (recurso crítico)
        this.biblioteca.registrarPrestamo(this.laptop, this.socio);

        // Verificamos que el auditor ahora tiene 2 préstamos y el monitor disparó 1 alerta
        assertEquals(2, this.auditor.getCantidadPrestamosRegistrados());
        assertEquals(1, this.monitor.getCantidadAlertas());
    }

    @Test
    @DisplayName("Verificar la devolución de un préstamo, el cálculo de multa y la actualización del auditor")
    public void testRegistrarDevolucionYNotificarAuditor() {
        // Registramos un préstamo (obtiene ID 1)
        TransaccionPrestamo transaccion = this.biblioteca.registrarPrestamo(this.libro, this.socio);

        // Registramos devolución con 3 días de mora
        double multaCalculada = this.biblioteca.registrarDevolucion(transaccion.getId(), 3);

        // Verificaciones
        assertTrue(multaCalculada > 0, "La penalización por días de mora debe ser mayor a 0");
        assertTrue(transaccion.isDevuelto(), "La transacción debe quedar marcada como devuelta");
        assertEquals(1, this.auditor.getCantidadDevolucionesRegistradas());
    }

    @Test
    @DisplayName("Verificar que no se pueda prestar un recurso que ya se encuentra prestado")
    public void testPrestarRecursoYaPrestadoLanzaExcepcion() {
        // Primer préstamo exitoso
        this.biblioteca.registrarPrestamo(this.libro, this.socio);

        // Intento de prestar el mismo libro a otro socio (o al mismo) debe fallar
        Socio socio2 = new Socio(2, "María");
        assertThrows(IllegalArgumentException.class, () -> {
            this.biblioteca.registrarPrestamo(this.libro, socio2);
        });
    }
}
