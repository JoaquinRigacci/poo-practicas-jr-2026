package ar.edu.unlu.poo.practica10.ejercicio03;

public class EquipamientoTecnologico extends Recurso{

    // Constructor
    public EquipamientoTecnologico(String titulo) {
        super(titulo);
    }

    // Métodos
    @Override
    public int getPlazoPrestamoDias() {
        return 3;
    }

    @Override
    public double calcularPenalizacion(int diasMora) {
        if (diasMora <= 0) {
            return 0.0;
        }
        return (diasMora * 500.0) + 1000.0;
    }
}
