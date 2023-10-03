package com.foro.api.modelo.topico;

import com.foro.api.modelo.curso.DatosCurso;
import com.foro.api.modelo.usuario.DatosUsuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistrarTopico(
        @NotBlank(message = "Titulo es obligatorio")
        String titulo,
        @NotBlank
        String mensaje,
        LocalDateTime fechaCreacion,
        StatusTopico estatusTopico,
        @NotNull
        @Valid
        DatosUsuario usuario,
        @NotNull
        @Valid
        DatosCurso curso) {
}
