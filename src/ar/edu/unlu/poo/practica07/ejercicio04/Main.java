package ar.edu.unlu.poo.practica07.ejercicio04;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("==========================================================");
        System.out.println(" PLATAFORMA DE STREAMING Y GESTOR DE DESCARGAS (POO)");
        System.out.println("==========================================================\n");

        // 1. Instanciamos distintos contenidos multimedia del catálogo
        Cancion cancion1 = new Cancion("Bohemian Rhapsody", 354, "Queen", 320);
        Cancion cancion2 = new Cancion("De Música Ligera", 212, "Soda Stereo", 256);
        Pelicula pelicula1 = new Pelicula("Inception", 8880, "Christopher Nolan", "4K Ultra HD");
        Podcast podcast1 = new Podcast("La Cruda", 3600, "Migue Granados", 12, 2);

        // 2. Probamos la reproducción polimórfica de todo el catálogo
        System.out.println("--- 1. REPRODUCCIÓN DEL CATÁLOGO MULTIMEDIA ---");
        List<ContenidoMultimedia> catalogo = new ArrayList<>();
        catalogo.add(cancion1);
        catalogo.add(cancion2);
        catalogo.add(pelicula1);
        catalogo.add(podcast1);

        for (ContenidoMultimedia contenido : catalogo) {
            System.out.println("▶ " + contenido.reproducir());
        }

        // 3. Verificamos el estado inicial de descarga
        System.out.println("\n--- 2. ESTADO INICIAL DE DESCARGAS ---");
        System.out.println("¿'" + cancion1.getTitulo() + "' está descargada?: " + cancion1.isDescargado());
        System.out.println("¿'" + pelicula1.getTitulo() + "' está descargada?: " + pelicula1.isDescargado());

        // 4. Instanciamos el Gestor de Descargas y encolamos solo los descargables
        System.out.println("\n--- 3. ENCOLADO Y PROCESAMIENTO DE DESCARGAS ---");
        GestorDeDescargas gestor = new GestorDeDescargas();

        // Encolamos Canciones y Películas (implementan Descargable)
        gestor.encolarDescarga(cancion1);
        gestor.encolarDescarga(cancion2);
        gestor.encolarDescarga(pelicula1);

        /*
         * NOTA DE DISEÑO (Seguridad de tipos en tiempo de compilación):
         * Si descomentas la siguiente línea, Java ni siquiera compilará
         * porque Podcast hereda de ContenidoMultimedia pero NO implementa Descargable:
         *
         * gestor.encolarDescarga(podcast1); // Error de compilación directo
         */

        // Procesamos la cola
        int procesadas = gestor.procesarDescargas();
        System.out.println("Total de contenidos descargados exitosamente: " + procesadas);

        // 5. Verificamos el cambio de estado luego del procesamiento
        System.out.println("\n--- 4. ESTADO POST-PROCESAMIENTO ---");
        System.out.println("¿'" + cancion1.getTitulo() + "' está descargada?: " + cancion1.isDescargado());
        System.out.println("¿'" + cancion2.getTitulo() + "' está descargada?: " + cancion2.isDescargado());
        System.out.println("¿'" + pelicula1.getTitulo() + "' está descargada?: " + pelicula1.isDescargado());

        // 6. Prueba defensiva: intentar encolar un elemento nulo
        System.out.println("\n--- 5. PRUEBA DE PROGRAMACIÓN DEFENSIVA ---");
        try {
            gestor.encolarDescarga(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada con éxito: " + e.getMessage());
        }

        System.out.println("\n==========================================================");
        System.out.println(" ¡TODAS LAS PRUEBAS FINALIZARON EXITOSAMENTE!");
        System.out.println("==========================================================");
    }
}
