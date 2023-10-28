package com.foro.api.modelo.topico;

import com.foro.api.infra.errores.ValidacionDeIntegridad;
import com.foro.api.modelo.curso.CursoRepositorio;
import com.foro.api.modelo.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrarTopicoService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepositorio cursoRepositorio;
    @Autowired
    private TopicoRepository topicoRepository;

    public DatosRespuestaTopico registarTopico(DatosRegistrarTopico datos){

        if (!usuarioRepository.findById(datos.usuarioId()).isPresent()){
            throw new ValidacionDeIntegridad("Este Usuario no existe");
        }

        if (!cursoRepositorio.findById(datos.cursoId()).isPresent()){
            throw new ValidacionDeIntegridad("Este Curso no existe");
        }

        var usuario = usuarioRepository.findById(datos.usuarioId()).get();

        var curso = cursoRepositorio.findById(datos.cursoId()).get();

        var topico = new Topico(datos.titulo(), datos.mensaje(), datos.fechaCreacion(), datos.estatusTopico(),
                usuario, curso);

        topicoRepository.save(topico);

        return new DatosRespuestaTopico(topico);
    }
}
