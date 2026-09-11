package ar.edu.unlu.poo.practica2.ejercicio03;

public class Estudiante {

    // Atributos
    private int legajo;
    private String nombre;

    // Constructor
    public Estudiante(int legajo, String nombre) {
        this.setLegajo(legajo);
        this.setNombre(nombre);
    }

    // Getter
    public int getLegajo() {
        return this.legajo;
    }

    public String getNombre() {
        return this.nombre;
    }

    // Setter
    public void setLegajo(int legajo) {
        if (legajo > 0) {
            this.legajo = legajo;
        } else {
            throw new IllegalArgumentException("ERROR. El legajo tiene que ser mayor a 0.");
        }
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        } else {
            throw new IllegalArgumentException("ERROR. No se ingreso el nombre.");
        }
    }

}
