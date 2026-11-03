package ar.edu.unlu.poo.practica07.ejercicio02;

// Si están en el paquete de la práctica anterior, importalas:
// import ar.edu.unlu.poo.practica07.ejercicio00.*;

import ar.edu.unlu.poo.practica07.ejercicio00.Camisa;
import ar.edu.unlu.poo.practica07.ejercicio00.Remera;

public class Main {
    public static void main(String[] args) {
        System.out.println("==========================================================");
        System.out.println(" TIENDA DE ROPA: VENTAS Y ESTRATEGIAS DE PAGO");
        System.out.println("==========================================================\n");

        // 1. Instanciamos la Venta
        Venta venta = new Venta();

        // 2. Usamos directamente las subclases concretas (con sus precios de lista)
        Remera remera = new Remera(5000.0);
        Camisa camisa = new Camisa(15000.0, true); // O pasándole si es manga larga según tu constructor

        venta.agregarPrenda(remera);
        venta.agregarPrenda(camisa);

        // 3. Monto base acumulado (5000 + 15000 = 20000)
        double montoBase = venta.calcularMontoBase();
        System.out.println("--- MONTO BASE ---");
        System.out.printf("Monto base total de las prendas: $%.2f%n%n", montoBase);

        // 4. Medios de pago que programaste
        MedioDePago pagoEfectivo = new Efectivo();
        MedioDePago pagoTarjeta = new TarjetaCredito(500.0); // recargo posnet
        MedioDePago pagoMP = new MercadoPago();

        // 5. Facturamos polimórficamente
        System.out.println("--- FACTURACIÓN SEGÚN MEDIO DE PAGO ---");
        System.out.printf("Total en Efectivo (10%% desc.): $%.2f%n", venta.facturar(pagoEfectivo));
        System.out.printf("Total con Tarjeta (5%% + $500): $%.2f%n", venta.facturar(pagoTarjeta));
        System.out.printf("Total con MercadoPago (sin recargo): $%.2f%n", venta.facturar(pagoMP));

        System.out.println("\n==========================================================");
        System.out.println(" ¡PRUEBA EXITOSA!");
        System.out.println("==========================================================");
    }
}