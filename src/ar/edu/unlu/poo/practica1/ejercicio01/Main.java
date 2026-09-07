package ar.edu.unlu.poo.practica1.ejercicio01;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Probando Ejercicio 1: El Automóvil y su Motor ===");

        try {
            // 1. Instanciamos un motor impecable (1.6 litros y eficiencia de 0.2)
            Motor miMotor = new Motor(1.6, 0.2);

            // 2. Instanciamos un viaje de 250 km asociándole ese motor
            Viaje miViaje = new Viaje(250.0, miMotor);

            // 3. Le pedimos al viaje el consumo (él delegará el cálculo matemático al motor)
            double consumoTotal = miViaje.obtenerConsumoVehiculo();

            // 4. Mostramos los resultados en consola utilizando los getters públicos
            System.out.printf("Datos del Motor: Cilindrada %.1f Litros | Eficiencia: %.2f%n",
                    miMotor.getCilindradaEnLitros(), miMotor.getFactorDeEficiencia());
            System.out.printf("Datos del Viaje: Distancia a recorrer %.2f km%n",
                    miViaje.getDistanciaEnKm());
            System.out.printf("El consumo estimado de combustible es de: %.2f litros.%n",
                    consumoTotal);

        } catch (IllegalArgumentException e) {
            System.out.println("Error inesperado en la creación: " + e.getMessage());
        }

        System.out.println("\n=== Probando el Guardián (Validación del Motor) ===");
        try {
            // Intentamos crear un motor con cilindrada inválida (0 litros)
            System.out.println("Intentando crear motor de 0.0 Litros...");
            Motor motorRoto = new Motor(0.0, 0.5);

        } catch (IllegalArgumentException e) {
            // El bloque catch captura la excepción arrojada por tu setter
            System.out.println("¡Excelente! El guardián funcionó. Mensaje: " + e.getMessage());
        }
    }
}
