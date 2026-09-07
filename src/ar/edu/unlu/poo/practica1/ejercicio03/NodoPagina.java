package ar.edu.unlu.poo.practica1.ejercicio03;

public class NodoPagina {

    // Atributos
    private PaginaWeb paginaWeb;
    private NodoPagina inferior;

    // Constructor
    public NodoPagina(PaginaWeb paginaWeb, NodoPagina inferior) {
        this.setPaginaWeb(paginaWeb);
        this.setInferior(inferior);
    }

    // Getter
    public PaginaWeb getPaginaWeb() {
        return this.paginaWeb;
    }

    public NodoPagina getInferior() {
        return this.inferior;
    }

    // Setter
    public void setPaginaWeb(PaginaWeb paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public void setInferior(NodoPagina inferior) {
        this.inferior = inferior;
    }

}
