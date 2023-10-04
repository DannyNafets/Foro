package com.foro.api.modelo.topico;

import com.foro.api.modelo.respuesta.Respuesta;
import com.foro.api.modelo.curso.Curso;
import com.foro.api.modelo.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

	@Embedded
	private Usuario autor;

	@Embedded
	private Curso curso;

	//private List<Respuesta> respuestas = new ArrayList<>();

	public Topico(DatosRegistrarTopico datosRegistrarTopico) {
		this.titulo = datosRegistrarTopico.titulo();
		this.mensaje = datosRegistrarTopico.mensaje();
		this.fechaCreacion = LocalDateTime.now();
		this.statusTopico = StatusTopico.NO_RESPONDIDO;
		this.autor = new Usuario(datosRegistrarTopico.usuario());
		this.curso = new Curso(datosRegistrarTopico.curso());
	}


	public void actulizarDatos(DatosActualizarTopico datosActualizarTopico) {
		if (datosActualizarTopico.titulo() != ""){
			this.titulo = datosActualizarTopico.titulo();
		}
		if (datosActualizarTopico.mensaje() != ""){
			this.mensaje = datosActualizarTopico.mensaje();
		}
	}
}
