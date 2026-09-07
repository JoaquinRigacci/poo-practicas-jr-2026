package ar.edu.unlu.poo.practica1.ejercicio02;

public class DuracionInvalidaException extends RuntimeException{
    // Constructor que recibe el mensaje de error
    public DuracionInvalidaException(String mensaje) {
        super(mensaje); // Se lo pasa a la clase padre (RuntimeException)
    }
}
