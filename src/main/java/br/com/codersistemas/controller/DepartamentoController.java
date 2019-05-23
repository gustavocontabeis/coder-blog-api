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
import org.springframework.web.server.ResponseStatusException;

import br.com.codersistemas.entity.Departamento;
import br.com.codersistemas.repository.DepartamentoRepository;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {
	
	@Autowired
	private DepartamentoRepository departamentos;
	
	//http://localhost:8084/coder-blog/departamentos
	@GetMapping
	public List<Departamento> listar() {
		return departamentos.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Departamento> buscar(@PathVariable Long id) {
		Optional<Departamento> findById = departamentos.findById(id);
		if(findById.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(findById.get());
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Departamento adicionar(@Valid @RequestBody Departamento entity) {
		
		Optional<Departamento> findByNome = departamentos.findByNome(entity.getNome());
		if(findByNome.isPresent())
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe um departamento com o mesmo nome.");
		
		return departamentos.save(entity);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Departamento> remover(@PathVariable Long id) {
		System.out.println();
		Optional<Departamento> findById = departamentos.findById(id);
		if(findById.isEmpty()) 
			return ResponseEntity.notFound().build();
		departamentos.delete(findById.get());
		return ResponseEntity.ok(findById.get());
	}

}
