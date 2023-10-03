package com.foro.api.modelo.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public record DatosUsuario(
        @NotBlank
        String nombreUsuario,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String clave
) {
}
