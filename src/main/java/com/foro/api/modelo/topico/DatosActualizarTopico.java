package com.foro.api.modelo.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(@NotNull String titulo, @NotBlank String mensaje) {
}
