package com.foro.api.modelo.topico;

import com.foro.api.modelo.curso.DatosCurso;
import com.foro.api.modelo.usuario.DatosUsuario;

public record DatosRespuestaTopico(Long id, String titulo, String mensaje, String fechaCreacion, String statusTopico,
        Long usuarioId, Long cursoId) {

    public DatosRespuestaTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion().toString(),
                topico.getStatusTopico().toString(), topico.getUsuario().getId(), topico.getCurso().getId());
    }


}
