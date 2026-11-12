package ar.edu.unlu.poo.practica10.ejercicio03;

public class ControladorBiblioteca {

    private Biblioteca modelo;
    private IVistaBiblioteca vista;

    public ControladorBiblioteca(Biblioteca modelo, IVistaBiblioteca vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.setControlador(this);
    }

    public void registrarPrestamo(Recurso recurso, Socio socio) {
        try {
            TransaccionPrestamo t = this.modelo.registrarPrestamo(recurso, socio);
            this.vista.mostrarMensaje("✔ Préstamo registrado con éxito. ID Asignado: " + t.getId());
        } catch (Exception e) {
            this.vista.mostrarError(e.getMessage());
        }
    }

    public void registrarDevolucion(int idPrestamo, int diasMora) {
        try {
            double penalizacion = this.modelo.registrarDevolucion(idPrestamo, diasMora);
            this.vista.mostrarMensaje("✔ Devolución registrada. Penalización a pagar: $" + penalizacion);
        } catch (Exception e) {
            this.vista.mostrarError(e.getMessage());
        }
    }
}
