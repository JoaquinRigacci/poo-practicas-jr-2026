package ar.edu.unlu.poo.practica07.ejercicio07;

public class Criptomoneda extends MetodoDePago {

    // Atributos privados
    private String direccionBilletera;
    private String redBlockchain;
    private double gasFee;

    // Constructor
    public Criptomoneda(String idTransaccion, double monto, String direccionBilletera, String redBlockchain, double gasFee) {
        super(idTransaccion, monto);
        this.setDireccionBilletera(direccionBilletera);
        this.setRedBlockchain(redBlockchain);
        this.setGasFee(gasFee);
    }

    // Getters privados (mínima exposición y estándar 1.9.1)
    private String getDireccionBilletera() {
        return this.direccionBilletera;
    }

    private String getRedBlockchain() {
        return this.redBlockchain;
    }

    public double getGasFee() {
        return this.gasFee;
    }

    // Setters privados con validación de invariantes
    private void setDireccionBilletera(String direccionBilletera) {
        if (direccionBilletera == null || direccionBilletera.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR. La dirección de billetera no puede ser nula ni vacía.");
        }
        if (!direccionBilletera.startsWith("0x") || direccionBilletera.trim().length() <= 2) {
            throw new IllegalArgumentException("ERROR. La dirección de billetera debe comenzar con '0x' y contener caracteres válidos.");
        }
        this.direccionBilletera = direccionBilletera;
    }

    private void setRedBlockchain(String redBlockchain) {
        if (redBlockchain == null || redBlockchain.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR. La red blockchain no puede ser nula ni vacía.");
        }
        this.redBlockchain = redBlockchain;
    }

    private void setGasFee(double gasFee) {
        if (gasFee < 0) {
            throw new IllegalArgumentException("ERROR. La comisión de red (gas fee) no puede ser negativa.");
        }
        this.gasFee = gasFee;
    }

    // Métodos del Template Method
    @Override
    protected boolean validar() {
        // Valida que la billetera empiece con 0x y que la red no esté vacía
        if (this.getDireccionBilletera() == null || !this.getDireccionBilletera().startsWith("0x") || this.getDireccionBilletera().trim().length() <= 2 || this.getRedBlockchain() == null || this.getRedBlockchain().trim().isEmpty()) {
            System.out.println("ERROR. Dirección de billetera inválida o red blockchain no especificada.");
            return false;
        }
        return true;
    }

    @Override
    protected boolean debitar() {
        // Regla de negocio cripto: la transacción solo es viable si el monto supera estrictamente la comisión de gas
        if (this.getMonto() <= this.getGasFee()) {
            System.out.println("ERROR. El monto de la transacción ($" + this.getMonto() + ") no alcanza a cubrir la comisión de red mínima ($" + this.getGasFee() + ").");
            return false;
        }
        // Simula la confirmación y minado en la blockchain
        System.out.println("Transferencia cripto confirmada en la red " + this.getRedBlockchain() + " desde " + this.getDireccionBilletera() + " por $" + this.getMonto() + " (Gas Fee descontado: $" + this.getGasFee() + ")");
        return true;
    }
}
