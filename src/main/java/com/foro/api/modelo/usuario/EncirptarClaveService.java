package com.foro.api.modelo.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EncirptarClaveService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public EncirptarClaveService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    public DatosRespuestaUsuario encriptar(DatosUsuario datosUsuario){
        System.out.println("Entra");
        var clave = passwordEncoder.encode(datosUsuario.clave());
        var usuario = new Usuario(datosUsuario.login(), datosUsuario.email(), clave);

        usuarioRepository.save(usuario);
        return new DatosRespuestaUsuario(usuario);
    }
}
