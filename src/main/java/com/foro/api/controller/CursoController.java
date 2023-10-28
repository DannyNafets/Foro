package com.foro.api.controller;

import java.net.URI;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.foro.api.modelo.curso.Curso;
import com.foro.api.modelo.curso.CursoRepositorio;
import com.foro.api.modelo.curso.DatosCurso;
import com.foro.api.modelo.curso.DatosRespuestaUsuario;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cursos")
@SecurityRequirement(name = "bearer-key")
public class CursoController {

    @Autowired
    private CursoRepositorio cursoRepositorio;

    @PostMapping
    @Transactional
    public ResponseEntity<DatosRespuestaUsuario> registrarCurso(@RequestBody @Valid DatosCurso datosCurso,
            UriComponentsBuilder uriComponentsBuilder) {
        Curso curso = cursoRepositorio.save(new Curso(datosCurso));
        DatosRespuestaUsuario datosRespuestaUsuario = new DatosRespuestaUsuario(curso.getId(), curso.getNombreCurso(),
                curso.getCategoria());
        URI url = uriComponentsBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();

        return ResponseEntity.created(url).body(datosRespuestaUsuario);
    }
}