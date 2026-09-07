package ar.edu.unlu.poo.practica1.ejercicio03;

public class Main {
    public static void main(String[] args) {
        // 1. Instanciamos el historial de navegación
        HistorialNavegacion historial = new HistorialNavegacion();

        System.out.println("=== SIMULADOR DE HISTORIAL DE NAVEGACIÓN (TAD PILA) ===");
        System.out.println("¿El historial está vacío al inicio?: " + (historial.estaVacio() ? "SÍ" : "NO"));
        System.out.println();

        // 2. Creamos algunas páginas web para simular navegación
        PaginaWeb google = new PaginaWeb("https://www.google.com", "Buscador Google");
        PaginaWeb wikipedia = new PaginaWeb("https://es.wikipedia.org", "Wikipedia, la enciclopedia libre");
        PaginaWeb youtube = new PaginaWeb("https://www.youtube.com", "YouTube - Videos");

        // 3. Comenzamos a navegar (Apilamos las páginas)
        System.out.println("--- Navegando por Internet ---");

        System.out.println("Visitando: " + google.getTituloDescriptivo() + " (" + google.getUrl() + ")...");
        historial.visitarPagina(google);

        System.out.println("Visitando: " + wikipedia.getTituloDescriptivo() + " (" + wikipedia.getUrl() + ")...");
        historial.visitarPagina(wikipedia);

        System.out.println("Visitando: " + youtube.getTituloDescriptivo() + " (" + youtube.getUrl() + ")...");
        historial.visitarPagina(youtube);

        System.out.println();
        System.out.println("Cantidad de páginas registradas en el historial: " + historial.getCantidadPaginas());
        System.out.println("¿El historial está vacío ahora?: " + (historial.estaVacio() ? "SÍ" : "NO"));
        System.out.println();

        // 4. Simulamos apretar el botón 'Atrás' (Desapilamos de forma segura)
        System.out.println("--- Retrocediendo en el historial (Botón Atrás) ---");
        try {
            // Primer retroceso (Sale de YouTube, vuelve a Wikipedia)
            PaginaWeb atras1 = historial.retrocederPagina();
            System.out.println("<- Salimos de la página: " + atras1.getTituloDescriptivo());
            System.out.println("   Páginas restantes en historial: " + historial.getCantidadPaginas());
            System.out.println();

            // Segundo retroceso (Sale de Wikipedia, vuelve a Google)
            PaginaWeb atras2 = historial.retrocederPagina();
            System.out.println("<- Salimos de la página: " + atras2.getTituloDescriptivo());
            System.out.println("   Páginas restantes en historial: " + historial.getCantidadPaginas());
            System.out.println();

            // Tercer retroceso (Sale de Google, el historial queda vacío)
            PaginaWeb atras3 = historial.retrocederPagina();
            System.out.println("<- Salimos de la página: " + atras3.getTituloDescriptivo());
            System.out.println("   Páginas restantes en historial: " + historial.getCantidadPaginas());
            System.out.println("   ¿Historial vacío?: " + (historial.estaVacio() ? "SÍ" : "NO"));
            System.out.println();

            // Cuarto retroceso (Debería disparar la excepción porque ya no hay páginas)
            System.out.println("Intentando retroceder una vez más con historial vacío...");
            historial.retrocederPagina();

        } catch (HistorialVacioException e) {
            // Capturamos el error controlado y mostramos el mensaje al usuario
            System.out.println("\n[!] EXCEPCIÓN DETECTADA CON ÉXITO: " + e.getMessage());
        }

        System.out.println();
        System.out.println("=== FIN DE LA SIMULACIÓN ===");
    }
}
