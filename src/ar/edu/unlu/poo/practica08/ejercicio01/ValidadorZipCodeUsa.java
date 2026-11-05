package ar.edu.unlu.poo.practica08.ejercicio01;

public class ValidadorZipCodeUsa implements ValidadorCodigoPostal {

    // ZIP Code USA: 5 dígitos o 5 dígitos seguidos de guion y 4 dígitos (ej: 12345 o 12345-1234)
    private static final String REGEX_ZIP_USA = "^\\d{5}(-\\d{4})?$";

    @Override
    public boolean validar(CodigoPostal cp) {
        if (cp == null || cp.getCodigo() == null) {
            return false;
        }
        return cp.getCodigo().trim().matches(REGEX_ZIP_USA);
    }
}
