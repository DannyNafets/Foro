package com.foro.api.modelo.respuesta;

import com.foro.api.modelo.topico.Topico;
import com.foro.api.modelo.usuario.Usuario;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Optional;

@Entity(name = "Respuesta")
@Table(name = "respuestas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String mensaje;

	@ManyToOne
	@JoinColumn(name = "topico_id")
	private Topico topico;

	private LocalDateTime fechaCreacion = LocalDateTime.now();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	private Boolean solucion = false;

	public Respuesta(@Valid DatosRegistrarRespuesta datos, Topico topico, Usuario usuario) {
		this.mensaje = datos.mensaje();
		this.topico = topico;
		this.fechaCreacion = LocalDateTime.now();
		this.usuario = usuario;
		this.solucion = false;
	}

	public Respuesta(String mensaje, Topico topico, LocalDateTime localDateTime, Usuario usuario,
					 Boolean solucion) {
		this.mensaje = mensaje;
		this.topico = topico;
		this.fechaCreacion = LocalDateTime.now();
		this.usuario = usuario;
		this.solucion = false;
	}
}
