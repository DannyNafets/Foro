package com.foro.api.modelo.curso;

import jakarta.persistence.*;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode(of = "id")
public class Curso {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
	private String nombreCurso;
	private String categoria;

	public Curso(DatosCurso curso) {
		this.nombreCurso = curso.nombreCurso();
		this.categoria = curso.categoria();
	}

}
