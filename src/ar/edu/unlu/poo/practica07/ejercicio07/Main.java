package ar.edu.unlu.poo.practica07.ejercicio07;

public class Main {

    public static void main(String[] args) {
        System.out.println("================================================================================");
        System.out.println("     SISTEMA DE PAGOS Y PASARELAS FINANCIERAS (UNLu - PRÁCTICA 07 - EJ. 07)     ");
        System.out.println("================================================================================\n");

        // 1. Instanciamos el orquestador desacoplado
        ProcesadorVentas procesador = new ProcesadorVentas();

        // 2. Creamos las pasarelas concretas
        // Tarjeta con $50.000 de límite, compra de $10.000 en 3 cuotas (recargo del 5.0% = $10.500 final)
        TarjetaCredito tarjetaValida = new TarjetaCredito(
                "TX-TARJ-001", 10000.0, "1234567812345678", "123", 3, 50000.0);

        // Tarjeta con límite insuficiente ($2.000 disponible para una compra de $5.000 en 1 cuota)
        TarjetaCredito tarjetaSinLimite = new TarjetaCredito(
                "TX-TARJ-002", 5000.0, "9876543298765432", "456", 1, 2000.0);

        // Transferencia bancaria válida
        TransferenciaBancaria transferencia = new TransferenciaBancaria(
                "TX-BANC-001", 25000.0, "0140000000000012345678", "Banco Nación");

        // Criptomoneda viable ($150 de monto, supera el gas fee de $15)
        Criptomoneda criptoValida = new Criptomoneda(
                "TX-CRIP-001", 150.0, "0x71C84183204CBD8983", "Ethereum", 15.0);

        // Criptomoneda inviable económicamente ($10 de monto, inferior al gas fee de $25)
        Criptomoneda criptoInviable = new Criptomoneda(
                "TX-CRIP-002", 10.0, "0x3A9F11B456CDE88120", "Ethereum", 25.0);

        // -----------------------------------------------------------------------------
        // CASO 1: PROCESAMIENTO POLIMÓRFICO DE COBROS (TEMPLATE METHOD)
        // -----------------------------------------------------------------------------
        System.out.println(">>> 1. PROCESAMIENTO DE COBROS");
        System.out.println("--------------------------------------------------------------------------------");

        probarCobro(procesador, tarjetaValida, "Tarjeta en 3 cuotas (Límite inicial: $50.000)");
        System.out.println("Límite restante en tarjeta: $" + tarjetaValida.getLimiteDisponible() + "\n");

        probarCobro(procesador, tarjetaSinLimite, "Tarjeta sin límite suficiente (Límite: $2.000)");
        System.out.println("Límite restante en tarjeta: $" + tarjetaSinLimite.getLimiteDisponible() + "\n");

        probarCobro(procesador, transferencia, "Transferencia bancaria Banco Nación");
        System.out.println();

        probarCobro(procesador, criptoValida, "Cripto viable en Ethereum (Monto: $150, Gas: $15)");
        System.out.println();

        probarCobro(procesador, criptoInviable, "Cripto inviable (Monto: $10, Gas: $25)");
        System.out.println();

        // -----------------------------------------------------------------------------
        // CASO 2: AUDITORÍA FISCAL (INTERFAZ AuditableFiscalmente)
        // -----------------------------------------------------------------------------
        System.out.println("\n>>> 2. AUDITORÍA FISCAL Y EMISIÓN DE COMPROBANTES CON IVA (21%)");
        System.out.println("--------------------------------------------------------------------------------");

        System.out.println(procesador.auditarOperacion(tarjetaValida));
        System.out.println(procesador.auditarOperacion(transferencia));

        // -----------------------------------------------------------------------------
        // CASO 3: GESTIÓN DE REEMBOLSOS (INTERFAZ Reembolsable)
        // -----------------------------------------------------------------------------
        System.out.println("\n>>> 3. GESTIÓN DE REEMBOLSOS Y CONTRACARGOS");
        System.out.println("--------------------------------------------------------------------------------");

        System.out.println("Límite antes del reembolso: $" + tarjetaValida.getLimiteDisponible());
        boolean reembolsoExitoso = procesador.gestionarDevolucion(tarjetaValida, 5000.0);
        System.out.println("¿Reembolso procesado?: " + reembolsoExitoso);
        System.out.println("Límite luego del reembolso de $5.000: $" + tarjetaValida.getLimiteDisponible() + "\n");

        boolean reembolsoTransferencia = procesador.gestionarDevolucion(transferencia, 25000.0);
        System.out.println("¿Reembolso bancario procesado?: " + reembolsoTransferencia + "\n");

        // -----------------------------------------------------------------------------
        // CASO 4: SEGURIDAD DE TIPOS EN COMPILACIÓN (LSP / ISP)
        // -----------------------------------------------------------------------------
        System.out.println(">>> 4. DEMOSTRACIÓN DE SEGURIDAD ESTÁTICA DE TIPOS (LSP / ISP)");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("El diseño previene errores en tiempo de compilación:");
        System.out.println(" - La línea 'procesador.gestionarDevolucion(criptoValida, 50.0);' NO COMPILA");
        System.out.println("   porque Criptomoneda no implementa la interfaz Reembolsable.");
        System.out.println(" - La línea 'procesador.auditarOperacion(criptoValida);' NO COMPILA");
        System.out.println("   porque Criptomoneda no implementa AuditableFiscalmente.");

        // -----------------------------------------------------------------------------
        // RESUMEN HISTÓRICO
        // -----------------------------------------------------------------------------
        System.out.println("\n================================================================================");
        System.out.println("Total de transacciones registradas en el procesador: " + procesador.getTransacciones().size());
        System.out.println("================================================================================");
    }

    private static void probarCobro(ProcesadorVentas procesador, MetodoDePago pago, String descripcion) {
        System.out.println("Intentando cobrar: " + descripcion);
        boolean resultado = procesador.procesarCobro(pago);
        System.out.println("Resultado: " + (resultado ? "APROBADO [EXITOSO]" : "RECHAZADO [FALLIDO]")
                + " | Estado interno exitoso: " + pago.isExitoso());
    }
}