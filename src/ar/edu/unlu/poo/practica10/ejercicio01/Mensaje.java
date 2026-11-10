package ar.edu.unlu.poo.practica10.ejercicio01;

import java.time.LocalDateTime;

public class Mensaje {

    // Atributos
    private final String texto;
    private final Usuario autor; // null representa mensaje automático del sistema
    private final LocalDateTime fecha;

    // Constructor para mensajes de usuarios
    public Mensaje(String texto, Usuario autor) {
        if (texto == null || texto.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR. El mensaje no puede estar vacío.");
        }
        if (autor == null) {
            throw new IllegalArgumentException("ERROR. El autor del mensaje no puede ser nulo.");
        }
        this.texto = texto.trim();
        this.autor = autor;
        this.fecha = LocalDateTime.now();
    }

    // Constructor para mensajes del sistema
    public Mensaje(String textoSistema) {
        if (textoSistema == null || textoSistema.trim().isEmpty()) {
            throw new IllegalArgumentException("ERROR. El texto del sistema no puede estar vacío.");
        }
        this.texto = textoSistema.trim();
        this.autor = null;
        this.fecha = LocalDateTime.now();
    }

    // Getter
    public String getTexto() {
        return this.texto;
    }

    public Usuario getAutor() {
        return this.autor;
    }

    public LocalDateTime getFecha() {
        return this.fecha;
    }

    public boolean esMensajeDelSistema() {
        return this.autor == null;
    }
}
