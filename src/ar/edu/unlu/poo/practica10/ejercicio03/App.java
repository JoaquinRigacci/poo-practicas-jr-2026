package ar.edu.unlu.poo.practica10.ejercicio03;

public class App {

    public static void main(String[] args) {
        // 1. Instanciamos el Modelo (Sujeto Observable)
        Biblioteca biblioteca = new Biblioteca();

        // 2. Instanciamos los Observadores y los suscribimos al Modelo
        AuditorEstadistico auditor = new AuditorEstadistico();
        MonitorPreventivo monitor = new MonitorPreventivo();
        biblioteca.addObserver(auditor);
        biblioteca.addObserver(monitor);

        // 3. Instanciamos la Vista y le pasamos los observadores para la consulta de métricas
        IVistaBiblioteca vista = new VistaConsolaBiblioteca(auditor, monitor);

        // 4. Instanciamos el Controlador (vincula Modelo y Vista)
        ControladorBiblioteca controlador = new ControladorBiblioteca(biblioteca, vista);

        // 5. Arrancamos el circuito MVC
        vista.iniciar();
    }
}
