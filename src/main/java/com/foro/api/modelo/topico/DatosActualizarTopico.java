package com.foro.api.modelo.topico;

import com.foro.api.modelo.curso.DatosCurso;
import com.foro.api.modelo.usuario.DatosUsuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(@NotNull String titulo, @NotBlank String mensaje) {
}
