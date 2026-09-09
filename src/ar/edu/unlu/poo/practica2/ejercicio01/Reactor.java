package ar.edu.unlu.poo.practica2.ejercicio01;

public class Reactor {

    // 1. Atributos de instancia (propios de cada reactor individual)
    private String codigoIdentificador;
    private Double temperaturaActual;
    private boolean estadoAlerta;

    // 2. Atributos de clase (globales y compartidos por TODOS los reactores)
    private static Double limiteGlobalDeSeguridad = 1000.0;
    private static int contadorGlobalDeAlertas = 0;


    // Constructor
    public Reactor(String codigoIdentificador, Double temperaturaActual) {
        this.setCodigoIdentificador(codigoIdentificador);
        this.setEstadoAlerta(false);
        this.actualizarTemperatura(temperaturaActual);
    }


    // Métodos
    public void actualizarTemperatura(Double nuevaTemperatura){
        if (nuevaTemperatura == null) {
            throw new IllegalArgumentException("ERROR. No se pudo ingresar la temperatura.");
        }
        this.setTemperaturaActual(nuevaTemperatura);
        if (nuevaTemperatura > limiteGlobalDeSeguridad) {
            if (!this.isEstadoAlerta()) {
                this.setEstadoAlerta(true);
                incrementarContadorAlertas();
            }
            throw new TemperaturaCriticaException("ERROR. La temperatura paso el limite global de seguridad (" + getLimiteGlobalDeSeguridad() + ").");
        }
    }

    private static void incrementarContadorAlertas() {
        contadorGlobalDeAlertas += 1;
    }


    // Getter
    public String getCodigoIdentificador() {
        return this.codigoIdentificador;
    }

    public Double getTemperaturaActual() {
        return this.temperaturaActual;
    }

    // Convención estándar para booleanos: is... en lugar de get... [cite: 107, 187]
    public boolean isEstadoAlerta() {
        return this.estadoAlerta; // [cite: 107]
    }

    public static Double getLimiteGlobalDeSeguridad() {
        return limiteGlobalDeSeguridad;
    }

    public static int getContadorGlobalDeAlertas() {
        return contadorGlobalDeAlertas;
    }

    // Setter
    public void setCodigoIdentificador(String codigoIdentificador) {
        if (codigoIdentificador != null && !codigoIdentificador.isEmpty()) {
            this.codigoIdentificador = codigoIdentificador;
        } else {
            throw new IllegalArgumentException("ERROR. No se pudo ingresar el codigo identificador.");
        }
    }

    private void setTemperaturaActual(Double temperaturaActual) {
        if (temperaturaActual >= -273.15) {
            this.temperaturaActual = temperaturaActual;
        } else {
            throw new IllegalArgumentException("ERROR. La temperatura no puede ser menor a -273.15");
        }
    }

    private void setEstadoAlerta(boolean estadoAlerta) {
        this.estadoAlerta = estadoAlerta;
    }

    public static void setLimiteGlobalDeSeguridad(Double limite) {
        if (limite != null && limite >= -273.15) {
        limiteGlobalDeSeguridad = limite;
        }
    }

}
