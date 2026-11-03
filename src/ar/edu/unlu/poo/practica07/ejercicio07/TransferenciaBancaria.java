package ar.edu.unlu.poo.practica07.ejercicio07;

public class TransferenciaBancaria extends MetodoDePago implements Reembolsable, AuditableFiscalmente {

    // Atributos privados
    private String cbu;
    private String bancoOrigen;

    // Constructor
    public TransferenciaBancaria(String idTransaccion, double monto, String cbu, String bancoOrigen) {
        super(idTransaccion, monto);
        this.setCbu(cbu);
        this.setBancoOrigen(bancoOrigen);
    }

    // Getters
    private String getCbu() {
        return this.cbu;
    }

    private String getBancoOrigen() {
        return this.bancoOrigen;
    }

    // Setters privados con validación de invariantes
    private void setCbu(String cbu) {
        if (cbu == null || cbu.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR. El CBU no puede ser nulo ni vacío.");
        }
        this.cbu = cbu;
    }

    private void setBancoOrigen(String bancoOrigen) {
        if (bancoOrigen == null || bancoOrigen.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR. El banco de origen no puede ser nulo ni vacío.");
        }
        this.bancoOrigen = bancoOrigen;
    }

    // Métodos del Template Method
    @Override
    protected boolean validar() {
        // Valida que el CBU tenga exactamente 22 caracteres y que el banco no esté vacío
        if (this.getCbu().trim().length() != 22 || this.getBancoOrigen().trim().isEmpty()) {
            System.out.println("ERROR. Formato inválido de CBU (debe tener 22 caracteres) o banco no especificado.");
            return false;
        }
        return true;
    }

    @Override
    protected boolean debitar() {
        // Simula la confirmación interbancaria en tiempo real
        System.out.println("Transferencia confirmada desde " + this.getBancoOrigen() + " por $" + this.getMonto());
        return true;
    }

    // Métodos de Interfaces de Capacidad
    @Override
    public boolean procesarReembolso(double monto) {
        // Solo reembolsa si la transferencia original fue exitosa y el monto es válido
        if (!this.isExitoso() || monto <= 0 || monto > this.getMonto()) {
            System.out.println("ERROR. No se puede procesar el reembolso bancario para la transacción " + this.getIdTransaccion());
            return false;
        }
        System.out.println("Contracargo interbancario de $" + monto + " acreditado exitosamente al CBU " + this.getCbu());
        return true;
    }

    @Override
    public String generarComprobanteFiscal() {
        double iva = this.getMonto() * 0.21;
        // Enmascaramos los primeros 18 dígitos del CBU, mostrando solo los últimos 4
        String cbuEnmascarado = "******************" + this.getCbu().substring(18);
        return "COMPROBANTE FISCAL - Transacción: " + this.getIdTransaccion() + " | Canal: Transferencia Bancaria (" + this.getBancoOrigen() + ")" + " | CBU: " + cbuEnmascarado + " | Monto Neto: $" + this.getMonto() + " | IVA (21%): $" + iva + " | Total Facturado: $" + (this.getMonto() + iva);
    }
}
