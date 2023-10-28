package com.foro.api.modelo.respuesta;

public record DatosRespuesta(Long id, String mensaje, Long topicoId, String fechaCreacion, Long usuarioId,
                             Boolean solucion) {
        public DatosRespuesta(Respuesta respuesta){
                this(respuesta.getId(), respuesta.getMensaje(), respuesta.getTopico().getId(),
                        respuesta.getFechaCreacion().toString(),
                        respuesta.getUsuario().getId(), respuesta.getSolucion());
        }
}
