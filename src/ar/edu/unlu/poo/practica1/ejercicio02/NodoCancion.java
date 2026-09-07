package ar.edu.unlu.poo.practica1.ejercicio02;

public class NodoCancion {

    // Atributos
    private Cancion cancion;
    private NodoCancion siguiente;

    // Constructor
    public NodoCancion(Cancion cancion, NodoCancion siguiente) {
        this.setCancion(cancion);
        this.setSiguiente(siguiente);
    }

    // Getter
    public Cancion getCancion() {
        return this.cancion;
    }

    public NodoCancion getSiguiente() {
        return this.siguiente;
    }

    // Setter
    public void setCancion(Cancion cancion) {
        this.cancion = cancion;
    }

    public void setSiguiente(NodoCancion siguiente) {
        this.siguiente = siguiente;
    }

}
