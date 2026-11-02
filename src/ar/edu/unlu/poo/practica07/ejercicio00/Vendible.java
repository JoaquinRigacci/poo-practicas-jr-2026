package ar.edu.unlu.poo.practica07.ejercicio00;

public interface Vendible {

    // Método para obtener el precio base
    double calcularPrecio();

    // Método para obtener el precio pagando con tarjeta
    double calcularPrecio(Tarjeta tarjeta);
}
