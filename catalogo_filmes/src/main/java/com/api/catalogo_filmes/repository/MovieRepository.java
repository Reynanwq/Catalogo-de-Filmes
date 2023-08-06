package com.api.catalogo_filmes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.catalogo_filmes.entities.Movie;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByTitle(String title);
    List<Movie> findByStudio(String studio);
    List<Movie> findByGender(String gender);
    List<Movie> findByCountryOfOrigin(String countryOfOrigin);
    List<Movie> findByOriginalLanguage(String originalLanguage);
}
