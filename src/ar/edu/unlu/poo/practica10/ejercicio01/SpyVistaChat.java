package ar.edu.unlu.poo.practica10.ejercicio01;

public class SpyVistaChat implements IVistaChat {

    private ControladorChat controlador;

    // Banderas y contadores para registrar las interacciones (Espía)
    private boolean fueIniciada = false;
    private boolean fueLlamadoMostrarMensaje = false;
    private boolean fueLlamadoMostrarUsuarios = false;
    private boolean fueLlamadoMostrarHistorial = false;
    private boolean fueLlamadoMostrarError = false;

    private String ultimoMensajeMostrado;
    private String ultimoErrorMostrado;
    private int cantidadMensajesEnHistorial = 0;
    private int cantidadUsuariosActivos = 0;

    @Override
    public void setControlador(ControladorChat controlador) {
        this.controlador = controlador;
    }

    @Override
    public void iniciar() {
        this.fueIniciada = true;
    }

    @Override
    public void mostrarMensaje(String texto) {
        this.fueLlamadoMostrarMensaje = true;
        this.ultimoMensajeMostrado = texto;
    }

    @Override
    public void mostrarUsuarios(Usuario[] usuarios) {
        this.fueLlamadoMostrarUsuarios = true;
        this.cantidadUsuariosActivos = usuarios != null ? usuarios.length : 0;
    }

    @Override
    public void mostrarHistorial(Mensaje[] mensajes) {
        this.fueLlamadoMostrarHistorial = true;
        this.cantidadMensajesEnHistorial = mensajes != null ? mensajes.length : 0;
    }

    @Override
    public void mostrarError(String error) {
        this.fueLlamadoMostrarError = true;
        this.ultimoErrorMostrado = error;
    }

    // --- MÉTODOS ACCESORES DE INSPECCIÓN EXCLUSIVOS PARA JUNIT 5 ---

    public boolean fueIniciada() {
        return fueIniciada;
    }

    public boolean fueLlamadoMostrarMensaje() {
        return fueLlamadoMostrarMensaje;
    }

    public boolean fueLlamadoMostrarUsuarios() {
        return fueLlamadoMostrarUsuarios;
    }

    public boolean fueLlamadoMostrarHistorial() {
        return fueLlamadoMostrarHistorial;
    }

    public boolean fueLlamadoMostrarError() {
        return fueLlamadoMostrarError;
    }

    public String getUltimoMensajeMostrado() {
        return ultimoMensajeMostrado;
    }

    public String getUltimoErrorMostrado() {
        return ultimoErrorMostrado;
    }

    public int getCantidadMensajesEnHistorial() {
        return cantidadMensajesEnHistorial;
    }

    public int getCantidadUsuariosActivos() {
        return cantidadUsuariosActivos;
    }
}