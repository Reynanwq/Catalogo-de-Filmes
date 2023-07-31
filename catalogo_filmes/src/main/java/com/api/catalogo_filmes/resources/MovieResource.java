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

    private static String posterPath = "/home/reynan/Vídeos/Catalogo de Filmes/catalogo_filmes/img"; 
	
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
        if (obj == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping(value="/create")
	public ResponseEntity<Movie> insert(@RequestBody Movie obj){
        if(obj.getTitle() == null || obj.getSynopsis() == null){
            return ResponseEntity.badRequest().build();
        }

		//obj=movieService.insert(obj);
		//URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		//.buildAndExpand(obj.getId()).toUri();
		Movie savedMovie = movieService.insert(obj);
        return ResponseEntity.ok().body(savedMovie);
		//return ResponseEntity.ok().body(obj);
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

    @PostMapping(value="/{id}/poster")
    public ResponseEntity<Movie> insertPoster(@PathVariable Long id, @RequestBody String posterPath) {
        Movie movie = movieService.findById(id);
        if (movie == null) {
            return ResponseEntity.notFound().build();
        }

        movie.setPoster(posterPath);
        movie = movieService.update(id, movie);

        return ResponseEntity.ok().body(movie);
    }

}
