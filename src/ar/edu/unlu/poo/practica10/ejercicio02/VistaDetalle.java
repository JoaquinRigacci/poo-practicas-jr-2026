package ar.edu.unlu.poo.practica10.ejercicio02;

import java.util.Scanner;

public class VistaDetalle implements VistaTareas{

    // Atributos
    private ControladorTareas controlador;
    private final Scanner scanner;

    // Constructor
    public VistaDetalle() {
        this.scanner = new Scanner(System.in);
    }

    // Métodos Visuales
    @Override
    public void setControlador(ControladorTareas controlador) {
        this.controlador = controlador;
    }

    @Override
    public void mostrarError(String error) {
        System.out.println("ERROR: " + error);
    }

    @Override
    public void mostrarInformacion(Tarea[] tareas) {
        System.out.println("\n--- LISTADO DE TAREAS EN DETALLE ---");
        if (tareas.length == 0) {
            System.out.println("No hay tareas registradas.");
            System.out.println("------------------------------------\n");
            return;
        }
        for (Tarea t : tareas) {
            System.out.println("[ID: " + t.getId() + "] " + t.getDescripcion() +
                    " | Estado: " + (t.isCompletada() ? "COMPLETADA" : "PENDIENTE"));
        }
        System.out.println("------------------------------------\n");
    }

    // Menú Interactivo
    @Override
    public void iniciar() {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("=== POODO - VISTA DETALLE ===");
            System.out.println("1. Crear Tarea");
            System.out.println("2. Marcar Tarea como Completada");
            System.out.println("3. Eliminar Tarea");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(this.scanner.nextLine());
                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese la descripción de la tarea: ");
                        String desc = this.scanner.nextLine();
                        this.controlador.crearTarea(desc);
                        break;
                    case 2:
                        System.out.print("Ingrese el ID de la tarea a completar: ");
                        int idCompletar = Integer.parseInt(this.scanner.nextLine());
                        this.controlador.completarTarea(idCompletar);
                        break;
                    case 3:
                        System.out.print("Ingrese el ID de la tarea a eliminar: ");
                        int idEliminar = Integer.parseInt(this.scanner.nextLine());
                        this.controlador.eliminarTarea(idEliminar);
                        break;
                    case 0:
                        System.out.println("Saliendo de la aplicación...");
                        break;
                    default:
                        this.mostrarError("Opción inválida.");
                        break;
                }
            } catch (NumberFormatException e) {
                this.mostrarError("Debe ingresar un número válido.");
            }
        }
    }
}
