package ar.edu.unlu.poo.practica2.ejercicio02;

public class Veterinarian {

    // Atributos
    private String professionalLicense;
    private String name;

    // Constructor
    public Veterinarian(String professionalLicense, String name) {
        this.setProfessionalLicense(professionalLicense);
        this.setName(name);
    }

    // Getters
    public String getProfessionalLicense() {
        return this.professionalLicense;
    }

    public String getName() {
        return this.name;
    }

    // Setters
    public void setProfessionalLicense(String professionalLicense) {
        if (professionalLicense != null && !professionalLicense.trim().isEmpty()) {
            this.professionalLicense = professionalLicense;
        } else {
            throw new IllegalArgumentException("ERROR. No se ingreso la matrícula profesional del veterinario.");
        }
    }

    public void setName(String name) {
        if(name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("ERROR. No se ingreso el nombre del veterinario.");
        }
    }

}
