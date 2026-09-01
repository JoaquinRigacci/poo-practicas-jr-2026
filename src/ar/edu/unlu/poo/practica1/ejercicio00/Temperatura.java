package ar.edu.unlu.poo.practica1.ejercicio00;

public class Temperatura {
    private double celsius;

    public Temperatura(double unValorDeTemperatura) {
        if (unValorDeTemperatura < -273.15) {
            throw new IllegalArgumentException("No se permiten temperaturas menores a -273.15 °C");
        }
        celsius = unValorDeTemperatura;
    }

    public double getCelsius() {
        return celsius;
    }

    public double aFahrenheit() {
        return (celsius * 9 / 5) + 32;
    }
}
