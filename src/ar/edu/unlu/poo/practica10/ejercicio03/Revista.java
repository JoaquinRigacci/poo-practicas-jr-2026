package ar.edu.unlu.poo.practica10.ejercicio03;

public class Revista extends Recurso{

    // Constructor
    public Revista(String titulo) {
        super(titulo);
    }

    // Métodos
    @Override
    public int getPlazoPrestamoDias() {
        return 7;
    }

    @Override
    public double calcularPenalizacion(int diasMora) {
        if (diasMora <= 0) {
            return 0.0;
        }
        return diasMora * 200.0;
    }
}
