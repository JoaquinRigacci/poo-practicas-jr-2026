package ar.edu.unlu.poo.practica07.ejercicio01;

public class Circulo extends Forma{

    // Atributos
    private double radio;

    // Constructor
    public Circulo(String color, double radio) {
        super(color);
        this.setRadio(radio);
    }

    // Getter
    public double getRadio() {
        return this.radio;
    }

    // Setter
    public void setRadio(double radio) {
        if (radio <= 0) {
            throw new IllegalArgumentException("ERROR. El radio debe ser mayor a 0.");
        }
        this.radio = radio;
    }

    // Métodos
    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(this.getRadio(), 2);
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujando un circulo de color " + this.getColor() + " y radio " + this.getRadio() + ".");
    }
}
