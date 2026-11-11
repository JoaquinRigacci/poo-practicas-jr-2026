package ar.edu.unlu.poo.practica10.ejercicio02;

public class VistaResumen implements VistaTareas {

    // Atributo
    private ControladorTareas controlador;

    // Constructor vacío (no necesita Scanner)
    public VistaResumen() {
    }

    // Métodos de la Interfaz
    @Override
    public void setControlador(ControladorTareas controlador) {
        this.controlador = controlador;
    }

    @Override
    public void mostrarError(String error) {
        System.out.println("❌ [ESTADÍSTICAS] ERROR: " + error);
    }

    @Override
    public void mostrarInformacion(Tarea[] tareas) {
        int total = tareas.length;
        int completadas = 0;

        // Calculamos la métrica de completadas
        for (Tarea t : tareas) {
            if (t.isCompletada()) {
                completadas++;
            }
        }

        int pendientes = total - completadas;

        // Imprimimos el resumen consolidado
        System.out.println("\n====================================");
        System.out.println("📊 RESUMEN ESTADÍSTICO (VISTA RESUMEN)");
        System.out.println(" • Total de Tareas: " + total);
        System.out.println(" • Completadas: " + completadas);
        System.out.println(" • Pendientes: " + pendientes);
        System.out.println("====================================\n");
    }

    @Override
    public void iniciar() {
        System.out.println("Vista Resumen estadística inicializada y lista para recibir eventos.");
    }
}
