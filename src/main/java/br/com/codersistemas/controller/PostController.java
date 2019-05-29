package br.com.codersistemas.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.codersistemas.entity.Post;
import br.com.codersistemas.repository.PostRepository;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/posts")
public class PostController {
	
	@Autowired
	private PostRepository posts;
	
	//http://localhost:8084/posts
	@GetMapping
	public List<Post> listar() {
		return posts.findAll();
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Post adicionar(@Valid @RequestBody Post entity) {
		return posts.save(entity);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Post> buscar(@PathVariable Long id) {
		Optional<Post> findById = posts.findById(id);
		if(!findById.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Post post = findById.get();
		return ResponseEntity.ok(post);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	public ResponseEntity<Post> excluir(@PathVariable Long id) {
		Optional<Post> findById = posts.findById(id);
		if(!findById.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		posts.delete(findById.get());
		return ResponseEntity.accepted().build();
	}
	
}
