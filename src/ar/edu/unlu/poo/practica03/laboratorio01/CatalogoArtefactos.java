package ar.edu.unlu.poo.practica03.laboratorio01;

import java.util.*;

public class CatalogoArtefactos {

    // Atributos
    private Set<Artefacto> artefactos;

    // Constructor
    public CatalogoArtefactos() {
        this.artefactos = new HashSet<>();
    }

    // Métodos
    public boolean agregarArtefacto(Artefacto artefacto) {
        if (artefacto != null) {
            return this.artefactos.add(artefacto);
        } else {
            throw new IllegalArgumentException("ERROR. No se ingreso el artefacto.");
        }
    }

    public List<Artefacto> buscarArtefactosPorTipo(String tipo) {
        if (tipo != null && !tipo.trim().isEmpty()) {
            List<Artefacto> encontrados = new ArrayList<Artefacto>();
            for (Artefacto artefacto : this.artefactos) {
                if (artefacto.getTipo().equalsIgnoreCase(tipo)) {
                    encontrados.add(artefacto);
                }
            }
            encontrados.sort(Comparator.comparingInt(Artefacto::getPoder));
            return encontrados;
        } else {
            throw new IllegalArgumentException("ERROR. El tipo no puede ser nulo.");
        }
    }

    public Map<String, Integer> contarArtefactosPorTipo() {

        Map<String, Integer> resultado = new HashMap<>();

        for (Artefacto artefacto : this.artefactos) {
            String tipo = artefacto.getTipo();

            if (resultado.containsKey(tipo)) {
                // Si el tipo ya está en el mapa, le sumamos 1 a la cantidad actual
                resultado.put(tipo, resultado.get(tipo) + 1);
            } else {
                // Si es la primera vez que aparece este tipo, lo agregamos con valor 1
                resultado.put(tipo, 1);
            }
        }

        return resultado;
    }

    public Set<Artefacto> obtenerArtefactosUnicos() {
        return this.artefactos;
    }
}
