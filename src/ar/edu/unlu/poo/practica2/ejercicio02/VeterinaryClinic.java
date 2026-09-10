package ar.edu.unlu.poo.practica2.ejercicio02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VeterinaryClinic {

    // Atributos
    private List<Pet> pets;
    private List<MedicalConsultation> medicalConsultations;

    // Constructor
    public VeterinaryClinic() {
        this.pets = new ArrayList<>();
        this.medicalConsultations = new ArrayList<>();
    }

    // Métodos
    public void registerPet(Pet pet) {
        if (pet == null) {
            throw new IllegalArgumentException("ERROR. No se ingreso la mascota a registrar.");
        } else if (containsPet(pet.getMicrochipCode())){
            throw new IllegalArgumentException("ERROR. La mascota ya se encuentra registrada.");
        } else {
            this.pets.add(pet);
        }
    }

    public void recordConsultation(Pet pet, Veterinarian veterinarian, String diagnostic, double attentionCost) {
        // Validamos que la mascota esté previamente registrada en la clínica
        if (pet == null || !this.containsPet(pet.getMicrochipCode())) {
            throw new PetNotFoundException("ERROR. La mascota no se encuentra registrada en la clínica.");
        }

        MedicalConsultation newMedicalConsultation = new MedicalConsultation(pet, veterinarian, diagnostic, attentionCost);
        this.medicalConsultations.add(newMedicalConsultation);
    }

    public List<MedicalConsultation> getConsultationsByPet(String microchipCode) {
        if (microchipCode == null || microchipCode.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR. No se ingresó el código microchip para buscar las consultas.");
        }

        if (!this.containsPet(microchipCode)) {
            throw new PetNotFoundException("ERROR. La mascota con microchip " + microchipCode + " no se encuentra registrada.");
        }

        // Filtrado de las consultas correspondientes a esa mascota
        List<MedicalConsultation> petConsultations = new ArrayList<>();
        for (MedicalConsultation mc : this.medicalConsultations) {
            if (mc.getPet().getMicrochipCode().equalsIgnoreCase(microchipCode)) {
                petConsultations.add(mc);
            }
        }

        return Collections.unmodifiableList(petConsultations);
    }

    // Metodo para verificar si ya esta registrado el pet
    private boolean containsPet(String microchipCode) {
        for (Pet p : this.pets) {
            if(p.getMicrochipCode().equalsIgnoreCase(microchipCode)) {
                return true;
            }
        }
        return false;
    }


    // Getters
    public List<Pet> getPets() {
        return Collections.unmodifiableList(this.pets);
    }

    public List<MedicalConsultation> getMedicalConsultations() {
        return Collections.unmodifiableList(this.medicalConsultations);
    }

}
