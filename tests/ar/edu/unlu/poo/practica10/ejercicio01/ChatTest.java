package ar.edu.unlu.poo.practica10.ejercicio01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChatTest {

    private Chat modelo;
    private SpyVistaChat espiaVista1;
    private SpyVistaChat espiaVista2;
    private ControladorChat controlador1;
    private ControladorChat controlador2;

    @BeforeEach
    public void setUp() {
        // Un único modelo compartido por dos clientes
        this.modelo = new Chat();

        // Cliente 1
        this.espiaVista1 = new SpyVistaChat();
        this.controlador1 = new ControladorChat(this.modelo, this.espiaVista1);

        // Cliente 2
        this.espiaVista2 = new SpyVistaChat();
        this.controlador2 = new ControladorChat(this.modelo, this.espiaVista2);
    }

    @Test
    @DisplayName("Probar la conexión de un usuario y la notificación reactiva a las vistas")
    public void testConectarUsuarioNotificaObservadores() {
        this.controlador1.conectarUsuario("Tomás");

        // Verificamos que la Vista 1 confirmó la conexión
        assertTrue(this.espiaVista1.fueLlamadoMostrarMensaje());
        assertTrue(this.espiaVista1.getUltimoMensajeMostrado().contains("Tomás"));

        // Verificamos la notificación reactiva (Observer):
        // Al conectarse Tomás, la Vista 2 fue notificada automáticamente y actualizó sus usuarios e historial
        assertTrue(this.espiaVista2.fueLlamadoMostrarUsuarios());
        assertEquals(1, this.espiaVista2.getCantidadUsuariosActivos());
        assertTrue(this.espiaVista2.fueLlamadoMostrarHistorial());
    }

    @Test
    @DisplayName("Probar que cuando un usuario envía un mensaje, las demás vistas reciben la actualización reactiva")
    public void testEnvioMensajeNotificaEnTiempoReal() {
        // Conectamos ambos usuarios
        this.controlador1.conectarUsuario("Ana");
        this.controlador2.conectarUsuario("Juan");

        // Ana envía un mensaje a la sala
        this.controlador1.enviarMensaje("¡Hola a todos en la sala!");

        // Verificamos que la Vista de Juan recibió la actualización del historial inmediatamente
        assertTrue(this.espiaVista2.fueLlamadoMostrarHistorial());

        // Historial esperado: 2 mensajes de conexión de sistema + 1 mensaje de Ana = 3 mensajes
        assertEquals(3, this.espiaVista2.getCantidadMensajesEnHistorial());
    }

    @Test
    @DisplayName("Probar que no se pueden enviar mensajes con texto vacío (Validación de Invariantes)")
    public void testEnviarMensajeVacioMuestraError() {
        this.controlador1.conectarUsuario("Pedro");

        // Intenta enviar un mensaje vacío
        this.controlador1.enviarMensaje(" ");

        // La vista debe haber recibido un error formateado
        assertTrue(this.espiaVista1.fueLlamadoMostrarError());
        assertNotNull(this.espiaVista1.getUltimoErrorMostrado());
    }

    @Test
    @DisplayName("Probar defensa contra Aliasing: Modificar el array retornado no altera el modelo")
    public void testDefensaContraAliasing() {
        this.controlador1.conectarUsuario("Sofía");

        Usuario[] usuariosDefensa = this.modelo.getUsuariosActivos();

        // Intentamos 'corromper' el arreglo recibido afuera
        usuariosDefensa[0] = null;

        // El modelo interno debe conservar a Sofía intacta
        assertEquals(1, this.modelo.getUsuariosActivos().length);
        assertNotNull(this.modelo.getUsuariosActivos()[0]);
    }
}
