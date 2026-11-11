package ar.edu.unlu.poo.practica10.ejercicio02;

public class ControladorTareas implements Observer{

    // Atributos
    private final GestorTareas modelo;
    private final VistaTareas vista;

    // Constructor
    public ControladorTareas(GestorTareas modelo, VistaTareas vista) {
        if (modelo == null || vista == null) {
            throw new IllegalArgumentException("ERROR. Ni el modelo ni la vista pueden ser nulos.");
        }

        this.modelo = modelo;
        this.vista = vista;
        this.vista.setControlador(this);
        this.modelo.addObserver(this);
    }

    // Métodos de Acción (Llamados por la Vista cuando el usuario interactúa)
    public void crearTarea(String descripcion) {
        try {
            this.modelo.crearTarea(descripcion);
        } catch (IllegalArgumentException e) {
            this.vista.mostrarError(e.getMessage());
        }
    }

    public void completarTarea(int id) {
        this.modelo.completarTarea(id);
    }

    public void eliminarTarea(int id) {
        this.modelo.eliminarTarea(id);
    }

    // Método de Reacción (`update` de la interfaz `Observer`)
    @Override
    public void update(EventoTarea evento, Object fuente) {
        if (evento == null) return;

        // 1. El controlador reacciona al aviso y le pide las tareas NUEVAS al modelo
        Tarea[] tareas = this.modelo.getTareas();

        // 2. Le ordena a la vista que se vuelva a dibujar con la lista nueva
        this.vista.mostrarInformacion(tareas);
    }
}
