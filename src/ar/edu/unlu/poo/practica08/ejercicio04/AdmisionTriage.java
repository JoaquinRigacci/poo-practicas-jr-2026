package ar.edu.unlu.poo.practica08.ejercicio04;

public class AdmisionTriage {

    // Atributo
    private ServicioGuardia servicioGuardia;

    // Constructor
    public AdmisionTriage(ServicioGuardia servicioGuardia) {
        this.setServicioGuardia(servicioGuardia);
    }

    // Get
    public ServicioGuardia getServicioGuardia() {
        return this.servicioGuardia;
    }

    // Set
    private void setServicioGuardia(ServicioGuardia servicioGuardia) {
        if (servicioGuardia == null) {
            throw new IllegalArgumentException("ERROR. El servicio de guardia no puede ser nulo.");
        }
        this.servicioGuardia = servicioGuardia;
    }

    // Método
    public NivelUrgencia procesarIngreso(Paciente paciente, ProtocoloTriage protocolo) {
        if (paciente == null || protocolo == null) {
            throw new IllegalArgumentException("ERROR. Ni paciente, ni protocolo pueden ser nulos.");
        }
        NivelUrgencia nivelUrgencia = protocolo.determinarPrioridad(paciente);
        if (nivelUrgencia == NivelUrgencia.ROJO) {
            this.servicioGuardia.asignarBoxReanimacion(paciente, nivelUrgencia);
        }
        return nivelUrgencia;
    }
}
