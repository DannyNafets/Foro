package com.foro.api.modelo.respuesta;

import java.time.LocalDateTime;

import com.foro.api.modelo.topico.Topico;
import com.foro.api.modelo.usuario.DatosUsuario;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistrarRespuesta(

                @NotBlank(message = "Debe Introducir una respuesta")
                String mensaje,

                @NotNull Long topicoId,
                LocalDateTime fechaCreacion,

                @NotNull Long usuarioId,
                Boolean solucion) {

}
