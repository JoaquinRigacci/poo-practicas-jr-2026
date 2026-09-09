package ar.edu.unlu.poo.practica2.ejercicio01;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SIMULACIÓN DE LA PLANTA DE ENERGÍA NUCLEAR ===");

        // 1. Creamos el Tablero de Control
        TableroControl tablero = new TableroControl();

        // 2. Creamos los reactores de la planta
        Reactor r1 = new Reactor("R-01", 350.0);
        Reactor r2 = new Reactor("R-02", 420.0);
        Reactor r3 = new Reactor("R-03", 500.0);

        // 3. Agregamos los reactores al tablero
        tablero.agregarReactor(r1);
        tablero.agregarReactor(r2);
        tablero.agregarReactor(r3);

        System.out.println("Reactores asignados al tablero: " + tablero.getReactores().size());
        System.out.println("Límite global de seguridad: " + Reactor.getLimiteGlobalDeSeguridad() + " °C");
        System.out.println("Alertas globales iniciales: " + Reactor.getContadorGlobalDeAlertas());
        System.out.println("--------------------------------------------------");

        // 4. Actualización normal de temperatura (rango seguro)
        System.out.println("Actualizando temperatura de R-01 a 650.0 °C...");
        r1.actualizarTemperatura(650.0);
        System.out.println("R-01 Temperatura actual: " + r1.getTemperaturaActual() + " °C | Alerta: " + r1.isEstadoAlerta());
        System.out.println("--------------------------------------------------");

        // 5. Actualización que supera el límite de seguridad (lanza excepción)
        System.out.println("Actualizando temperatura de R-02 a 1200.0 °C (Límite superado)...");
        try {
            r2.actualizarTemperatura(1200.0);
        } catch (TemperaturaCriticaException e) {
            System.out.println("EXCEPCIÓN CAPTURADA: " + e.getMessage());
        }

        // 6. Verificación de estado posterior a la alerta
        System.out.println("R-02 Temperatura actual: " + r2.getTemperaturaActual() + " °C | Alerta: " + r2.isEstadoAlerta());
        System.out.println("Contador global de alertas de la planta: " + Reactor.getContadorGlobalDeAlertas());
        System.out.println("--------------------------------------------------");

        // 7. Segunda actualización sobre R-02 (ya estaba en alerta)
        System.out.println("Actualizando nuevamente R-02 a 1300.0 °C...");
        try {
            r2.actualizarTemperatura(1300.0);
        } catch (TemperaturaCriticaException e) {
            System.out.println("EXCEPCIÓN CAPTURADA: " + e.getMessage());
        }

        // El contador no vuelve a incrementarse porque R-02 ya estaba en alerta previa
        System.out.println("Contador global de alertas (se mantiene en 1): " + Reactor.getContadorGlobalDeAlertas());
        System.out.println("--------------------------------------------------");

        // 8. Sobrecalentamiento de otro reactor (R-03)
        System.out.println("Actualizando temperatura de R-03 a 1050.0 °C...");
        try {
            r3.actualizarTemperatura(1050.0);
        } catch (TemperaturaCriticaException e) {
            System.out.println("EXCEPCIÓN CAPTURADA: " + e.getMessage());
        }

        System.out.println("R-03 Alerta: " + r3.isEstadoAlerta());
        System.out.println("Contador global de alertas de la planta (debe ser 2): " + Reactor.getContadorGlobalDeAlertas());
        System.out.println("==================================================");
    }
}
