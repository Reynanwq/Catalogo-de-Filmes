package com.api.catalogo_filmes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.catalogo_filmes.entities.Commentt;

@Repository
public interface CommenttRepository extends JpaRepository<Commentt, Long> {
	
}
