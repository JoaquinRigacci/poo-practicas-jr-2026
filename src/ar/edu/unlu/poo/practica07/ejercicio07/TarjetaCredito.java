package ar.edu.unlu.poo.practica07.ejercicio07;

public class TarjetaCredito extends MetodoDePago implements Reembolsable, AuditableFiscalmente{

    // Atributos
    private String numeroTarjeta;
    private String cvv;
    private int cantCuotas;
    private double limiteDisponible;

    // Constructor
    public TarjetaCredito(String idTransaccion, double monto, String numeroTarjeta, String cvv, int cantCuotas, double limiteDisponible) {
        super(idTransaccion, monto);
        this.setNumeroTarjeta(numeroTarjeta);
        this.setCvv(cvv);
        this.setCantCuotas(cantCuotas);
        this.setLimiteDisponible(limiteDisponible);
    }

    // Getter
    private String getNumeroTarjeta() {
        return this.numeroTarjeta;
    }

    private String getCvv() {
        return this.cvv;
    }

    private int getCantCuotas() {
        return this.cantCuotas;
    }

    public double getLimiteDisponible() {
        return this.limiteDisponible;
    }

    // Setter
    private void setNumeroTarjeta(String numeroTarjeta) {
        if (numeroTarjeta == null || numeroTarjeta.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR. El numero de la tarjeta no puede ser nulo.");
        }
        this.numeroTarjeta = numeroTarjeta;
    }

    private void setCvv(String cvv) {
        if (cvv == null || cvv.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR. El cvv no puede ser nulo.");
        }
        this.cvv = cvv;
    }

    private void setCantCuotas(int cantCuotas) {
        if (cantCuotas < 1) {
            throw new IllegalArgumentException("ERROR. La cantidad de cuotas debe ser mayor o igual a 1.");
        }
        this.cantCuotas = cantCuotas;
    }

    private void setLimiteDisponible(double limiteDisponible) {
        if (limiteDisponible < 0) {
            throw new IllegalArgumentException("ERROR. El limite disponible debe ser mayor o igual a 0.");
        }
        this.limiteDisponible = limiteDisponible;
    }

    // Métodos
    @Override
    protected boolean validar() {
        if (this.numeroTarjeta.trim().length() != 16 || this.cvv.trim().length() != 3 || this.cantCuotas < 1) {
            System.out.println("ERROR. Alguno de estos 3 datos no cumplen con la normativa: " +
                    "Nro de Tarjeta, CVV, Cantidad de Cuotas.");
            return false;
        }
        return true;
    }

    @Override
    protected boolean debitar() {
        double montoFinal = this.getMonto();
        if (this.getCantCuotas() >= 2) {
            double porcentajeRecargo = 0.025 * (this.getCantCuotas() - 1);
            montoFinal = this.getMonto() * (1 + porcentajeRecargo);
        }
        if (montoFinal > this.getLimiteDisponible()) {
            return false;
        }
        this.setLimiteDisponible(this.getLimiteDisponible() - montoFinal);
        return true;
    }

    @Override
    public boolean procesarReembolso(double monto) {
        // 1. Validaciones de negocio: solo se reembolsa si la compra original fue exitosa
        // y el monto solicitado es positivo y no excede el monto original cobrado
        if (!this.isExitoso() || monto <= 0 || monto > this.getMonto()) {
            System.out.println("ERROR. No se puede procesar el reembolso para la transacción " + this.getIdTransaccion());
            return false;
        }

        // 2. Acreditamos el importe devuelto al límite disponible de la tarjeta
        this.setLimiteDisponible(this.getLimiteDisponible() + monto);
        System.out.println("Reembolso de $" + monto + " procesado con éxito para la tarjeta.");
        return true;
    }

    @Override
    public String generarComprobanteFiscal() {
        double iva = this.getMonto() * 0.21;
        String ultimos4 = this.getNumeroTarjeta().substring(12);
        return "COMPROBANTE FISCAL - Transacción: " + this.getIdTransaccion()
                + " | Tarjeta: **** **** **** " + ultimos4
                + " | Monto Neto: $" + this.getMonto()
                + " | IVA (21%): $" + iva
                + " | Total Facturado: $" + (this.getMonto() + iva);
    }
}
