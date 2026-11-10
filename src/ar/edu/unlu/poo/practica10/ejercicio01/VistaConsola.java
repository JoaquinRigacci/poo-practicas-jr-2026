package ar.edu.unlu.poo.practica10.ejercicio01;

import java.util.Scanner;

public class VistaConsola implements IVistaChat {

    private ControladorChat controlador;
    private final Scanner scanner;

    public VistaConsola() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void setControlador(ControladorChat controlador) {
        this.controlador = controlador;
    }

    @Override
    public void iniciar() {
        System.out.println("=== BIENVENIDO A LA SALA DE CHAT UNLu ===");
        System.out.print("Ingrese su nombre de usuario para ingresar: ");
        String nombre = this.scanner.nextLine();
        this.controlador.conectarUsuario(nombre);

        int opcion = 0;
        do {
            this.mostrarMenu();
            try {
                opcion = Integer.parseInt(this.scanner.nextLine());
                this.procesarOpcion(opcion);
            } catch (NumberFormatException e) {
                this.mostrarError("Opción inválida. Ingrese un número.");
            }
        } while (opcion != 4);
    }

    private void mostrarMenu() {
        System.out.println("\n--- MENÚ DE OPCIONES ---");
        System.out.println("1. Enviar mensaje");
        System.out.println("2. Ver usuarios conectados");
        System.out.println("3. Ver historial de chat");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                System.out.print("Escriba su mensaje: ");
                String mensaje = this.scanner.nextLine();
                this.controlador.enviarMensaje(mensaje);
                break;
            case 2:
                this.controlador.solicitarUsuarios();
                break;
            case 3:
                this.controlador.solicitarHistorial();
                break;
            case 4:
                this.controlador.desconectar();
                System.out.println("Ha salido de la sala de chat. ¡Hasta luego!");
                break;
            default:
                this.mostrarError("Opción no válida.");
        }
    }

    @Override
    public void mostrarMensaje(String texto) {
        System.out.println("[AVISO]: " + texto);
    }

    @Override
    public void mostrarUsuarios(Usuario[] usuarios) {
        System.out.println("\n--- USUARIOS ACTIVOS (" + usuarios.length + ") ---");
        for (Usuario u : usuarios) {
            System.out.println(" - " + u.getNombre() + " (ID: " + u.getId() + ")");
        }
    }

    @Override
    public void mostrarHistorial(Mensaje[] mensajes) {
        System.out.println("\n--- HISTORIAL DE CHAT ---");
        for (Mensaje m : mensajes) {
            if (m.esMensajeDelSistema()) {
                System.out.println("[SISTEMA]: " + m.getTexto());
            } else {
                System.out.println("[" + m.getAutor().getNombre() + "]: " + m.getTexto());
            }
        }
    }

    @Override
    public void mostrarError(String error) {
        System.out.println("[ERROR]: " + error);
    }
}
