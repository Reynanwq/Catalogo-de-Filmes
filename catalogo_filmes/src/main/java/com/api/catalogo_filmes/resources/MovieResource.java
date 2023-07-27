package com.api.catalogo_filmes.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.catalogo_filmes.entities.Movie;

@RestController
@RequestMapping(value="/movies")
public class MovieResource {
	
	@GetMapping
	public ResponseEntity<Movie>findAll(){
		Movie movie= new Movie(1L, "asd", "asd", "asd", "asdas", "asdas", "asdasd", "asdasd", "asdasd");
		return ResponseEntity.ok().body(movie);
	}

}
