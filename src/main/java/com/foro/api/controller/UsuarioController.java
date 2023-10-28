package com.foro.api.controller;

import java.net.URI;

import com.foro.api.modelo.usuario.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private EncirptarClaveService service;

    @PostMapping
    public ResponseEntity<DatosRespuestaUsuario> registrarUsuario(@RequestBody @Valid DatosUsuario datosUsuario,
            UriComponentsBuilder uriComponentsBuilder) {
        var response = service.encriptar(datosUsuario);
        System.out.println("Entra");
        System.out.println(response);
//        Usuario usuario = usuarioRepository.save(new Usuario(datosUsuario));
//        DatosRespuestaUsuario datosRespuestaUsuario = new DatosRespuestaUsuario(usuario.getId(),
//                usuario.getNombreUsuario(),
//                usuario.getEmail(), usuario.getClave());
        URI url = uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(url).body(response);
    }
}