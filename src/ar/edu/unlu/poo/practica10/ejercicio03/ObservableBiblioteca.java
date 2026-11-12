package ar.edu.unlu.poo.practica10.ejercicio03;


public interface ObservableBiblioteca {
    void addObserver(ObserverBiblioteca observer);

    void removeObserver(ObserverBiblioteca observer);

    void notifyObservers(EventosBiblioteca evento, TransaccionPrestamo transaccion);
}