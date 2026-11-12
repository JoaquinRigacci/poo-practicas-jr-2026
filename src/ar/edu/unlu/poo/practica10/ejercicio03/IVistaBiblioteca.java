package ar.edu.unlu.poo.practica10.ejercicio03;

public interface IVistaBiblioteca {
    void setControlador(ControladorBiblioteca controlador);
    void iniciar();
    void mostrarMensaje(String mensaje);
    void mostrarError(String error);
}
