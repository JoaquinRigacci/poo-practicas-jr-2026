package ar.edu.unlu.poo.practica08.ejercicio01;

public class CodigoPostal {

    private String codigo;
    private ValidadorCodigoPostal validador;

    public CodigoPostal(String codigo, ValidadorCodigoPostal validador) {
        this.codigo = codigo;
        this.validador = validador;
    }

    // Constructor sobrecargado opcional si se asigna el validador más tarde
    public CodigoPostal(String codigo) {
        this(codigo, null);
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setValidador(ValidadorCodigoPostal validador) {
        this.validador = validador;
    }

    /**
     * Delega la verificación de formato en la estrategia asignada.
     */
    public boolean esValido() {
        if (this.validador == null) {
            return false;
        }
        return this.validador.validar(this);
    }
}
