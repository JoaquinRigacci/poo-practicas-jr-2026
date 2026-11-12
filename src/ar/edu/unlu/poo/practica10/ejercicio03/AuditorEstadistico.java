package ar.edu.unlu.poo.practica10.ejercicio03;

public class AuditorEstadistico implements ObserverBiblioteca{

    // Atributos
    private int cantidadPrestamosRegistrados;
    private int cantidadDevolucionesRegistradas;

    // Constructor
    public AuditorEstadistico() {
        this.cantidadPrestamosRegistrados = 0;
        this.cantidadDevolucionesRegistradas = 0;
    }

    // Getter
    public int getCantidadPrestamosRegistrados() {
        return this.cantidadPrestamosRegistrados;
    }

    public int getCantidadDevolucionesRegistradas() {
        return this.cantidadDevolucionesRegistradas;
    }

    // Método
    @Override
    public void update(EventosBiblioteca evento, TransaccionPrestamo transaccion) {
        if (evento == null) {
            return;
        }

        switch (evento) {
            case PRESTAMO_REGISTRADO -> this.cantidadPrestamosRegistrados++;

            case DEVOLUCION_REGISTRADA -> this.cantidadDevolucionesRegistradas++;
        }
    }
}
