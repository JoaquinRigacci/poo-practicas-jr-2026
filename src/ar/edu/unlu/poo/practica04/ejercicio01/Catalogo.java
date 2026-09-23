package ar.edu.unlu.poo.practica04.ejercicio01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Catalogo {

    // Atributos
    private List<Artefacto> artefactos;

    // Constructor
    public Catalogo() {
        this.artefactos = new ArrayList<>();
    }

    // Método para agregar
    public void agregarArtefacto(Artefacto artefacto) {
        if (artefacto != null) {
            this.artefactos.add(artefacto);
        } else {
            throw new IllegalArgumentException("ERROR. El artefacto no puede ser nulo.");
        }
    }


    // Métodos de consulta por Streams
    public List<Artefacto> filtrarPorMarca(String marca) {
        return this.artefactos.stream().filter(a -> a.getMarca().equalsIgnoreCase(marca)).toList();
    }

    public List<String> obtenerModelos(String marca) {
        return this.artefactos.stream().filter(a -> a.getMarca().equalsIgnoreCase(marca))
                .map(Artefacto::getModelo).toList();
    }

    public Optional<Artefacto> buscarMasCaro(String marca) {
        return this.artefactos.stream().filter(a -> a.getMarca().equalsIgnoreCase(marca)).
                max(Comparator.comparingDouble(Artefacto::getPrecioUSD));
    }
}
