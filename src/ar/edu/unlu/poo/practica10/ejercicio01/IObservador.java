package ar.edu.unlu.poo.practica10.ejercicio01;

public interface IObservador {
    /**
     * Notifica al observador que ocurrió un evento en el sujeto observado.
     * @param evento El tipo de suceso ocurrido.
     * @param fuente El objeto que generó el evento (el modelo de Chat).
     */
    void actualizar(EventoChat evento, Object fuente);
}
