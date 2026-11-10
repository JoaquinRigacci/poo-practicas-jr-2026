package ar.edu.unlu.poo.practica10.ejercicio01;

public interface IObservable {
    void agregarObservador(IObservador observador);
    void removerObservador(IObservador observador);
    void notificarObservadores(EventoChat evento);
}

/*
    ¿Por qué es fundamental que `IObservable` reciba `IObservador` (interfaz)
    en lugar de recibir una clase concreta como `VistaConsola` o `ControladorChat`?

    Respuesta: Garantiza el Principio de Inversión de Dependencias (DIP).
    El modelo solo conoce el contrato `IObservador`, permitiendo conectar N consolas,
    interfaces gráficas o clases de prueba sin modificar el código del sujeto observable.
 */
