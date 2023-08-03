package com.api.catalogo_filmes.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.api.catalogo_filmes.dto.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.catalogo_filmes.entities.Movie;
import com.api.catalogo_filmes.service.CrudMovieService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value="/movies")
public class MovieResource {
	
	@Autowired
	private CrudMovieService movieService;

	@GetMapping
	public ResponseEntity<List<MovieDTO>> findAll(){
		List<Movie> list = movieService.findALL();
		List<MovieDTO> listDto = list.stream().map(x -> new MovieDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
/*
	@PostMapping(value="/create")
	public ResponseEntity<MovieDTO> insert(@RequestBody Movie obj) {
		obj = movieService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(new MovieDTO(obj));
	}*/

	@GetMapping(value="/{id}")
	public ResponseEntity<MovieDTO> findById(@PathVariable Long id){
		Movie obj = movieService.findById(id);
        if (obj == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(new MovieDTO(obj));
	}

	@PostMapping(value="/create")
	public ResponseEntity<Movie> create(@RequestBody Movie obj){
		obj = movieService.insert(obj);
        if(obj.getTitle() == null || obj.getSynopsis() == null){
            return ResponseEntity.badRequest().build();
        }
		Movie savedMovie = movieService.insert(obj);
        return ResponseEntity.ok().body(savedMovie);
	}

	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		movieService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value="/{id}")
	public ResponseEntity<Movie> update(@PathVariable Long id,@RequestBody Movie obj){
		 obj = movieService.update(id, obj);
         if (obj == null) {
			return ResponseEntity.notFound().build();
		 }
		return ResponseEntity.ok().body(obj);
	}
}
