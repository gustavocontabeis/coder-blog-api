package br.com.codersistemas.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Post implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "post_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "post_seq", sequenceName = "post_seq")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_departamento")
	@NotNull(message = "Departamento é obrigatório.")
	private Departamento departamento;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	@NotNull(message = "Usuário é obrigatório.")
	private Usuario usuario;
	
	@NotEmpty
	@Size(max = 80)
	private String titulo;
	
	@NotEmpty
	@Size(max = 500)
	private String subtitulo;
	
	private LocalDateTime cadastro;
	
	private LocalDateTime atualizacao;
	
	private boolean ativo;
	
	@NotEmpty(message = "O conteúdo deverá ser preenchido.")
	@Size(min = 10, max=5000, message = "O conteúdo do post deverá ter no mínimo 10 caracteres.")
	@Column(length = 5000)
	private String conteudo;

}
