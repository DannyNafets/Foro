package com.foro.api.controller;

import com.foro.api.modelo.curso.DatosCurso;
import com.foro.api.modelo.topico.*;
import com.foro.api.modelo.usuario.DatosUsuario;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;
    @PostMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> registrarTopicos(@RequestBody @Valid DatosRegistrarTopico datosRegistrarTopico,
                                           UriComponentsBuilder uriComponentsBuilder){
        Topico topico = topicoRepository.save(new Topico(datosRegistrarTopico));
        DatosRespuestaTopico datosRespuestatopico = new DatosRespuestaTopico(topico.getId(), topico.getTitulo(),
                topico.getMensaje(), topico.getFechaCreacion().toString(),
                new DatosUsuario(topico.getAutor().getNombreUsuario(), topico.getAutor().getEmail(), topico.getAutor().getClave()),
                new DatosCurso(topico.getCurso().getNombreCurso(), topico.getCurso().getCategoria()));

        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestatopico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listadoTopico(@PageableDefault(size = 10) Pageable paginacion){
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosListadoTopico::new));
    }
}
