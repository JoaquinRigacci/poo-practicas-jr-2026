package ar.edu.unlu.poo.practica10.ejercicio03;

import java.util.Scanner;

public class VistaConsolaBiblioteca implements IVistaBiblioteca {

    private ControladorBiblioteca controlador;
    private AuditorEstadistico auditor;
    private MonitorPreventivo monitor;
    private Scanner scanner;

    public VistaConsolaBiblioteca(AuditorEstadistico auditor, MonitorPreventivo monitor) {
        this.auditor = auditor;
        this.monitor = monitor;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void setControlador(ControladorBiblioteca controlador) {
        this.controlador = controlador;
    }

    @Override
    public void mostrarMensaje(String mensaje) {
        System.out.println("\n" + mensaje);
    }

    @Override
    public void mostrarError(String error) {
        System.err.println("\n⚠️ " + error);
    }

    @Override
    public void iniciar() {
        int opcion = -1;
        do {
            System.out.println("\n=================================");
            System.out.println(" SISTEMA BIBLIOTECA (MVC)");
            System.out.println("=================================");
            System.out.println("1. Registrar Préstamo");
            System.out.println("2. Registrar Devolución");
            System.out.println("3. Ver Estadísticas y Alertas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1 -> menuRegistrarPrestamo();
                    case 2 -> menuRegistrarDevolucion();
                    case 3 -> mostrarEstadisticas();
                    case 0 -> System.out.println("¡Hasta luego!");
                    default -> mostrarError("Opción inválida.");
                }
            } catch (NumberFormatException e) {
                mostrarError("Debe ingresar un número entero.");
            }
        } while (opcion != 0);
    }

    private void menuRegistrarPrestamo() {
        System.out.println("\n--- Registrar Préstamo ---");
        System.out.print("Nombre del Socio: ");
        String nombre = scanner.nextLine();

        System.out.print("Tipo de recurso (1. Libro | 2. Equipamiento Tecnológico): ");
        int tipo = Integer.parseInt(scanner.nextLine());

        Socio socio = new Socio(1, nombre);
        Recurso recurso;

        if (tipo == 2) {
            recurso = new EquipamientoTecnologico("Notebook Dell", "SN-9988");
        } else {
            recurso = new Libro("Java POO", "Autor UNLu", 2024);
        }

        controlador.registrarPrestamo(recurso, socio);
    }

    private void menuRegistrarDevolucion() {
        System.out.println("\n--- Registrar Devolución ---");
        System.out.print("ID del Préstamo: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Días de mora: ");
        int mora = Integer.parseInt(scanner.nextLine());

        controlador.registrarDevolucion(id, mora);
    }

    private void mostrarEstadisticas() {
        System.out.println("\n=================================");
        System.out.println(" MÉTRICAS (OBSERVER EN ACCIÓN)");
        System.out.println("=================================");
        System.out.println("📊 Auditoría - Préstamos: " + auditor.getCantidadPrestamosRegistrados());
        System.out.println("📊 Auditoría - Devoluciones: " + auditor.getCantidadDevolucionesRegistradas());
        System.out.println("🚨 Monitor - Alertas Tecnológicas: " + monitor.getCantidadAlertas());
    }
}
