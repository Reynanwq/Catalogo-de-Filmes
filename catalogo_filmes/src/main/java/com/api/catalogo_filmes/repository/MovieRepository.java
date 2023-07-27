package com.api.catalogo_filmes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.catalogo_filmes.entities.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
}
