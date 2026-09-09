package ar.edu.unlu.poo.practica2.ejercicio01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableroControl {

    // Atributos
    private List<Reactor> reactores;

    // Constructor
    public TableroControl() {
        this.reactores = new ArrayList<>(); // Nace con la lista vacía lista para usar
    }

    // Método de comportamiento para agregar reactores
    public void agregarReactor(Reactor reactor) {
        if (reactor != null) {
            this.reactores.add(reactor);
        } else {
            throw new IllegalArgumentException("ERROR. El reactor no puede ser nulo.");
        }
    }

    // Getter protegido (evita fuga de representación)
    public List<Reactor> getReactores() {
        // Retornamos una lista no modificable para que nadie altere la lista interna
        return Collections.unmodifiableList(this.reactores);
    }

}
