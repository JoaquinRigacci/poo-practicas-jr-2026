package ar.edu.unlu.poo.practica07.ejercicio07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProcesadorVentas {

    // Colección para registrar el historial de transacciones procesadas
    private List<MetodoDePago> transacciones;

    // Constructor
    public ProcesadorVentas() {
        this.transacciones = new ArrayList<>();
    }

    // Getter que retorna una vista inmodificable para evitar la fuga de representación (aliasing)
    public List<MetodoDePago> getTransacciones() {
        return Collections.unmodifiableList(this.transacciones);
    }

    // Métodos
    /**
     * Procesa un cobro interactuando exclusivamente contra la abstracción MetodoDePago.
     * Delega la ejecución mediante Polimorfismo Dinámico y Template Method.
     */
    public boolean procesarCobro(MetodoDePago pago) {
        if (pago == null) {
            throw new IllegalArgumentException("ERROR. El método de pago no puede ser nulo.");
        }

        // Ejecuta el Template Method invariable de la clase base
        boolean resultado = pago.procesarPago();

        // Registra la transacción en el historial de ventas
        this.transacciones.add(pago);

        return resultado;
    }

    /**
     * Gestiona una devolución recibiendo la interfaz de capacidad Reembolsable.
     * Garantiza en tiempo de compilación que sea imposible enviarle un medio no reembolsable (como Criptomoneda),
     * respetando el Principio de Segregación de Interfaces (ISP) y Liskov (LSP).
     */
    public boolean gestionarDevolucion(Reembolsable medio, double monto) {
        if (medio == null) {
            throw new IllegalArgumentException("ERROR. El medio reembolsable no puede ser nulo.");
        }
        if (monto <= 0) {
            throw new IllegalArgumentException("ERROR. El monto a reembolsar debe ser mayor a 0.");
        }

        // Delega la operación directamente al contrato de la interfaz
        return medio.procesarReembolso(monto);
    }

    /**
     * Emite el comprobante fiscal interactuando con la interfaz AuditableFiscalmente.
     * Elimina por completo el uso de condicionales 'instanceof'.
     */
    public String auditarOperacion(AuditableFiscalmente auditable) {
        if (auditable == null) {
            throw new IllegalArgumentException("ERROR. El objeto auditable no puede ser nulo.");
        }

        // Delega la generación del comprobante al objeto responsable
        return auditable.generarComprobanteFiscal();
    }
}