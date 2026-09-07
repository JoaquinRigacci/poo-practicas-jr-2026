package ar.edu.unlu.poo.practica1.ejercicio02;

public class Main {
    public static void main(String[] args) {
        // 1. Creamos un par de canciones reales
        // (Asumimos que tu constructor de Cancion pide: titulo, artista, duracion en segundos)
        Cancion c1 = new Cancion("I took a pil in Ibiza", "Mike Posner", 197);
        Cancion c2 = new Cancion("Knew better part two", "Ariana Grande", 164);

        // 2. Instanciamos nuestra Playlist vacía
        Playlist miPlaylist = new Playlist();

        // 3. Agregamos las canciones al tren
        miPlaylist.agregarCancion(c1);
        miPlaylist.agregarCancion(c2);

        // Mostramos el estado inicial de la playlist
        System.out.println("--- PLAYLIST INICIALIZADA ---");
        System.out.println("Cantidad de canciones: " + miPlaylist.getCantidadCanciones());
        System.out.println("Duracion total: " + miPlaylist.obtenerDuracionTotal() + " segundos.");
        System.out.println("--------------------------------\n");

        // 4. Usamos TRY-CATCH para reproducir de forma segura
        try {
            System.out.println("=== Iniciando Reproduccion ===");

            // Primera reproducción: saca Seminare
            Cancion sonando1 = miPlaylist.reproducirSiguiente();
            System.out.println("Reproduciendo ahora: " + sonando1.getTitulo() + " de " + sonando1.getAutor());

            // Segunda reproducción: saca Seguir viviendo sin tu amor
            Cancion sonando2 = miPlaylist.reproducirSiguiente();
            System.out.println("Reproduciendo ahora: " + sonando2.getTitulo() + " de " + sonando2.getAutor());

            // Tercera reproducción: ¡OJO! La playlist ya está vacía acá
            // Esta línea va a lanzar la PlaylistVaciaException
            System.out.println("\nIntentando reproducir una tercera cancion...");
            Cancion sonando3 = miPlaylist.reproducirSiguiente();

            // Esta línea nunca se va a ejecutar porque el error salta antes
            System.out.println("Reproduciendo ahora: " + sonando3.getTitulo());

        } catch (PlaylistVaciaException e) { // Atajamos tu excepcion personalizada
            //  98] En el catch imprimimos una traza o mensaje y manejamos el error de forma elegante
            System.out.println("\n⚠️ [CATCH ACTIVADO] ¡Atajamos un problema de forma segura!");
            System.out.println("Mensaje de la excepcion: " + e.getMessage()); // ]
            System.out.println("Evitamos que la aplicacion se cierre. Podés seguir navegando.");
        }

        // 5. El programa sigue vivo gracias al catch
        System.out.println("\n=================================");
        System.out.println("El programa finalizo con exito y de forma controlada. 😎");
    }
}
