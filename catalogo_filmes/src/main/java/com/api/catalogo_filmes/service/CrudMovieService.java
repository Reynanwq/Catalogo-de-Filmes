package com.api.catalogo_filmes.service;

import com.api.catalogo_filmes.repository.MovieRepository;
import org.springframework.stereotype.Service;
import com.api.catalogo_filmes.arm.Movie;

@Service
public class CrudMovieService {
    private MovieRepository movieRepository;
    public CrudMovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public void insertData(){
        Movie batman = new Movie(1, "Batman", "Reynan", "Reynan, Paulo", "Batman combatendo o crime", "Ação e Terror", 2005, "88 Minutos", "+18 Anos", "Os criticos adoraram o filme", "Warner Bros", "Estados Unidos", "Critica dos usuarios");

        this.movieRepository.save(batman);
        System.out.println("Movie add success");
    }
}
