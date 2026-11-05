package ar.edu.unlu.poo.practica08.ejercicio01;

public class ValidadorCodigoPostalArgentino implements ValidadorCodigoPostal {

    // CPA Tradicional (1974): exactamente 4 dígitos (ej: 6700)
    private static final String REGEX_TRADICIONAL = "^\\d{4}$";

    // CPA Moderno (1998): 1 letra de provincia + 4 dígitos + 3 letras de manzana (ej: B1636FDA)
    private static final String REGEX_MODERNO = "^[A-Za-z]\\d{4}[A-Za-z]{3}$";

    @Override
    public boolean validar(CodigoPostal cp) {
        if (cp == null || cp.getCodigo() == null) {
            return false;
        }
        String codigoLimpio = cp.getCodigo().trim();
        return codigoLimpio.matches(REGEX_TRADICIONAL) || codigoLimpio.matches(REGEX_MODERNO);
    }
}
