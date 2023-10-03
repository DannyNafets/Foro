package com.foro.api.modelo.topico;

import com.foro.api.modelo.curso.Curso;
import com.foro.api.modelo.curso.DatosCurso;
import com.foro.api.modelo.usuario.DatosUsuario;
import com.foro.api.modelo.usuario.Usuario;

public record DatosListadoTopico(Long id, String titulo, String mensaje, String fechaCreacion, String statusTopico,
                                 DatosUsuario usuario, DatosCurso curso) {
    public DatosListadoTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion().toString(),
                topico.getStatusTopico().toString(),
                new DatosUsuario(topico.getAutor().getNombreUsuario(), topico.getAutor().getEmail(), topico.getAutor().getClave()),
                new DatosCurso(topico.getCurso().getNombreCurso(), topico.getCurso().getCategoria())
        );
    }
}
