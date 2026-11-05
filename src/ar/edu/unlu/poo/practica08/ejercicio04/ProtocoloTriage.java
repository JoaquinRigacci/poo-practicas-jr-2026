package ar.edu.unlu.poo.practica08.ejercicio04;

public abstract class ProtocoloTriage {

    // Métodos
    public NivelUrgencia determinarPrioridad(Paciente paciente) {
        if (paciente == null) {
            throw new IllegalArgumentException("ERROR. El paciente no puede ser nulo.");
        }
        if (paciente.getFrecuenciaCardiaca() < 40 || paciente.getFrecuenciaCardiaca() > 130) {
            return NivelUrgencia.ROJO;
        }
        return evaluarRiesgoEspecifico(paciente);
    }

    protected abstract NivelUrgencia evaluarRiesgoEspecifico(Paciente paciente);
}
