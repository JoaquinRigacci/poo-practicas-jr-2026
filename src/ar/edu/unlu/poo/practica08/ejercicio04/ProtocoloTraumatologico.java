package ar.edu.unlu.poo.practica08.ejercicio04;

public class ProtocoloTraumatologico extends ProtocoloTriage{

    // Método
    @Override
    protected NivelUrgencia evaluarRiesgoEspecifico(Paciente paciente) {
        if (paciente.getEscalaDolor() >= 9) {
            return NivelUrgencia.ROJO;
        } else if (paciente.getEscalaDolor() >= 7) {
            return NivelUrgencia.AMARILLO;
        } else {
            return NivelUrgencia.VERDE;
        }
    }
}
