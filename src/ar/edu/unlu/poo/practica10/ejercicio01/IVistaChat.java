package ar.edu.unlu.poo.practica10.ejercicio01;

public interface IVistaChat {
    /**
     * Inicia el bucle de interacción de la vista (menú de consola, ventana gráfica, etc.).
     */
    void iniciar();

    /**
     * Muestra un mensaje simple en la pantalla (notificación o aviso).
     */
    void mostrarMensaje(String texto);

    /**
     * Muestra la lista de usuarios activos actualmente en la sala.
     */
    void mostrarUsuarios(Usuario[] usuarios);

    /**
     * Muestra el historial completo de mensajes.
     */
    void mostrarHistorial(Mensaje[] mensajes);

    /**
     * Muestra un mensaje de error formateado (por ejemplo, excepciones del dominio).
     */
    void mostrarError(String error);

    /**
     * Asigna el controlador que gestionará las acciones de esta vista.
     */
    void setControlador(ControladorChat controlador);
}
