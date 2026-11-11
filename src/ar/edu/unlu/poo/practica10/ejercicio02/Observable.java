package ar.edu.unlu.poo.practica10.ejercicio02;

public interface Observable {
    void addObserver(Observer observador);
    void removeObserver(Observer observador);
    void notifyObservers(EventoTarea evento);
}
