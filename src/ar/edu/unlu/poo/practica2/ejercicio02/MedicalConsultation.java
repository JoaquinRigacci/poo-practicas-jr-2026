package ar.edu.unlu.poo.practica2.ejercicio02;

public class MedicalConsultation {

    // Atributos
    private Pet pet;
    private Veterinarian veterinarian;
    private String diagnostic;
    private double attentionCost;

    // Constructor
    public MedicalConsultation(Pet pet, Veterinarian veterinarian, String diagnostic, double attentionCost) {
        this.setPet(pet);
        this.setVeterinarian(veterinarian);
        this.setDiagnostic(diagnostic);
        this.setAttentionCost(attentionCost);
    }

    // Getters
    public Pet getPet() {
        return this.pet;
    }

    public Veterinarian getVeterinarian() {
        return this.veterinarian;
    }

    public String getDiagnostic() {
        return this.diagnostic;
    }

    public double getAttentionCost() {
        return this.attentionCost;
    }

    // Setters
    private void setPet(Pet pet) {
        if (pet != null) {
            this.pet = pet;
        } else {
            throw new IllegalArgumentException("ERROR. No se ingreso a la mascota en la consulta médica.");
        }
    }

    private void setVeterinarian(Veterinarian veterinarian) {
        if (veterinarian != null) {
            this.veterinarian = veterinarian;
        } else {
            throw new IllegalArgumentException("ERROR. No se ingreso al veterinario en la consulta médica.");
        }
    }

    private void setDiagnostic(String diagnostic) {
        if (diagnostic != null && !diagnostic.trim().isEmpty()) {
            this.diagnostic = diagnostic;
        } else {
            throw new IllegalArgumentException("ERROR. No se ingreso el diagnostico de la consulta médica.");
        }
    }

    private void setAttentionCost(double attentionCost) {
        if (attentionCost > 0) {
            this.attentionCost = attentionCost;
        } else {
            throw new InvalidCostException("ERROR. EL costo de la atención debe ser mayor a 0.");
        }
    }

}
