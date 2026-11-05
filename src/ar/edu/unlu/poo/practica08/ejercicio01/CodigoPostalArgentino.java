package ar.edu.unlu.poo.practica08.ejercicio01;

public class CodigoPostalArgentino extends CodigoPostal {

    public CodigoPostalArgentino(String codigo) {
        super(codigo, new ValidadorCodigoPostalArgentino());
    }
}