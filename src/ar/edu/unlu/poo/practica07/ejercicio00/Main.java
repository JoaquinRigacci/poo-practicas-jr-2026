package ar.edu.unlu.poo.practica07.ejercicio00;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println(" PRUEBA DE PRENDAS, TARJETAS Y CONJUNTOS (POO)");
        System.out.println("==================================================\n");

        // 1. Creación de Tarjetas
        Tarjeta tarjetaEstandar = new Tarjeta();
        Tarjeta tarjetaDorada = new TarjetaDorada();

        // 2. Creación de Prendas Individuales
        Remera remera1 = new Remera(12000.0);
        Remera remera2 = new Remera(15000.0);
        Camisa camisaMangaLarga = new Camisa(25000.0, true);
        Sweater sweaterLana = new Sweater(35000.0);

        System.out.println("--- 1. PROBANDO PRENDAS INDIVIDUALES ---");
        System.out.println("Remera 1 - Precio Lista: $" + remera1.calcularPrecio());
        System.out.println("Remera 1 - Con Tarjeta Estándar: $" + remera1.calcularPrecio(tarjetaEstandar));
        System.out.println("Remera 1 - Con Tarjeta Dorada (15% off): $" + remera1.calcularPrecio(tarjetaDorada));
        System.out.println();
        System.out.println("Camisa (Manga Larga: " + camisaMangaLarga.isMangaLarga() + ") - Precio Lista: $" + camisaMangaLarga.calcularPrecio());
        System.out.println("Sweater - Precio Lista: $" + sweaterLana.calcularPrecio());
        System.out.println();

        // 3. Creación de Conjuntos (Promociones)
        System.out.println("--- 2. PROBANDO CONJUNTOS (PROMOCIONES) ---");

        // Conjunto 2x1: Remera1 ($12.000) + Sweater ($35.000) -> Debería cobrar solo el Sweater ($35.000)
        Conjunto dosPorUno = new ConjuntoDosPorUno(remera1, sweaterLana);
        System.out.println("Conjunto 2x1 (Remera $12.000 + Sweater $35.000):");
        System.out.println(" - Precio Base (Paga la más cara): $" + dosPorUno.calcularPrecio());
        System.out.println(" - Precio con Tarjeta Dorada: $" + dosPorUno.calcularPrecio(tarjetaDorada));
        System.out.println();

        // Conjunto con Descuento del 20%: Remera2 ($15.000) + Camisa ($25.000) = $40.000 total -> Con 20% off = $32.000
        Conjunto conDescuento = new ConjuntoConDescuento(remera2, camisaMangaLarga, 20.0);
        System.out.println("Conjunto con 20% Descuento (Remera $15.000 + Camisa $25.000 = $40.000 total):");
        System.out.println(" - Precio Base con 20% off: $" + conDescuento.calcularPrecio());
        System.out.println(" - Precio con Tarjeta Dorada (descuento extra): $" + conDescuento.calcularPrecio(tarjetaDorada));
        System.out.println();

        // 4. Polimorfismo: Carrito de Compras con tipo homogéneo `Vendible`
        System.out.println("--- 3. POLIMORFISMO EN EL CARRITO DE COMPRAS ---");
        List<Vendible> carrito = new ArrayList<>();
        carrito.add(remera1); // Vendible (Prenda suelta)
        carrito.add(camisaMangaLarga); // Vendible (Prenda suelta)
        carrito.add(dosPorUno); // Vendible (Conjunto 2x1)
        carrito.add(conDescuento); // Vendible (Conjunto con Descuento)

        double totalEfectivo = 0;
        double totalTarjetaDorada = 0;
        int numeroItem = 1;

        for (Vendible item : carrito) {
            double precioItemEfectivo = item.calcularPrecio();
            double precioItemTarjeta = item.calcularPrecio(tarjetaDorada);

            System.out.printf("Item #%d [%s]:%n", numeroItem, item.getClass().getSimpleName());
            System.out.printf(" > Precio Lista/Efectivo: $%.2f%n", precioItemEfectivo);
            System.out.printf(" > Precio con Tarjeta Dorada: $%.2f%n", precioItemTarjeta);

            totalEfectivo += precioItemEfectivo;
            totalTarjetaDorada += precioItemTarjeta;
            numeroItem++;
        }

        System.out.println("\n==================================================");
        System.out.printf("TOTAL DEL CARRITO EN EFECTIVO: $%.2f%n", totalEfectivo);
        System.out.printf("TOTAL DEL CARRITO CON TARJETA DORADA: $%.2f%n", totalTarjetaDorada);
        System.out.println("==================================================");
    }
}