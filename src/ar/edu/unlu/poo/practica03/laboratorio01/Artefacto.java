package ar.edu.unlu.poo.practica03.laboratorio01;

import java.util.Objects;

public class Artefacto {

    // Atributos
    private String nombre;
    private int poder;
    private String tipo;

    // Constructor
    public Artefacto(String nombre, int poder, String tipo) {
        this.setNombre(nombre);
        this.setPoder(poder);
        this.setTipo(tipo);
    }

    // Getter

    public String getNombre() {
        return this.nombre;
    }

    public int getPoder() {
        return this.poder;
    }

    public String getTipo() {
        return this.tipo;
    }

    // Setter
    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        } else {
            throw new IllegalArgumentException("ERROR. No se ingreso el nombre del artefacto.");
        }
    }

    public void setPoder(int poder) {
        if (poder >= 0) {
            this.poder = poder;
        } else {
            throw new IllegalArgumentException("ERROR. El poder del artefacto debe ser mayor o igual a 0.");
        }
    }

    public void setTipo(String tipo) {
        if (tipo != null && !tipo.trim().isEmpty()) {
            this.tipo = tipo;
        } else {
            throw new IllegalArgumentException("ERROR. No se ingreso el tipo del artefacto.");
        }
    }

    // Métodos
    // IGUALDAD Y HASHCODE (Para el correcto funcionamiento en HashSet)

    @Override
    public boolean equals(Object o) {
        // 1. ¿Apunta exactamente a la misma instancia en memoria?
        if (this == o) {
            return true;
        }

        // 2. ¿El objeto recibido es nulo o pertenece a otra clase?
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        // 3. Hacemos el casteo (moldeo) a la clase Artefacto
        Artefacto otro = (Artefacto) o;

        // 4. Comparamos los campos clave accediendo por sus getters (Estándar UNLu)
        return Objects.equals(this.getNombre(), otro.getNombre()) &&
                Objects.equals(this.getTipo(), otro.getTipo());
    }

    @Override
    public int hashCode() {
        // Generamos el código Hash utilizando los mismos campos que en equals()
        return Objects.hash(this.getNombre(), this.getTipo());
    }

    @Override
    public String toString() {
        return this.getNombre() + " [Tipo: " + this.getTipo() + ", Poder: " + this.getPoder() + "]";
    }

}
