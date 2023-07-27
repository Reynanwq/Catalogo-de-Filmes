package com.api.catalogo_filmes.repository;

import com.api.catalogo_filmes.arm.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {
}
