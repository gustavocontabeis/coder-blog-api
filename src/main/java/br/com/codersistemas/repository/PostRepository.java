package br.com.codersistemas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.codersistemas.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
	
}
