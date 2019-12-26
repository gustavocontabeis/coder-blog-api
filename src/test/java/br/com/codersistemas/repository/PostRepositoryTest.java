package br.com.codersistemas.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.codersistemas.CoderBlogApiApplication;
import br.com.codersistemas.entity.Departamento;
import br.com.codersistemas.entity.Post;
import br.com.codersistemas.entity.TipoUsuario;
import br.com.codersistemas.entity.Usuario;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CoderBlogApiApplication.class)
public class PostRepositoryTest {
	
	@Autowired
	private PostRepository postRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	@Test //@Ignore
	public void testFindAll() {
		
		log.info("xxxxxxxxxxxxxxxxxxxxxx testFindAll");
		
		List<Post> findAll = postRepository.findAll();
		findAll.forEach(System.out::println);
		
	}

	@Test //@Ignore
	public void testSaveAndFlush() {
		
		log.info("xxxxxxxxxxxxxxxxxxxxxx testSaveAndFlush ");
		
		Usuario usuario = salvarUsuario();
		Departamento departamento = salvarDepartamento();
		Post post = salvarPost(usuario, departamento);
		
		log.info("{}", post);
	}

	private Post salvarPost(Usuario usuario, Departamento departamento) {
		Post post = new Post();
		post.setAtivo(true);
		post.setAtualizacao(LocalDateTime.now());
		post.setCadastro(LocalDateTime.now());
		post.setConteudo("Contetúdo válido");
		post.setDepartamento(departamento);
		post.setId(null);
		post.setSubtitulo("Subtitulo");
		post.setTitulo("Titulo");
		post.setUsuario(usuario);
		postRepository.saveAndFlush(post);
		log.info("{}", post);
		return post;
	}

	private Departamento salvarDepartamento() {
		Departamento departamento = new Departamento();
		departamento.setId(null);
		departamento.setNome("Departamento");
		departamentoRepository.saveAndFlush(departamento);
		log.info("{}", departamento);
		return departamento;
	}

	private Usuario salvarUsuario() {
		Usuario usuario = new Usuario();
		usuario.setEmail("usuario@email.com");
		usuario.setId(null);
		usuario.setNome("Usuario");
		usuario.setSenha("123");
		usuario.setTipoUsuario(TipoUsuario.VISITANTE);
		usuarioRepository.saveAndFlush(usuario);
		log.info("{}", usuario);
		return usuario;
	}

	@Test
	public void testGetOne() {
		//fail("Not yet implemented");
	}

	@Test
	public void testFindAllPageable() {
		//fail("Not yet implemented");
	}

	@Test
	public void testFindAll1() {
		//fail("Not yet implemented");
	}

}
