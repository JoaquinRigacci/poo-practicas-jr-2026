package ar.edu.unlu.poo.practica06.ejercicio01;

public class Prenda {

    // Atributos
    private String nombre;
    private double precioBase;

    // Constructor
    public Prenda(String nombre, double precioBase) {
        this.setNombre(nombre);
        this.setPrecioBase(precioBase);
    }

    // Getter
    public String getNombre() {
        return this.nombre;
    }

    public double getPrecioBase() {
        return this.precioBase;
    }

    // Setter
    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        } else {
            throw new IllegalArgumentException("ERROR. El nombre no puede ser nulo ni vacío.");
        }
    }

    public void setPrecioBase(double precioBase) {
        if (precioBase > 0) {
            this.precioBase = precioBase;
        } else {
            throw new IllegalArgumentException("ERROR. El precio debe ser mayor a 0.");
        }
    }

    // Métodos
    public double calcularPrecioFinal() {
        return this.precioBase;
    }

}
