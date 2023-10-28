package com.foro.api.modelo.respuesta;

import com.foro.api.infra.errores.ValidacionDeIntegridad;
import com.foro.api.modelo.topico.TopicoRepository;
import com.foro.api.modelo.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistraRespuestaService {
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private RespuestaRepository respuestaRepository;

    public DatosRespuesta registrarRespuesta(DatosRegistrarRespuesta datos){
        System.out.println("Entra aquiiiiiii");
        if (!topicoRepository.findById(datos.topicoId()).isPresent()){
            throw new ValidacionDeIntegridad("Este id para el topico no fue encontrado");
        }

        if (!usuarioRepository.findById(datos.usuarioId()).isPresent()){
            throw new ValidacionDeIntegridad("Este usuario no fue encontrado");
        }

        var topico = topicoRepository.findById(datos.topicoId()).get();

        var usuario = usuarioRepository.findById(datos.usuarioId()).get();

        var respuesta = new Respuesta(datos.mensaje(), topico, datos.fechaCreacion(), usuario,
                datos.solucion());

        respuestaRepository.save(respuesta);

        return new DatosRespuesta(respuesta);
    }
}
