package com.api.catalogo_filmes;

import com.api.catalogo_filmes.service.CrudMovieService;
import com.api.catalogo_filmes.service.CrudUserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatalogoFilmesApplication {

	public CatalogoFilmesApplication() {
		// Pode ser vazio ou conter inicializações necessárias
	}

	public static void main(String[] args) {
		SpringApplication.run(CatalogoFilmesApplication.class, args);
	}

	/*--------- SERVICE MOVIE -------*/
	private CrudMovieService movieService;
	public CatalogoFilmesApplication(CrudMovieService movieService){
		this.movieService = movieService;
	}

    private CrudUserService userService;
	public CatalogoFilmesApplication(CrudUserService userService){
		this.userService = userService;
	}


	public void run(String... args) throws Exception{
		this.movieService.insertData();
        this.userService.insertData();
	}
}
