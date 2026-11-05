package ar.edu.unlu.poo.practica08.ejercicio04;

public class ProtocoloRespiratorio extends ProtocoloTriage{

    // Método
    @Override
    protected NivelUrgencia evaluarRiesgoEspecifico(Paciente paciente) {
        if (paciente.getSaturacionOxigeno() < 90) {
            return NivelUrgencia.ROJO;
        } else if (paciente.getSaturacionOxigeno() >= 95) {
            return NivelUrgencia.VERDE;
        } else {
            return NivelUrgencia.AMARILLO;
        }
    }
}
