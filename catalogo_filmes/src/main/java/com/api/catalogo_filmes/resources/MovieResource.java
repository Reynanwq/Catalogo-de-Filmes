package com.api.catalogo_filmes.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.api.catalogo_filmes.dto.MovieDTO;
import jakarta.validation.Valid;
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

	@GetMapping(value="/{id}")
	public ResponseEntity<MovieDTO> findById(@PathVariable Long id){
		Movie obj = movieService.findById(id);
		return ResponseEntity.ok().body(new MovieDTO(obj));
	}

	//FIND BY TITLE
    @GetMapping("/title/{title}")
    public ResponseEntity<List<Movie>> getMoviesByTitle(@PathVariable String title) {
        List<Movie> movies = movieService.findMoviesByTitle(title);
        if (movies.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
			return ResponseEntity.ok(movies);
        }
    }


	//FIND BY STUDIO
	@GetMapping(value = "/studio/{studio}")
	public ResponseEntity<List<Movie>> getMovieByStudio(@PathVariable String studio){
		List<Movie> movies = movieService.findMovieByStudio(studio);
		if (movies.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(movies);
		}
	}

	//FIND BY GENDER
	@GetMapping(value = "/gender/{gender}")
	public ResponseEntity<List<Movie>> getMovieByGender(@PathVariable String gender) {
		List<Movie> movies = movieService.findMovieByGender(gender);
		if (movies.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(movies);
		}
	}
	//FIND BY ORIGINAL LANGUAGE
	@GetMapping(value = "/originalLanguage/{originalLanguage}")
	public ResponseEntity<List<Movie>> getMovieByOriginalLanguage(@PathVariable String originalLanguage) {
		List<Movie> movies = movieService.findMovieByOriginalLanguage(originalLanguage);
		if (movies.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(movies);
		}
	}
	//FIND BY COUNTRY OF ORIGIN
	@GetMapping(value = "/countryoforigin/{countryoforigin}")
	public ResponseEntity<List<Movie>> getMovieByCountryOfOrigin(@PathVariable String countryoforigin) {
		List<Movie> movies = movieService.findMovieByCountryOfOrigin(countryoforigin);
		if (movies.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(movies);
		}
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
