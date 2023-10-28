package com.foro.api.modelo.usuario;

public record DatosRespuestaUsuario(Long id, String login, String email, String clave) {

    public DatosRespuestaUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getLogin(), usuario.getEmail(), usuario.getClave());
    }
}