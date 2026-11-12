package ar.edu.unlu.poo.practica10.ejercicio03;

public interface TransaccionPrestamo {
    int getId();
    Recurso getRecurso();
    Socio getSocio();
    boolean isDevuelto();
}
