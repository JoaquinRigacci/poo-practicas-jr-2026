package ar.edu.unlu.poo.practica02.ejercicio02;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== INICIANDO SISTEMA DE LA CLÍNICA VETERINARIA VETCARE ===");

        // 1. Instanciamos la clínica veterinaria
        VeterinaryClinic clinic = new VeterinaryClinic();

        // 2. Creamos mascotas
        Pet pet1 = new Pet("MC-001", "Nelson", "Perro", 7);
        Pet pet2 = new Pet("MC-002", "Michina", "Gato", 7);
        Pet pet3 = new Pet("MC-003", "Ramón", "Perro", 2);

        // 3. Creamos veterinarios
        Veterinarian vet1 = new Veterinarian("MP-1020", "Dra. Mia Roth");
        Veterinarian vet2 = new Veterinarian("MP-3040", "Dr. Joaquin Rigacci");

        System.out.println("\n--- 1. REGISTRO DE MASCOTAS ---");
        try {
            clinic.registerPet(pet1);
            clinic.registerPet(pet2);
            System.out.println("✅ Mascotas '" + pet1.getName() + "' y '" + pet2.getName() + "' registradas con éxito.");
            System.out.println("Total de mascotas en la clínica: " + clinic.getPets().size());
        } catch (IllegalArgumentException e) {
            System.err.println("❌ " + e.getMessage());
        }

        System.out.println("\n--- 2. REGISTRO DE CONSULTAS MÉDICAS ---");
        try {
            // Registramos consultas válidas para Firulais (MC-001)
            clinic.recordConsultation(pet1, vet1, "Vacunación antirrábica anual y chequeo general.", 12500.0);
            clinic.recordConsultation(pet1, vet2, "Limpieza dental y revisión de oídos.", 18000.0);

            // Registramos consulta válida para Michi (MC-002)
            clinic.recordConsultation(pet2, vet1, "Desparasitación y control de peso.", 9500.0);

            System.out.println("✅ Consultas médicas registradas con éxito.");
            System.out.println("Total de consultas globales en la clínica: " + clinic.getMedicalConsultations().size());
        } catch (RuntimeException e) {
            System.err.println("❌ " + e.getMessage());
        }

        System.out.println("\n--- 3. CONSULTAR HISTORIAL CLÍNICO DE " + pet1.getName().toUpperCase() + " (" + pet1.getMicrochipCode() + ") ---");
        try {
            List<MedicalConsultation> nelsonConsultations = clinic.getConsultationsByPet(pet1.getMicrochipCode());
            System.out.println("Historial de consultas de " + pet1.getName() + " (" + pet1.getMicrochipCode() + "):");

            for (MedicalConsultation mc : nelsonConsultations) {
                System.out.println(" -> Atendido por: " + mc.getVeterinarian().getName() +
                        " | Diagnóstico: " + mc.getDiagnostic() +
                        " | Costo: $" + mc.getAttentionCost());
            }
        } catch (PetNotFoundException e) {
            System.err.println("❌ " + e.getMessage());
        }

        System.out.println("\n==================================================");
        System.out.println("=== PRUEBAS DE EXCEPCIONES Y REGLAS DE NEGOCIO ===");
        System.out.println("==================================================");

        // PRUEBA A: Intentar registrar una mascota con un microchip ya existente
        System.out.println("\n[Prueba A] Intentando registrar mascota duplicada (" + pet1.getMicrochipCode() + ")...");
        try {
            Pet petDuplicate = new Pet("MC-001", "Nelson", "Perro", 7);
            clinic.registerPet(petDuplicate);
        } catch (IllegalArgumentException e) {
            System.out.println("✅ Excepción capturada correctamente: " + e.getMessage());
        }

        // PRUEBA B: Intentar registrar una consulta para una mascota NO registrada en la clínica
        System.out.println("\n[Prueba B] Intentando registrar consulta para una mascota no registrada en la clínica ("+ pet3.getName() +" "+ pet3.getMicrochipCode() +")...");
        try {
            clinic.recordConsultation(pet3, vet1, "Consulta de urgencia.", 15000.0);
        } catch (PetNotFoundException e) {
            System.out.println("✅ Excepción capturada correctamente: " + e.getMessage());
        }

        // PRUEBA C: Intentar registrar una consulta con un costo inválido (<= 0)
        System.out.println("\n[Prueba C] Intentando registrar consulta con costo $0...");
        try {
            clinic.recordConsultation(pet1, vet1, "Consulta gratuita de control.", 0.0);
        } catch (InvalidCostException e) {
            System.out.println("✅ Excepción capturada correctamente: " + e.getMessage());
        }

        // PRUEBA D: Buscar consultas de una mascota inexistente
        System.out.println("\n[Prueba D] Buscando consultas de un microchip inexistente (MC-999)...");
        try {
            clinic.getConsultationsByPet("MC-999");
        } catch (PetNotFoundException e) {
            System.out.println("✅ Excepción capturada correctamente: " + e.getMessage());
        }

        System.out.println("\n=== FIN DE LA EJECUCIÓN ===");
    }
}