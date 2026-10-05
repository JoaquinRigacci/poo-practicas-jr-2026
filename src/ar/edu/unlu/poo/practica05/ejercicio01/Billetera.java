package ar.edu.unlu.poo.practica05.ejercicio01;

import java.util.ArrayList;
import java.util.List;

public class Billetera {

    // Atributos
    private List<Cuenta> cuentas;

    // Constructor
    public Billetera() {
        this.cuentas = new ArrayList<>();
    }

    // Métodos
    private Cuenta buscarCuenta(String divisa) {
        for (Cuenta cuenta : this.cuentas) {
            if (cuenta.getDivisa().equalsIgnoreCase(divisa)) {
                return cuenta;
            }
        }
        return null;
    }

    public void agregarCuenta(Cuenta cuenta) {
        if (cuenta != null) {
            if (buscarCuenta(cuenta.getDivisa()) == null) {
                this.cuentas.add(cuenta);
            } else {
                throw new CuentaDuplicadaException("ERROR. La cuenta ya existe.");
            }
        } else {
            throw new IllegalArgumentException("ERROR. No se ingreso la cuenta a agregar.");
        }
    }

    public double obtenerSaldo(String divisa) {
        Cuenta c1 = buscarCuenta(divisa);
        if (c1 != null) {
            return c1.getSaldo();
        } else {
            return 0.0;
        }
    }

    public void depositar(String divisa, double monto) {
        Cuenta cuenta = buscarCuenta(divisa);
        if (cuenta != null) {
            cuenta.depositar(monto);
        } else {
            throw new IllegalArgumentException("ERROR. No existe una cuenta en " + divisa);
        }
    }

    public void extraer(String divisa, double monto) {
        Cuenta cuenta = buscarCuenta(divisa);
        if (cuenta != null) {
            cuenta.extraer(monto);
        } else {
            throw new IllegalArgumentException("ERROR. No existe una cuenta en " + divisa);
        }
    }
}
