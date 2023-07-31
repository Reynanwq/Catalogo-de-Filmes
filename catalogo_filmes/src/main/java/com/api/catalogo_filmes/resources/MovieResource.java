package com.api.catalogo_filmes.resources;

import java.util.List;

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

@RestController
@RequestMapping(value="/movies")
public class MovieResource {
	
	@Autowired
	private CrudMovieService movieService;
	
	@GetMapping
	public ResponseEntity<List<Movie>> findAll(){
		List<Movie> list = movieService.findALL();
		//List<Movie> listDto= list.stream().map(x -> new Movie(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Movie> findById(@PathVariable Long id){
		Movie obj = movieService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping(value="/create")
	public ResponseEntity<Movie> insert(@RequestBody Movie obj){
		obj=movieService.insert(obj);
		//URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		//.buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.ok().body(obj);
		
	}
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		movieService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Movie> update(@PathVariable Long id,@RequestBody Movie obj){
		 obj= movieService.update(id, obj);
		return ResponseEntity.ok().body(obj);
		
	}

}
