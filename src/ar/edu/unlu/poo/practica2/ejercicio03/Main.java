package ar.edu.unlu.poo.practica2.ejercicio03;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== SISTEMA DE CURSOS E INSCRIPCIONES (UNLu) ===");

        // 1. Instanciamos los cursos (POO tiene un cupo reducido de 2 para probar el límite fácilmente)
        Curso cursoPOO = new Curso(101, "Programación Orientada a Objetos", 2);
        Curso cursoBD = new Curso(102, "Bases de Datos I", 3);

        // 2. Creamos los estudiantes
        Estudiante est1 = new Estudiante(1001, "Joaquín González");
        Estudiante est2 = new Estudiante(1002, "María Rodríguez");
        Estudiante est3 = new Estudiante(1003, "Lucas Martínez");

        System.out.println("\n--- 1. INSCRIPCIONES EXITOSAS ---");
        try {
            // Inscribimos en POO
            cursoPOO.inscribirEstudiante(est1);
            cursoPOO.inscribirEstudiante(est2);
            System.out.println("✅ " + est1.getNombre() + " y " + est2.getNombre() + " inscriptos en POO.");

            // Inscribimos en Bases de Datos
            cursoBD.inscribirEstudiante(est1);
            cursoBD.inscribirEstudiante(est3);
            System.out.println("✅ " + est1.getNombre() + " y " + est3.getNombre() + " inscriptos en Bases de Datos.");

        } catch (RuntimeException e) {
            System.err.println("❌ " + e.getMessage());
        }

        System.out.println("\n--- 2. LISTADO DE INSCRIPTOS POR CURSO ---");

        System.out.println("Inscriptos en " + cursoPOO.getNombre() + " (" + cursoPOO.getInscripciones().size() + "/" + cursoPOO.getCupoMax() + "):");
        for (Inscripcion ins : cursoPOO.getInscripciones()) {
            System.out.println(" -> Legajo: " + ins.getEstudiante().getLegajo() +
                    " | Nombre: " + ins.getEstudiante().getNombre() +
                    " | Fecha de alta: " + ins.getFechaInscripcion());
        }

        System.out.println("\nInscriptos en " + cursoBD.getNombre() + " (" + cursoBD.getInscripciones().size() + "/" + cursoBD.getCupoMax() + "):");
        for (Inscripcion ins : cursoBD.getInscripciones()) {
            System.out.println(" -> Legajo: " + ins.getEstudiante().getLegajo() +
                    " | Nombre: " + ins.getEstudiante().getNombre() +
                    " | Fecha de alta: " + ins.getFechaInscripcion());
        }

        System.out.println("\n--- 3. MÉTRICA GLOBAL DE LA PLATAFORMA (ATRIBUTO STATIC) ---");
        System.out.println("📊 Total acumulado de inscripciones en toda la universidad: " + Curso.getTotalInscripciones());

        System.out.println("\n==================================================");
        System.out.println("=== PRUEBAS DE EXCEPCIONES Y REGLAS DE NEGOCIO ===");
        System.out.println("==================================================");

        // PRUEBA A: Intentar inscribir dos veces al mismo estudiante en el mismo curso
        System.out.println("\n[Prueba A] Intentando inscribir a Joaquín de nuevo en POO...");
        try {
            cursoPOO.inscribirEstudiante(est1);
        } catch (EstudianteYaInscriptoException e) {
            System.out.println("✅ Excepción capturada correctamente: " + e.getMessage());
        }

        // PRUEBA B: Intentar superar el cupo máximo de un curso
        System.out.println("\n[Prueba B] Intentando inscribir a Lucas en POO (Curso lleno, cupo 2/2)...");
        try {
            cursoPOO.inscribirEstudiante(est3);
        } catch (CupoExcedidoException e) {
            System.out.println("✅ Excepción capturada correctamente: " + e.getMessage());
        }

        // PRUEBA C: Intentar inscribir un estudiante nulo
        System.out.println("\n[Prueba C] Intentando inscribir un estudiante nulo...");
        try {
            cursoBD.inscribirEstudiante(null);
        } catch (IllegalArgumentException e) {
            System.out.println("✅ Excepción capturada correctamente: " + e.getMessage());
        }

        System.out.println("\n=== FIN DE LA EJECUCIÓN ===");
    }
}
