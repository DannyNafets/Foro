package com.foro.api.controller;

import java.net.URI;

import com.foro.api.modelo.respuesta.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/respuestas")
@SecurityRequirement(name = "bearer-key")
public class RespuestaController {

        @Autowired
        private RespuestaRepository respuestaRepository;
        @Autowired
        private RegistraRespuestaService service;

        @PostMapping
        @Transactional
        public ResponseEntity<DatosRespuesta> registrarRespuestas(
                @RequestBody @Valid DatosRegistrarRespuesta datos,
                        UriComponentsBuilder uriComponentsBuilder) {
                var response = service.registrarRespuesta(datos);
                System.out.println("hola");
//                Respuesta respuesta = respuestaRepository.save(new Respuesta(datos));
//                DatosRespuesta datosRespuestaRespuesta = new DatosRespuesta(respuesta.getId(),
//                                respuesta.getMensaje(), respuesta.getTopico().getId(),
//                                respuesta.getFechaCreacion().toString(), respuesta.getUsuario().getId(),
//                                respuesta.getSolucion());

                URI url = uriComponentsBuilder.path("/respuestas/{id}").buildAndExpand(response.id()).toUri();
                return ResponseEntity.created(url).body(response);
        }

}