package ar.edu.unlu.poo.practica1.ejercicio02;

public class Playlist {

    // Atributos
    private NodoCancion primero;

    // Constructor
    public Playlist() {
        this.setPrimero(null);
    }

    // Métodos
    public boolean agregarCancion(Cancion cancion) {
        // 1. Creamos el nuevo nodo
        var newNodoCancion = new NodoCancion(cancion, null);

        if (this.estaVacia()) {
            // Usamos el setter privado de la locomotora
            this.setPrimero(newNodoCancion);
            return true;
        } else {
            // Creamos nuestro "inspector" parado en el primero
            NodoCancion actual = this.getPrimero();

            // Caminamos hasta el último vagón
            while (actual.getSiguiente() != null) {
                // ¡COMPLETÁ ACÁ!: ¿Cómo hace el inspector para saltar al siguiente?
                actual = actual.getSiguiente();
            }

            // ¡COMPLETÁ ACÁ!: Ya estamos en el último. ¿Cómo le enganchamos el newNodoCancion?
            actual.setSiguiente(newNodoCancion);

            return true; // Retornamos true porque la operación fue exitosa
        }
    }

    public Cancion reproducirSiguiente() {
        if (!this.estaVacia()) {
            var cancionARetornar = this.getPrimero().getCancion();
            this.setPrimero(this.getPrimero().getSiguiente());
            return cancionARetornar;
        } else {
            throw new PlaylistVaciaException("ERROR. La lista está vacía.");
        }
    }

    public int obtenerDuracionTotal() {
        var total = 0;
        var actual = this.getPrimero();
        while (actual != null) {
            total += actual.getCancion().getSegundos();
            actual = actual.getSiguiente();
        }
        return total;
    }

    public int getCantidadCanciones() {
        var total = 0;
        var actual = this.getPrimero();
        while(actual != null) {
            total++;
            actual = actual.getSiguiente();
        }
        return total;
    }

    public boolean estaVacia() {
        return this.getPrimero() == null;
    }

    // Getter
    private NodoCancion getPrimero() {
        return this.primero;
    }

    // Setter
    private void setPrimero(NodoCancion primero) {
        this.primero = primero;
    }

}
