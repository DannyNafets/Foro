package com.foro.api.modelo.topico;

import com.foro.api.modelo.curso.DatosCurso;
import com.foro.api.modelo.usuario.DatosUsuario;

public record DatosRespuestaTopico(Long id, String titulo, String mensaje, String fechaCreacion,
                                   DatosUsuario nombreUsuario, DatosCurso nombreCurso) {

}
