package ar.edu.unlu.poo.practica07.ejercicio01;

import java.util.ArrayList;
import java.util.List;

public class Lienzo {

    // Atributos
    private List<Dibujable> elementos;

    // Constructor
    public Lienzo() {
        this.elementos = new ArrayList<>();
    }

    // Métodos
    public void agregarElemento(Dibujable elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("ERROR. El elemento no puede ser nulo.");
        }
        this.elementos.add(elemento);
    }

    public void renderizarTodo() {
        for (Dibujable e : elementos) {
            e.dibujar();
        }
    }
}
