package ar.edu.unlu.poo.practica10.ejercicio03;

public class Prestamo implements TransaccionPrestamo{

    // Atributos
    private int id;
    private Recurso recurso;
    private Socio socio;
    private boolean devuelto;

    // Constructor
    public Prestamo(int id, Recurso recurso, Socio socio) {
        if (id <= 0) {
            throw new IllegalArgumentException("ERROR: El id tiene que ser mayor a 0.");
        }
        if (recurso == null || socio == null) {
            throw new IllegalArgumentException("ERROR: El recurso o el socio no puede ser nulo.");
        }
        if (recurso.isPrestado()) {
            throw new IllegalArgumentException("ERROR: El recurso ya esta prestado.");
        }
        this.id = id;

        recurso.marcarComoPrestado();
        this.recurso = recurso;

        this.socio = socio;
        this.devuelto = false;
    }

    // Getter
    public int getId() {
        return this.id;
    }

    public Recurso getRecurso() {
        return this.recurso;
    }

    public Socio getSocio() {
        return this.socio;
    }

    public boolean isDevuelto() {
        return this.devuelto;
    }

    // Métodos
    public double registrarDevolucion(int diasMora) {
        if (this.devuelto == true) {
            throw new IllegalArgumentException("ERROR: El recurso ya fue devuelto.");
        }
        this.devuelto = true;
        recurso.marcarComoDevuelto();
        return recurso.calcularPenalizacion(diasMora);
    }
}
