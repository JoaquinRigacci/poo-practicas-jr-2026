package ar.edu.unlu.poo.practica2.ejercicio02;

public class Pet {

    // Atributos
    private String microchipCode;
    private String name;
    private String species;
    private int age;

    // Constructor
    public Pet(String microchipCode, String name, String species, int age) {
        this.setMicrochipCode(microchipCode);
        this.setName(name);
        this.setSpecies(species);
        this.setAge(age);
    }

    // Getters
    public String getMicrochipCode() {
        return this.microchipCode;
    }

    public String getName() {
        return this.name;
    }

    public String getSpecies() {
        return this.species;
    }

    public int getAge() {
        return this.age;
    }

    // Setters
    public void setMicrochipCode(String microchipCode) {
        if(microchipCode != null && !microchipCode.trim().isEmpty()) {
            this.microchipCode = microchipCode;
        } else {
            throw new IllegalArgumentException("ERROR. No se ingreso el código microchip de la mascota.");
        }
    }

    public void setName(String name) {
        if(name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("ERROR. No se ingreso el nombre de la mascota.");
        }
    }

    public void setSpecies(String species) {
        if(species != null && !species.trim().isEmpty()) {
            this.species = species;
        } else {
            throw new IllegalArgumentException("ERROR. No se ingreso la especie de la mascota.");
        }
    }

    public void setAge(int age) {
        if(age >= 0) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("ERROR. No se ingreso la edad de la mascota.");
        }
    }

}
