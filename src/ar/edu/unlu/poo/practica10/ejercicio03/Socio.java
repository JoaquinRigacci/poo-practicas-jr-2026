package ar.edu.unlu.poo.practica10.ejercicio03;

public class Socio {

    // Atributos
    private int id;
    private String nombre;

    // Constructor
    public Socio(int id, String nombre) {
        if (nombre == null || nombre.trim().isEmpty() || id <= 0) {
            throw new IllegalArgumentException("ERROR: El nombre no puede ser nulo o el ID no puede ser 0.");
        }
        this.id = id;
        this.nombre = nombre;
    }

    // Getter
    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }
}
