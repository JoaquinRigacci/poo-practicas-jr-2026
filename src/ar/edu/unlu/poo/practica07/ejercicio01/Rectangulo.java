package ar.edu.unlu.poo.practica07.ejercicio01;

public class Rectangulo extends Forma{

    // Atributos
    private double base;
    private double altura;

    // Constructor
    public Rectangulo(String color, double base, double altura) {
        super(color);
        this.setBase(base);
        this.setAltura(altura);
    }

    // Getter
    public double getBase() {
        return this.base;
    }

    public double getAltura() {
        return this.altura;
    }

    // Setter
    public void setBase(double base) {
        if (base <= 0)  {
            throw new IllegalArgumentException("ERROR: La base debe ser mayor a 0.");
        }
        this.base = base;
    }

    public void setAltura(double altura) {
        if (altura <= 0) {
            throw new IllegalArgumentException("ERROR. La altura debe ser mayor a 0.");
        }
        this.altura = altura;
    }

    // Métodos
    @Override
    public double calcularArea() {
        return this.getBase() * this.getAltura();
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujando un rectangulo de color " + this.getColor() + ", de base " + this.getBase() + " y de altura " + this.getAltura() + ".");
    }
}
