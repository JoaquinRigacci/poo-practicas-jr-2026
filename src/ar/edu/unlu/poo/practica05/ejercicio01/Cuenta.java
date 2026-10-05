package ar.edu.unlu.poo.practica05.ejercicio01;

import java.util.Locale;

public class Cuenta {

    // Atributos
    private String divisa;
    private double saldo;

    // Constructor
    public Cuenta(String divisa) {
        setDivisa(divisa);
        this.saldo = 0.0;
    }

    // Métodos
    public void depositar(double monto) {
        if (monto > 0) {
            this.saldo += monto;
        } else {
            throw new IllegalArgumentException("ERROR. No se puede ingresa saldo menor a 0.");
        }
    }

    public void extraer(double monto) throws SaldoInsuficienteException{
        if (monto <= 0) {
            throw new IllegalArgumentException("ERROR. El monto a extraer debe ser mayor a 0.");
        }
        if (monto > this.saldo) {
            throw new SaldoInsuficienteException("ERROR. El saldo es insuficiente.");
        }
        this.saldo -= monto;
    }

    // Getter
    public String getDivisa() {
        return this.divisa;
    }

    public double getSaldo() {
        return this.saldo;
    }

    // Setter
    public void setDivisa(String divisa) {
        if (divisa != null && !divisa.trim().isEmpty()) {
            this.divisa = divisa.trim().toUpperCase();
        } else {
            throw new IllegalArgumentException("ERROR. La divisa no puede ser nula ni vacía.");
        }
    }

}
