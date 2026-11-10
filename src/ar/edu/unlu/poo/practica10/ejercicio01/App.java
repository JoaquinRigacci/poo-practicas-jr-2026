package ar.edu.unlu.poo.practica10.ejercicio01;

public class App {

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println(" INICIANDO SALA DE CHAT MULTIUSUARIO (MVC) ");
        System.out.println("=================================================\n");

        // 1. Instanciamos el ÚNICO modelo compartido de la sala de chat
        Chat modeloChat = new Chat();

        // 2. Instanciamos la primera consola (Cliente 1)
        VistaConsola vista1 = new VistaConsola();
        ControladorChat controlador1 = new ControladorChat(modeloChat, vista1);

        // 3. Iniciamos la vista del Cliente 1
        // (En un entorno de consola única, este bucle gestionará la sesión interactiva)
        vista1.iniciar();
    }
}
