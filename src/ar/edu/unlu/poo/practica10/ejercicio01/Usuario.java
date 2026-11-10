package ar.edu.unlu.poo.practica10.ejercicio01;

public class Usuario {

    // Atributos
    private static int contadorId = 0; // Atributo de clase para IDs autoincrementales
    private final int id;
    private String nombre;

    // Constructor
    public Usuario(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR. El nombre de usuario no puede ser nulo ni estar vacío.");
        }
        this.id = ++contadorId;
        this.nombre = nombre.trim();
    }

    // Getter
    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }
}
