package ar.edu.unlu.poo.practica06.ejercicio02;

public class EnvioInternacional extends EnvioEstandar{

    // Atributo
    private double tasaAduanera;

    // Constructor
    public EnvioInternacional(double pesoKg, double distanciaKm, double tasaAduanera) {
        super(pesoKg, distanciaKm);
        this.setTasaAduanera(tasaAduanera);
    }

    // Getter
    public double getTasaAduanera() {
        return this.tasaAduanera;
    }

    // Setter
    public void setTasaAduanera(double tasaAduanera) {
        if (tasaAduanera >= 0){
            this.tasaAduanera = tasaAduanera;
        } else {
            throw new IllegalArgumentException("ERROR. La tasa Aduanera debe ser mayor a 0.");
        }
    }

    // Método
    @Override
    public double calcularCosto(){
        return super.calcularCosto() + this.getTasaAduanera();
    }
}
