package ar.edu.unlu.poo.practica2.ejercicio03;

import java.time.LocalDate;

public class Inscripcion {

    // Atributos
    private Estudiante estudiante;
    private Curso curso;
    private LocalDate fechaInscripcion;

    // Constructor que recibe al Estudiante y al Curso
    public Inscripcion(Estudiante estudiante, Curso curso) {
        this.setEstudiante(estudiante);
        this.setCurso(curso);
        // Registra automáticamente la fecha del día
        this.fechaInscripcion = LocalDate.now();
    }

    // Getter
    public Estudiante getEstudiante() {
        return this.estudiante;
    }

    public Curso getCurso() {
        return this.curso;
    }

    public LocalDate getFechaInscripcion() {
        return this.fechaInscripcion;
    }

    // Setter
    private void setEstudiante(Estudiante estudiante){
        if (estudiante != null) {
            this.estudiante = estudiante;
        } else {
            throw new IllegalArgumentException("ERROR. No se ingreso el estudiante para la inscripción.");
        }
    }

    private void setCurso(Curso curso){
        if (curso != null) {
            this.curso = curso;
        } else {
            throw new IllegalArgumentException("ERROR. No se ingreso el curso para la inscripción.");
        }
    }
}
