package ar.edu.unlu.poo.practica07.ejercicio04;

public class Podcast extends ContenidoMultimedia{

    // Atributos
    private int nroEpisodio;
    private int temporada;

    // Constructor
    public Podcast(String titulo, int duracionSegundos, String creador, int nroEpisodio, int temporada) {
        super(titulo, duracionSegundos, creador);
        this.setNroEpisodio(nroEpisodio);
        this.setTemporada(temporada);
    }

    // Getter
    public int getNroEpisodio() {
        return this.nroEpisodio;
    }

    public int getTemporada() {
        return this.temporada;
    }

    // Setter
    public void setNroEpisodio(int nroEpisodio) {
        if (nroEpisodio <= 0) {
            throw new IllegalArgumentException("ERROR. El número del episodio debe ser mayor a 0.");
        }
        this.nroEpisodio = nroEpisodio;
    }

    public void setTemporada(int temporada) {
        if (temporada <= 0) {
            throw new IllegalArgumentException("ERROR. El número de temporada debe ser mayor a 0.");
        }
        this.temporada = temporada;
    }

    // Método
    @Override
    public String reproducir() {
        return "El título del Podcast es '" + this.getTitulo() + "', el anfitrión es " + this.getCreador() + " y es el episodio número " + this.getNroEpisodio() + " de la temporada " + this.getTemporada() + ".";
    }
}
