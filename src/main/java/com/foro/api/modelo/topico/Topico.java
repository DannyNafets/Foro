package com.foro.api.modelo.topico;

// import com.foro.api.modelo.respuesta.Respuesta;
import com.foro.api.modelo.curso.Curso;
import com.foro.api.modelo.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
// import java.util.ArrayList;
// import java.util.List;

@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String titulo;

	private String mensaje;

	private LocalDateTime fechaCreacion;

	@Column(name = "status_topico")
	@Enumerated(EnumType.STRING)
	private StatusTopico statusTopico;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "curso_id")
	private Curso curso;

	// private List<Respuesta> respuestas = new ArrayList<>();

	public Topico(DatosRegistrarTopico datosRegistrarTopico) {
		this.titulo = datosRegistrarTopico.titulo();
		this.mensaje = datosRegistrarTopico.mensaje();
		this.fechaCreacion = LocalDateTime.now();
		this.statusTopico = StatusTopico.NO_RESPONDIDO;
		this.usuario = usuario;
		this.curso = curso;
	}

	public Topico(String titulo, String mensaje, LocalDateTime localDateTime, StatusTopico statusTopico,
				  Usuario usuario, com.foro.api.modelo.curso.Curso curso) {
		this.titulo = titulo;
		this.mensaje = mensaje;
		this.fechaCreacion = LocalDateTime.now();
		this.statusTopico = StatusTopico.NO_RESPONDIDO;
		this.usuario = usuario;
		this.curso = curso;
	}

	public void actulizarDatos(DatosActualizarTopico datosActualizarTopico) {
		if (!"".equals(datosActualizarTopico.titulo())) { // esta liena de codigo es = if
															// (datosActualizarTopico.titulo() != "")
			this.titulo = datosActualizarTopico.titulo();
		}
		if (!"".equals(datosActualizarTopico.mensaje())) {
			this.mensaje = datosActualizarTopico.mensaje();
		}
	}
}
