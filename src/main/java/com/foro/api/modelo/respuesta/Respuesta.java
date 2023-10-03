package com.foro.api.modelo.respuesta;

import com.foro.api.modelo.topico.Topico;
import com.foro.api.modelo.usuario.Usuario;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {

	private Long id;
	private String mensaje;
	private Topico topico;
	private LocalDateTime fechaCreacion = LocalDateTime.now();
	private Usuario autor;
	private Boolean solucion = false;

}
