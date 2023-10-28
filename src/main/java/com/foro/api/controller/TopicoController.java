package com.foro.api.controller;

import com.foro.api.modelo.curso.DatosCurso;
import com.foro.api.modelo.topico.*;
import com.foro.api.modelo.usuario.DatosUsuario;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

        @Autowired
        private TopicoRepository topicoRepository;
        @Autowired
        private RegistrarTopicoService registrarTopicoService;

        @PostMapping
        @Transactional
        public ResponseEntity<DatosRespuestaTopico> registrarTopicos(
                        @RequestBody @Valid DatosRegistrarTopico datosRegistrarTopico,
                        UriComponentsBuilder uriComponentsBuilder) {
                var response = registrarTopicoService.registarTopico(datosRegistrarTopico);
//                Topico topico = topicoRepository.save(new Topico(datosRegistrarTopico));
//                DatosRespuestaTopico datosRespuestatopico = new DatosRespuestaTopico(topico.getId(), topico.getTitulo(),
//                                topico.getMensaje(), topico.getFechaCreacion().toString(),
//                        topico.getStatusTopico().toString(),
//                        topico.getUsuario().getId(), topico.getCurso().getId());

                URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(response.id()).toUri();
                return ResponseEntity.created(url).body(response);
        }

        @GetMapping
        public ResponseEntity<Page<DatosListadoTopico>> listadoTopico(@PageableDefault(size = 10) Pageable paginacion) {
                return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosListadoTopico::new));
        }

        @GetMapping("/{id}")
        public ResponseEntity<DatosRespuestaTopico> retornaDatosTopico(@PathVariable Long id) {
                Topico topico = topicoRepository.getReferenceById(id);
                var datosTopico = new DatosRespuestaTopico(topico.getId(), topico.getTitulo(),
                                topico.getMensaje(), topico.getFechaCreacion().toString(),
                        topico.getStatusTopico().toString(), topico.getUsuario().getId(),
                        topico.getCurso().getId());

                return ResponseEntity.ok(datosTopico);
        }

        @PutMapping("/{id}")
        @Transactional
        public ResponseEntity<DatosRespuestaTopico> actualizarTopico(@PathVariable Long id,
                        @RequestBody DatosActualizarTopico datosActualizarTopico) {
                Topico topico = topicoRepository.getReferenceById(id);
                topico.actulizarDatos(datosActualizarTopico);
                return ResponseEntity.ok().body(new DatosRespuestaTopico(topico.getId(), topico.getTitulo(),
                                topico.getMensaje(), topico.getFechaCreacion().toString(),
                        topico.getStatusTopico().toString(), topico.getUsuario().getId(),
                        topico.getCurso().getId()));
        }

        @DeleteMapping("/{id}")
        @Transactional
        public void removerTopico(@PathVariable Long id) {
                Topico topico = topicoRepository.getReferenceById(id);
                topicoRepository.delete(topico);
        }
}
