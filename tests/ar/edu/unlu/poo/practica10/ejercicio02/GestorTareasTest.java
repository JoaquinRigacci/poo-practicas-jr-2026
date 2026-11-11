package ar.edu.unlu.poo.practica10.ejercicio02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GestorTareasTest {

    private GestorTareas modelo;
    private VistaTareasSpy vistaSpy;
    private ControladorTareas controlador;

    @BeforeEach
    public void setUp() {
        // 1. Instanciamos el modelo real
        this.modelo = new GestorTareas();

        // 2. Instanciamos el espía artesanal
        this.vistaSpy = new VistaTareasSpy();

        // 3. Conectamos todo a través del controlador
        this.controlador = new ControladorTareas(this.modelo, this.vistaSpy);
    }

    @Test
    @DisplayName("Alta exitosa: debe incrementar el modelo y notificar a la vista")
    public void testCrearTareaExitosaNotificaAVista() {
        // When: El usuario solicita crear una tarea a través del controlador
        this.controlador.crearTarea("Estudiar para el parcial de POO");

        // Then 1: Verificación de Estado (el modelo tiene 1 tarea)
        assertEquals(1, this.modelo.getTareas().length);
        assertEquals("Estudiar para el parcial de POO", this.modelo.getTareas()[0].getDescripcion());

        // Then 2: Verificación de Interacción (el espía recibió la notificación)
        assertTrue(this.vistaSpy.fueLlamadoMostrarInformacion(), "La vista debió ser notificada.");
        assertEquals(1, this.vistaSpy.getCantidadLlamadasInformacion());
        assertEquals(1, this.vistaSpy.getUltimasTareasRecibidas().length);
    }

    @Test
    @DisplayName("Completar tarea: debe cambiar estado a completada y notificar al espía")
    public void testCompletarTareaExistente() {
        // Given: Una tarea previamente creada
        this.controlador.crearTarea("Repasar JUnit 5");
        int idTarea = this.modelo.getTareas()[0].getId();
        this.vistaSpy.reiniciar(); // Limpiamos la telemetría previa del espía

        // When: Completamos la tarea por ID
        this.controlador.completarTarea(idTarea);

        // Then: Estado completado y la vista se refresca
        assertTrue(this.modelo.getTareas()[0].isCompletada());
        assertTrue(this.vistaSpy.fueLlamadoMostrarInformacion());
        assertEquals(1, this.vistaSpy.getCantidadLlamadasInformacion());
    }

    @Test
    @DisplayName("Eliminar tarea: debe removerla de la lista y notificar")
    public void testEliminarTareaExistente() {
        // Given: Una tarea en el sistema
        this.controlador.crearTarea("Tarea temporal");
        int idTarea = this.modelo.getTareas()[0].getId();
        this.vistaSpy.reiniciar();

        // When: Eliminamos la tarea
        this.controlador.eliminarTarea(idTarea);

        // Then: La lista queda en 0 y la vista fue informada
        assertEquals(0, this.modelo.getTareas().length);
        assertTrue(this.vistaSpy.fueLlamadoMostrarInformacion());
    }

    @Test
    @DisplayName("Cero Notificaciones Espurias: Operar sobre ID inexistente NO debe notificar ni refrescar")
    public void testOperarSobreIdInexistenteNoNotifica() {
        // Given: El sistema arranca sin tareas
        this.vistaSpy.reiniciar();

        // When: Intentamos completar un ID que no existe (ej: 999)
        this.controlador.completarTarea(999);

        // Then: El modelo NO emite eventos y la vista NUNCA es llamada
        assertFalse(this.vistaSpy.fueLlamadoMostrarInformacion(), "NO se debe notificar si el ID no existe.");
        assertEquals(0, this.vistaSpy.getCantidadLlamadasInformacion());
    }

    @Test
    @DisplayName("Rechazo de datos inválidos: Descripción vacía debe capturar error sin modificar modelo")
    public void testCrearTareaConDescripcionVaciaMuestraError() {
        // When: Intentamos crear una tarea vacía
        this.controlador.crearTarea(" ");

        // Then: El modelo no agrega nada
        assertEquals(0, this.modelo.getTareas().length);

        // Then: El controlador atrapó la excepción y la mandó a mostrarError en la vista
        assertTrue(this.vistaSpy.fueLlamadoMostrarError());
        assertNotNull(this.vistaSpy.getUltimoErrorRecibido());
    }
}
