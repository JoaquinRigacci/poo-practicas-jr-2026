package ar.edu.unlu.poo.practica07.ejercicio04;

public class Cancion extends ContenidoMultimedia implements Descargable{

    // Atributos
    private int calidadKbps;
    private boolean descargado;

    // Constructor
    public Cancion(String titulo, int duracionSegundos, String creador, int calidadKbps) {
        super(titulo, duracionSegundos, creador);
        this.setCalidadKbps(calidadKbps);
        this.setDescargado(false);
    }

    // Get
    public int getCalidadKbps() {
        return this.calidadKbps;
    }


    // Set
    public void setCalidadKbps(int calidadKbps) {
        if (calidadKbps <= 0) {
            throw new IllegalArgumentException("ERROR. La calidad en Kbps debe ser mayor a 0.");
        }
        this.calidadKbps = calidadKbps;
    }

    public void setDescargado(boolean descargado) {
        this.descargado = descargado;
    }

    // Métodos
    @Override
    public String reproducir() {
        return "El título de la canción es '" + this.getTitulo() + "', el artista es " + this.getCreador() + " y la tasa de bits de decodificación es de " + this.getCalidadKbps() + ".";
    }

    @Override
    public boolean isDescargado() {
        return this.descargado;
    }

    @Override
    public void descargar() {
        this.setDescargado(true);
    }
}
