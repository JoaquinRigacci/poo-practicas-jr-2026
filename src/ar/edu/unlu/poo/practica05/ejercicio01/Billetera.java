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

    // Método Bonus Track
    public Transferencia transferir(Billetera destino, String divisa, double monto, String detalle) throws SaldoInsuficienteException {
        // 1. Validaciones básicas de parámetros
        if (destino == null || destino == this) {
            throw new IllegalArgumentException("ERROR. La billetera destino no es válida o es la misma billetera origen.");
        }
        if (monto <= 0) {
            throw new IllegalArgumentException("ERROR. El monto a transferir debe ser mayor a 0.");
        }

        // 2. Precondición en Origen: Verificar que la cuenta origen exista y tenga saldo suficiente
        Cuenta cuentaOrigen = buscarCuenta(divisa);
        if (cuentaOrigen == null) {
            throw new IllegalArgumentException("ERROR. No posees una cuenta en " + divisa);
        }
        if (cuentaOrigen.getSaldo() < monto) {
            throw new SaldoInsuficienteException("ERROR. Saldo insuficiente para realizar la transferencia.");
        }

        // 3. Precondición en Destino: Verificar que el destino posea una cuenta activa en esa divisa
        Cuenta cuentaDestino = destino.buscarCuenta(divisa);
        if (cuentaDestino == null) {
            throw new IllegalArgumentException("ERROR. La billetera destino no tiene una cuenta abierta en " + divisa);
        }

        // 4. Ejecución atómica (Segura): Realizamos el movimiento una vez que sabemos que todo es válido
        this.extraer(divisa, monto);
        destino.depositar(divisa, monto);

        // 5. Retorno del comprobante inmutable
        String detalleFinal = (detalle != null && !detalle.trim().isEmpty()) ? detalle : "Transferencia enviada";
        return new Transferencia(divisa, monto, detalleFinal);
    }

    // Sobrecarga conveniente para cuando no se especifica un detalle explícito
    public Transferencia transferir(Billetera destino, String divisa, double monto) throws SaldoInsuficienteException {
        return transferir(destino, divisa, monto, "Transferencia realizada");
    }
}
