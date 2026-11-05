package ar.edu.unlu.poo.practica08.ejercicio04;

public class Main {
    public static void main(String[] args) {
        System.out.println("===================================================================");
        System.out.println(" SISTEMA DE ADMISIÓN Y TRIAGE DE URGENCIAS - HOSPITAL UNLu ");
        System.out.println("===================================================================\n");

        // 1. Creamos una implementación concreta del ServicioGuardia para ver las notificaciones en consola
        ServicioGuardia guardiaHospital = new ServicioGuardia() {
            @Override
            public void asignarBoxReanimacion(Paciente paciente, NivelUrgencia nivel) {
                System.out.println("🚨 [ALERTA GUARDIA] Asignando de urgencia BOX DE REANIMACIÓN para el paciente: " + paciente.getHistoriaClinica() + " (Prioridad: " + nivel + ")");
            }
        };

        // 2. Instanciamos el puesto de Admisión inyectándole la guardia
        AdmisionTriage admision = new AdmisionTriage(guardiaHospital);

        // 3. Instanciamos los protocolos médicos disponibles (Especialidades polimórficas)
        ProtocoloTriage protocoloRespiratorio = new ProtocoloRespiratorio();
        ProtocoloTriage protocoloTraumatologico = new ProtocoloTraumatologico();

        // -----------------------------------------------------------------------------------------
        // CASO 1: Paciente Respiratorio Crítico (Saturación baja: 86%)
        // -----------------------------------------------------------------------------------------
        System.out.println("--- CASO 1: Ingreso por Guardia Respiratoria (Crisis Asmática) ---");
        Paciente paciente1 = new Paciente("HC-1001", 80, 86.0, 2);
        System.out.println("Paciente: " + paciente1.getHistoriaClinica() + " | FC: " + paciente1.getFrecuenciaCardiaca() + " lpm" + " | SatO2: " + paciente1.getSaturacionOxigeno() + "%" + " | Dolor: " + paciente1.getEscalaDolor() + "/10");
        NivelUrgencia resultado1 = admision.procesarIngreso(paciente1, protocoloRespiratorio);
        System.out.println("-> Resultado Triage: " + resultado1 + "\n");

        // -----------------------------------------------------------------------------------------
        // CASO 2: Paciente Respiratorio Moderado (Saturación 92% -> AMARILLO, no notifica box)
        // -----------------------------------------------------------------------------------------
        System.out.println("--- CASO 2: Ingreso por Guardia Respiratoria (Bronquitis Leve) ---");
        Paciente paciente2 = new Paciente("HC-1002", 75, 92.0, 1);
        System.out.println("Paciente: " + paciente2.getHistoriaClinica() + " | FC: " + paciente2.getFrecuenciaCardiaca() + " lpm" + " | SatO2: " + paciente2.getSaturacionOxigeno() + "%" + " | Dolor: " + paciente2.getEscalaDolor() + "/10");
        NivelUrgencia resultado2 = admision.procesarIngreso(paciente2, protocoloRespiratorio);
        System.out.println("-> Resultado Triage: " + resultado2 + "\n");

        // -----------------------------------------------------------------------------------------
        // CASO 3: Paciente Traumatológico Grave (Fractura expuesta -> Dolor 9/10 -> ROJO)
        // -----------------------------------------------------------------------------------------
        System.out.println("--- CASO 3: Ingreso Traumatológico (Fractura Expuesta) ---");
        Paciente paciente3 = new Paciente("HC-1003", 85, 98.0, 9);
        System.out.println("Paciente: " + paciente3.getHistoriaClinica() + " | FC: " + paciente3.getFrecuenciaCardiaca() + " lpm" + " | SatO2: " + paciente3.getSaturacionOxigeno() + "%" + " | Dolor: " + paciente3.getEscalaDolor() + "/10");
        NivelUrgencia resultado3 = admision.procesarIngreso(paciente3, protocoloTraumatologico);
        System.out.println("-> Resultado Triage: " + resultado3 + "\n");

        // -----------------------------------------------------------------------------------------
        // CASO 4: Invariante Vital Universal (Bradicardia Extrema: FC = 32 lpm)
        // Aunque el dolor sea 1 y la saturación 99%, el Template Method corta en ROJO de inmediato
        // -----------------------------------------------------------------------------------------
        System.out.println("--- CASO 4: Invariante Vital Universal (Bradicardia Severa) ---");
        Paciente paciente4 = new Paciente("HC-1004", 32, 99.0, 1);
        System.out.println("Paciente: " + paciente4.getHistoriaClinica() + " | FC: " + paciente4.getFrecuenciaCardiaca() + " lpm (¡CRÍTICO!)" + " | SatO2: " + paciente4.getSaturacionOxigeno() + "%" + " | Dolor: " + paciente4.getEscalaDolor() + "/10");
        // Lo pasamos por el traumatológico para demostrar que el paso universal manda antes
        NivelUrgencia resultado4 = admision.procesarIngreso(paciente4, protocoloTraumatologico);
        System.out.println("-> Resultado Triage: " + resultado4 + "\n");

        System.out.println("===================================================================");
        System.out.println(" SIMULACIÓN FINALIZADA CON ÉXITO ");
        System.out.println("===================================================================");
    }
}
