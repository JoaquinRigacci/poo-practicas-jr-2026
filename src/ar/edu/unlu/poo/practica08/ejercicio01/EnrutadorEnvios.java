package ar.edu.unlu.poo.practica08.ejercicio01;

public class EnrutadorEnvios {

    /**
     * Enruta el envío si el código postal suministrado es válido.
     * @param cp Instancia polimórfica de CodigoPostal.
     * @return true si el paquete fue enrutado y despachado con éxito.
     * @throws CodigoPostalInvalidoException si el código postal no supera la validación.
     */
    public boolean enrutar(CodigoPostal cp) {
        if (cp == null || !cp.esValido()) {
            String valor = (cp != null) ? cp.getCodigo() : "null";
            throw new CodigoPostalInvalidoException("El código postal '" + valor + "' es inválido para su destino.");
        }
        // Procesa y autoriza el despacho
        return true;
    }
}
