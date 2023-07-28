package com.api.catalogo_filmes;

import com.api.catalogo_filmes.service.CrudMovieService;
import com.api.catalogo_filmes.service.CrudUserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatalogoFilmesApplication {
	public static void main(String[] args) {
		SpringApplication.run(CatalogoFilmesApplication.class, args);
	}
}
