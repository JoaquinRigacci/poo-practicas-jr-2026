package ar.edu.unlu.poo.practica2.ejercicio03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Curso {

    // Atributos de instancia
    private int codigo;
    private String nombre;
    private int cupoMax;
    private List<Inscripcion> inscripciones;

    // Atributo de clase
    private static int totalInscripciones = 0;

    // Constructor
    public Curso(int codigo, String nombre, int cupoMax) {
        this.setCodigo(codigo);
        this.setNombre(nombre);
        this.setCupoMax(cupoMax);
        this.inscripciones = new ArrayList<>();
    }

    // Metodos
    public void inscribirEstudiante(Estudiante estudiante) {
        if (estudiante == null) {
            throw new IllegalArgumentException("ERROR. No se ingreso el estudiante para inscribirlo.");
        } else if (isInscripto(estudiante)){
            throw new EstudianteYaInscriptoException("ERROR. El estudiante ya esta inscripto.");
        } else if (this.inscripciones.size() >= this.cupoMax) {
            throw new CupoExcedidoException("ERROR. El cupo de inscripciones ya llego a su máximo.");
        }  else {
            totalInscripciones++;
            var newInscripcion = new Inscripcion(estudiante, this);
            this.inscripciones.add(newInscripcion);
        }
    }

    private boolean isInscripto(Estudiante estudiante) {
        for (Inscripcion inscripcion : this.inscripciones) {
            if (inscripcion.getEstudiante().getLegajo() == estudiante.getLegajo()) {
                return true;
            }
        }
        return false;
    }

    // Getter
    public int getCodigo() {
        return this.codigo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getCupoMax() {
        return this.cupoMax;
    }

    public List<Inscripcion> getInscripciones() {
        return Collections.unmodifiableList(inscripciones);
    }

    public static int getTotalInscripciones() {
        return totalInscripciones;
    }

    // Setter
    public void setCodigo(int codigo) {
        if (codigo > 0) {
            this.codigo = codigo;
        } else {
            throw new IllegalArgumentException("ERROR. El código del curso debe ser mayor a 0.");
        }
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        } else {
            throw new IllegalArgumentException("ERROR. No se ingreso el nombre del curso.");
        }
    }

    public void setCupoMax(int cupoMax) {
        if(cupoMax > 0) {
            this.cupoMax = cupoMax;
        } else {
            throw new IllegalArgumentException("ERROR. El cupo máximo del curso debe ser mayor a 0.");
        }
    }
}
