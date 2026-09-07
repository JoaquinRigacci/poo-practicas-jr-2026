package ar.edu.unlu.poo.practica1.ejercicio03;

public class PaginaWeb {

    // Atributos
    private String url;
    private String tituloDescriptivo;

    // Constructor
    public PaginaWeb(String url, String tituloDescriptivo) {
        this.setUrl(url);
        this.setTituloDescriptivo(tituloDescriptivo);
    }

    // Getter
    public String getUrl() {
        return this.url;
    }

    public String getTituloDescriptivo(){
        return this.tituloDescriptivo;
    }

    // Setter
    public void setUrl(String url) {
        if (url != null && !url.isEmpty()) {
            this.url = url;
        } else {
            throw new IllegalArgumentException("ERROR. No se pudo ingresar el url.");
        }
    }

    public void setTituloDescriptivo(String tituloDescriptivo) {
        if (tituloDescriptivo != null && !tituloDescriptivo.isEmpty()) {
            this.tituloDescriptivo = tituloDescriptivo;
        } else {
            throw new IllegalArgumentException("ERROR. No se pudo ingresar el titulo descriptivo.");
        }
    }
}
