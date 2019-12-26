package br.com.codersistemas.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "usuario_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "usuario_seq", sequenceName = "usuario_seq", initialValue=1000)
	private Long id;
	private String nome;
	private TipoUsuario tipoUsuario;
	@Column(unique=true)
	private String email;
	private String senha;
	
}
