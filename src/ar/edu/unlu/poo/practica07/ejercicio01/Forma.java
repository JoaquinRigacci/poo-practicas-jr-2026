package ar.edu.unlu.poo.practica07.ejercicio01;

public abstract class Forma implements Dibujable{

    // Atributos
    private String color;

    // Constructor
    public Forma(String color) {
        this.setColor(color);
    }

    // Getter
    public String getColor() {
        return this.color;
    }

    // Setter
    public void setColor(String color) {
        if (color == null || color.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR. El color no puede ser nulo.");
        }
        this.color = color;
    }

    // Método Abstracto
    public abstract double calcularArea();
}
