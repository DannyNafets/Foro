package com.foro.api.modelo.usuario;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode(of = "id")
public class Usuario {

	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private Long id;
	private String nombreUsuario;
	private String email;
	private String clave;

	public Usuario(DatosUsuario datosUsuario){
		this.nombreUsuario = datosUsuario.nombreUsuario();
		this.email = datosUsuario.email();
		this.clave = datosUsuario.clave();
	}

}
