package ar.edu.unlu.poo.practica08.ejercicio04;

public class Paciente {

    // Atributos
    private String historiaClinica; // identificador alfanumérico del paciente
    private int frecuenciaCardiaca; // frecuencia cardíaca medida en latidos por minuto
    private double saturacionOxigeno; // porcentaje de saturación de oxígeno en sangre
    private int escalaDolor; // nivel subjetivo de dolor percibido en una escala de 1 a 10

    // Constructor
    public Paciente(String historiaClinica, int frecuenciaCardiaca, double saturacionOxigeno, int escalaDolor) {
        this.setHistoriaClinica(historiaClinica);
        this.setFrecuenciaCardiaca(frecuenciaCardiaca);
        this.setSaturacionOxigeno(saturacionOxigeno);
        this.setEscalaDolor(escalaDolor);
    }

    // Getter
    public String getHistoriaClinica() {
        return this.historiaClinica;
    }

    public int getFrecuenciaCardiaca() {
        return this.frecuenciaCardiaca;
    }

    public double getSaturacionOxigeno() {
        return this.saturacionOxigeno;
    }

    public int getEscalaDolor() {
        return this.escalaDolor;
    }

    // Setter
    private void setHistoriaClinica(String historiaClinica) {
        if (historiaClinica == null || historiaClinica.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR. La historia clínica no puede ser nula.");
        }
        this.historiaClinica = historiaClinica;
    }

    private void setFrecuenciaCardiaca(int frecuenciaCardiaca) {
        if (frecuenciaCardiaca <= 0) {
            throw new IllegalArgumentException("ERROR. La frecuencia cardíaca debe ser mayor a 0.");
        }
        this.frecuenciaCardiaca = frecuenciaCardiaca;
    }

    private void setSaturacionOxigeno(double saturacionOxigeno) {
        if (saturacionOxigeno <= 0 || saturacionOxigeno > 100.0) {
            throw new IllegalArgumentException("ERROR. El porcentaje de saturación de oxígeno debe estar entre 0 y 100.");
        }
        this.saturacionOxigeno = saturacionOxigeno;
    }

    private void setEscalaDolor(int escalaDolor) {
        if (escalaDolor < 1 || escalaDolor > 10) {
            throw new IllegalArgumentException("ERROR. La escala de dolor debe ser entre 1 y 10.");
        }
        this.escalaDolor = escalaDolor;
    }
}
