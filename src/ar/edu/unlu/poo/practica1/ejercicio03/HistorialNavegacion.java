package ar.edu.unlu.poo.practica1.ejercicio03;

public class HistorialNavegacion {

    // Atributos
    private NodoPagina tope;

    // Constructor
    public HistorialNavegacion() {
        this.setTope(null);
    }

    // Métodos
    public void visitarPagina(PaginaWeb paginaWeb) {
        var nuevoNodo = new NodoPagina(paginaWeb, this.getTope());
        this.setTope(nuevoNodo);
    }

    public PaginaWeb retrocederPagina() {
        // 1. Controlamos que no esté vacío [2]
        if (!this.estaVacio()) {
            // 2. Extraemos y guardamos la página del tope ACTUAL (Wikipedia) [1]
            PaginaWeb paginaARetornar = this.getTope().getPaginaWeb();

            // 3. Recién ahora movemos el tope al nodo inferior (Google) [1]
            this.setTope(this.getTope().getInferior());

            // 4. Retornamos la última página visitada de manera segura [1]
            return paginaARetornar;
        } else {
            // Excepción de dominio si intentan retroceder sin páginas [2]
            throw new HistorialVacioException("ERROR. El historial esta vacío.");
        }
    }

    public boolean estaVacio() {
        return this.getTope() == null;
    }

    public int getCantidadPaginas() {
        int total = 0;
        var actual = this.getTope();
        while(actual != null) {
            total++;
            actual = actual.getInferior();
        }
        return total;
    }

    // Getter
    private NodoPagina getTope() {
        return this.tope;
    }

    // Setter
    private void setTope(NodoPagina tope) {
        this.tope = tope;
    }

}
