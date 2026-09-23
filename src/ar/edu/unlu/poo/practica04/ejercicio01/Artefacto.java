package ar.edu.unlu.poo.practica04.ejercicio01;

public class Artefacto {

    // Atributos
    private String marca;
    private String modelo;
    private double precioUSD;

    // Constructor
    public Artefacto(String marca, String modelo, double precioUSD) {
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setPrecioUSD(precioUSD);
    }

    // Getter
    public String getMarca() {
        return this.marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public double getPrecioUSD() {
        return this.precioUSD;
    }

    // Setter
    public void setMarca(String marca) {
        if (marca != null && !marca.trim().isEmpty()) {
            this.marca = marca;
        } else {
            throw new IllegalArgumentException("ERROR. No se ingreso la marca del artefacto.");
        }
    }

    public void setModelo(String modelo) {
        if (modelo != null && !modelo.trim().isEmpty()) {
            this.modelo = modelo;
        } else {
            throw new IllegalArgumentException("ERROR. No se ingreso el modelo del artefacto.");
        }
    }

    public void setPrecioUSD(double precioUSD) {
        if (precioUSD > 0) {
            this.precioUSD = precioUSD;
        } else {
            throw new IllegalArgumentException("ERROR. El precio debe ser mayor a 0.");
        }
    }
}
