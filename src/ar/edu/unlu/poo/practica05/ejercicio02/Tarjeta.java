package ar.edu.unlu.poo.practica05.ejercicio02;

public class Tarjeta {

    // Atributos
    private final String numero;

    // Constructor
    public Tarjeta(String numero) {
        if (numero == null || numero.trim().isEmpty()) {
            throw new IllegalArgumentException("ERORR. El numnero de la tarjeta no puede ser nulo.");
        }
        this.numero = numero.trim();
    }

    // Getter
    public String getNumero() {
        return this.numero;
    }

    // Métodos
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarjeta tarjeta = (Tarjeta) o;
        return this.numero.equalsIgnoreCase(tarjeta.numero);
    }

    @Override
    public int hashCode() {
        return this.numero.toLowerCase().hashCode();
    }
}
