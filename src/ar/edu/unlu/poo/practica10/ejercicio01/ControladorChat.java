package ar.edu.unlu.poo.practica10.ejercicio01;

public class ControladorChat implements IObservador {

    private final Chat modelo;
    private final IVistaChat vista;
    private Usuario usuarioActual; // El usuario asociado a esta vista concreta

    public ControladorChat(Chat modelo, IVistaChat vista) {
        if (modelo == null || vista == null) {
            throw new IllegalArgumentException("ERROR. Ni el modelo ni la vista pueden ser nulos.");
        }
        this.modelo = modelo;
        this.vista = vista;
        this.vista.setControlador(this);

        // El controlador se suscribe como observador del modelo
        this.modelo.agregarObservador(this);
    }

    // --- ACCIONES SOLICITADAS POR LA VISTA ---

    public void conectarUsuario(String nombre) {
        try {
            this.usuarioActual = this.modelo.conectarUsuario(nombre);
            this.vista.mostrarMensaje("Conectado exitosamente como: " + this.usuarioActual.getNombre());
        } catch (IllegalArgumentException e) {
            this.vista.mostrarError(e.getMessage());
        }
    }

    public void enviarMensaje(String texto) {
        if (this.usuarioActual == null) {
            this.vista.mostrarError("ERROR. Debe conectarse a la sala antes de enviar mensajes.");
            return;
        }
        try {
            this.modelo.enviarMensaje(texto, this.usuarioActual);
        } catch (Exception e) {
            this.vista.mostrarError(e.getMessage());
        }
    }

    public void desconectar() {
        if (this.usuarioActual != null) {
            this.modelo.desconectarUsuario(this.usuarioActual.getId());
            this.modelo.removerObservador(this); // Nos desuscribimos al salir
            this.usuarioActual = null;
        }
    }

    public void solicitarUsuarios() {
        this.vista.mostrarUsuarios(this.modelo.getUsuariosActivos());
    }

    public void solicitarHistorial() {
        this.vista.mostrarHistorial(this.modelo.getHistorialMensajes());
    }

    // --- REACCIÓN ANTE NOTIFICACIONES DEL MODELO (OBSERVER) ---

    @Override
    public void actualizar(EventoChat evento, Object fuente) {
        if (evento == null) return;

        switch (evento) {
            case NUEVO_MENSAJE:
                // Al llegar un nuevo mensaje, actualizamos el historial en la vista
                this.vista.mostrarHistorial(this.modelo.getHistorialMensajes());
                break;
            case USUARIO_CONECTADO:
            case USUARIO_DESCONECTADO:
                // Avisamos a la vista y refrescamos la lista de activos
                this.vista.mostrarHistorial(this.modelo.getHistorialMensajes());
                this.vista.mostrarUsuarios(this.modelo.getUsuariosActivos());
                break;
        }
    }
}
