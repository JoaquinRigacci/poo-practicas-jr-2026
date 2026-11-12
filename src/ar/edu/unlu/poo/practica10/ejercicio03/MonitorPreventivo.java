package ar.edu.unlu.poo.practica10.ejercicio03;

public class MonitorPreventivo implements ObserverBiblioteca {

    // Atributos
    private int cantidadAlertas;

    // Constructor
    public MonitorPreventivo() {
        this.cantidadAlertas = 0;
    }

    // Getter
    public int getCantidadAlertas() {
        return this.cantidadAlertas;
    }

    // Método Notificación del Observer
    @Override
    public void update(EventosBiblioteca evento, TransaccionPrestamo transaccion) {
        if (evento == null || transaccion == null) {
            return;
        }

        // Si se registra un préstamo de un EquipamientoTecnologico, se emite la alerta
        if (evento == EventosBiblioteca.PRESTAMO_REGISTRADO) {
            if (transaccion.getRecurso() instanceof EquipamientoTecnologico) {
                this.cantidadAlertas++;
            }
        }
    }
}