package com.api.catalogo_filmes;

import com.api.catalogo_filmes.service.CrudMovieService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatalogoFilmesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogoFilmesApplication.class, args);
	}

	/*--------- SERVICE MOVIE -------*/
	private CrudMovieService movieService;
	public CatalogoFilmesApplication(CrudMovieService movieService){
		this.movieService = movieService;
	}

	public void run(String... args) throws Exception{
		this.movieService.insertData();
	}
}
