package com.foro.api.modelo.topico;

import com.foro.api.modelo.curso.DatosCurso;
import com.foro.api.modelo.usuario.DatosUsuario;

public record DatosListadoTopico(Long id, String titulo, String mensaje, String fechaCreacion, String statusTopico,
                Long idUsuario, Long idCurso) {
        public DatosListadoTopico(Topico topico) {
                this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion().toString(),
                                topico.getStatusTopico().toString(), topico.getUsuario().getId(),
                        topico.getUsuario().getId());
        }
}
