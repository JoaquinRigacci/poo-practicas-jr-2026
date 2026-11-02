package ar.edu.unlu.poo.practica07.ejercicio00;

public class Camisa extends Prenda{

    // Atributo
    private boolean mangaLarga;

    // Constructor
    public Camisa(double precioDeLista, boolean mangaLarga) {
        super(precioDeLista);
        this.setMangaLarga(mangaLarga);
    }

    // Get
    public boolean isMangaLarga() {
        return this.mangaLarga;
    }

    // Set
    public void setMangaLarga(boolean mangaLarga) {
        this.mangaLarga = mangaLarga;
    }

    // Método
    @Override
    public double calcularPrecio() {
        return super.calcularPrecio();
    }
}
