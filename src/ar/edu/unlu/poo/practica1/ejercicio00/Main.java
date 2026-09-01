package ar.edu.unlu.poo.practica1.ejercicio00;

public class Main {
    public static void main(String[] args) {
        // 1. Caso feliz: Creamos una temperatura normal (26 °C)
        Temperatura unaTemperatura = new Temperatura(26);
        System.out.println("1er instancia creada con valor " + unaTemperatura.getCelsius());

        // 2. Control de excepciones (try-catch)
        Temperatura otraTemperatura = null;
        try {
            otraTemperatura = new Temperatura(-400); // Esto va a fallar (menor a -273.15)
            System.out.println("2da instancia creada " + otraTemperatura.getCelsius());
        } catch (IllegalArgumentException e) {
            // Se ejecuta este bloque cuando el try lanza el error
            System.out.println("Se ingreso un valor no valido");
            otraTemperatura = new Temperatura(-273.15); // Salvamos el error usando el cero absoluto
        }

        // 3. Conversión e impresión
        System.out.println("°C = " + unaTemperatura.getCelsius() + "; °F = " + unaTemperatura.aFahrenheit());

        // 4. Reportes de Ciudades
        ReporteMeteorologico unReporteDeLujan = new ReporteMeteorologico("Lujan", unaTemperatura);
        ReporteMeteorologico unReporteDeMercedes = new ReporteMeteorologico("San Andres de Giles", new Temperatura(15));

        System.out.println(unReporteDeLujan.mostrarReporte());
        System.out.println(unReporteDeMercedes.mostrarReporte());
    }
}
