package ar.edu.unlu.poo.practica10.ejercicio03;

public class Libro extends Recurso{

    // Constructor
    public Libro(String titulo) {
        super(titulo);
    }

    // Métodos
    @Override
    public int getPlazoPrestamoDias() {
        return 14;
    }

    @Override
    public double calcularPenalizacion(int diasMora) {
        if (diasMora <= 0) {
            return 0.0;
        }
        return diasMora * 100.0;
    }
}
