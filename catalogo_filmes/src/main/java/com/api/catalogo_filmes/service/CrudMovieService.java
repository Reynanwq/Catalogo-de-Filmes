package com.api.catalogo_filmes.service;

import com.api.catalogo_filmes.entities.Movie;
import com.api.catalogo_filmes.repository.MovieRepository;
import org.springframework.stereotype.Service;

@Service
public class CrudMovieService {
    private MovieRepository movieRepository;
    public CrudMovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public void insertData(){
        //Movie batman = new Movie(1L, "Batman", "asd", "asd", "asdas", "asdas", "asdasd", "asdasd", "asdasd");

       // this.movieRepository.save(batman);
        System.out.println("Movie add success");
    }
}
