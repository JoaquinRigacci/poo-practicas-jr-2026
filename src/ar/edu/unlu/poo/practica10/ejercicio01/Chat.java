package ar.edu.unlu.poo.practica10.ejercicio01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Chat implements IObservable{

    // Atributos
    private final Map<Integer, Usuario> usuariosActivos;
    private final List<Mensaje> historialMensajes;
    private final List<IObservador> observadores;

    // Constructor
    public Chat() {
        this.usuariosActivos = new HashMap<>();
        this.historialMensajes = new ArrayList<>();
        this.observadores = new ArrayList<>();
    }

    // --- IMPLEMENTACIÓN DE IOBSERVABLE ---
    @Override
    public void agregarObservador(IObservador observador) {
        if (observador != null && !this.observadores.contains(observador)) {
            this.observadores.add(observador);
        }
    }

    @Override
    public void removerObservador(IObservador observador) {
        this.observadores.remove(observador);
    }

    @Override
    public void notificarObservadores(EventoChat evento) {
        for (IObservador obs : this.observadores) {
            obs.actualizar(evento, this);
        }
    }

    // --- MÉTODOS DE NEGOCIO ---
    public Usuario conectarUsuario(String nombre) {
        Usuario nuevoUsuario = new Usuario(nombre);
        this.usuariosActivos.put(nuevoUsuario.getId(), nuevoUsuario);
        // El sistema genera un aviso automático en el historial
        this.historialMensajes.add(new Mensaje("El usuario '" + nuevoUsuario.getNombre() + "' se ha conectado."));
        // Notificación reactiva semántica a todos los observadores
        this.notificarObservadores(EventoChat.USUARIO_CONECTADO);
        return nuevoUsuario;
    }

    public void desconectarUsuario(int usuarioId) {
        Usuario removido = this.usuariosActivos.remove(usuarioId);
        if (removido != null) {
            this.historialMensajes.add(new Mensaje("El usuario '" + removido.getNombre() + "' abandonó la sala."));
            this.notificarObservadores(EventoChat.USUARIO_DESCONECTADO);
        }
    }

    public void enviarMensaje(String texto, Usuario autor) {
        if (!this.usuariosActivos.containsKey(autor.getId())) {
            throw new IllegalStateException("ERROR. El usuario no está conectado a la sala.");
        }
        Mensaje mensaje = new Mensaje(texto, autor);
        this.historialMensajes.add(mensaje);
        // Notificación reactiva semántica de nuevo mensaje
        this.notificarObservadores(EventoChat.NUEVO_MENSAJE);
    }

    // --- ACCESORES BLINDADOS CONTRA ALIASING ---
    public Usuario[] getUsuariosActivos() {
        return this.usuariosActivos.values().toArray(new Usuario[0]);
    }

    public Mensaje[] getHistorialMensajes() {
        return this.historialMensajes.toArray(new Mensaje[0]);
    }
}

/*
1. ¿Por qué Chat notifica después de mutar su estado interno?
    Porque la notificación avisa a los observadores que un cambio ya ocurrió, de modo que cuando
    los observadores hagan la consulta pull, obtendrán el estado actualizado.

2. ¿Por qué devolvemos Usuario[] en lugar de Map<Integer, Usuario> ?
    Para evitar la fuga de referencias (representation leak). Si devolviéramos el mapa interno,
    cualquier código externo podría hacer .clear() o .put() alterando el estado del modelo desde afuera.
*/
