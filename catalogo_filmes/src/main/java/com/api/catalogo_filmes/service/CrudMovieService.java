package com.api.catalogo_filmes.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Optional;

import com.api.catalogo_filmes.dto.MovieDTO;
import com.api.catalogo_filmes.entities.User;
import com.api.catalogo_filmes.service.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.catalogo_filmes.entities.Movie;
import com.api.catalogo_filmes.repository.MovieRepository;

@Service
public class CrudMovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	public List<Movie>findALL(){
		return movieRepository.findAll();
	}
	
	public Movie findById(Long id) {
		return movieRepository.findById(id).orElseThrow(
				() -> new EntityNotFoundException("Id not found " + id));
	}

    public List<Movie> findMoviesByTitle(String title){
        return movieRepository.findByTitle(title);
    }

	public List<Movie> findMovieByStudio(String studio){ return movieRepository.findByStudio(studio);}

	public List<Movie> findMovieByGender(String gender){ return  movieRepository.findByGender(gender);}

	public List<Movie> findMovieByCountryOfOrigin(String countryOfOrigin){ return  movieRepository.findByCountryOfOrigin(countryOfOrigin);}

	public List<Movie> findMovieByOriginalLanguage(String originalLanguage){ return  movieRepository.findByOriginalLanguage(originalLanguage);}

	public Movie insert(Movie obj) {
		return movieRepository.save(obj);
	}
	public void delete(Long id) {
		movieRepository.deleteById(id);			
	}
	public Movie update(Long id, Movie obj) {
		Movie entity = movieRepository.getReferenceById(id);
		updateData(entity,obj);
		return movieRepository.save(entity);
		
	}
	private void updateData(Movie entity, Movie obj) {
		if(obj.getTitle()!=null) {
			entity.setTitle(obj.getTitle());
		}
	}

    public Movie saveMovie(Movie movie, String posterPath) {
        movie.setPoster(posterPath); 
        return movieRepository.save(movie);
    }

     public Movie insert(Movie obj, String posterPath) {
        obj.setPoster(posterPath); // Define o caminho do poster no objeto Filme
        return movieRepository.save(obj);
    }

	//test
/*	public void insertData(){
		Set<String> caast = new HashSet<>();
		caast.add("Fernando Filmes");
		caast.add( "Aghata Filmes");
		Movie movie = new Movie(null, "reynan", "fwfewf", "fwew", "fwf", "fwfwe", "fwfww", "trgrg", "trgr", "grg", caast);
		movieRepository.saveAll(Arrays.asList(movie));
	}*/

	public Movie fromDTO(MovieDTO objDto){
		return new Movie(objDto.getId(), null, null, null, null, null, null, null, null, null, null);
	}
	
}
