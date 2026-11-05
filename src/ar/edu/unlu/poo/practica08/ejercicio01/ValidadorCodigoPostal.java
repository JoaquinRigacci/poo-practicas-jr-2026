package ar.edu.unlu.poo.practica08.ejercicio01;

public interface ValidadorCodigoPostal {
    /**
     * Valida el formato del código postal recibido.
     * @param cp Instancia de CodigoPostal a verificar.
     * @return true si cumple con el formato específico; false en caso contrario.
     */
    boolean validar(CodigoPostal cp);
}
