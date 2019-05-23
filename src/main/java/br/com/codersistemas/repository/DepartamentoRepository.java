package br.com.codersistemas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.codersistemas.entity.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
	
	Optional<Departamento> findByNome(String nome);

}
