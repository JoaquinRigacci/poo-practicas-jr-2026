package ar.edu.unlu.poo.practica1.ejercicio00;

public class ReporteMeteorologico {
    private Temperatura unaTemperatura;
    private String ciudad;

    public ReporteMeteorologico(String unaCiudad, Temperatura unValorDeTemperatura) {
        unaTemperatura = unValorDeTemperatura;
        ciudad = unaCiudad;
    }

    public String mostrarReporte() {
        return "Reporte de la ciudad " + ciudad + ": " + " Temperatura actual: " + unaTemperatura.getCelsius();
    }
}
