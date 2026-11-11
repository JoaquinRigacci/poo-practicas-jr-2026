package ar.edu.unlu.poo.practica10.ejercicio02;

public class Main {
    public static void main(String[] args) {
        // 1. Instanciamos el ÚNICO Modelo del sistema
        GestorTareas modelo = new GestorTareas();

        // 2. Instanciamos las dos Vistas Heterogéneas
        VistaTareas vistaDetalle = new VistaDetalle();
        VistaTareas vistaResumen = new VistaResumen();

        // 3. Instanciamos los Controladores (conectan automáticamente Modelo y Vistas)
        ControladorTareas controladorDetalle = new ControladorTareas(modelo, vistaDetalle);
        ControladorTareas controladorResumen = new ControladorTareas(modelo, vistaResumen);

        // 4. Inicializamos la vista pasiva y luego arrancamos el menú de la interactiva
        vistaResumen.iniciar();
        vistaDetalle.iniciar();
    }
}
