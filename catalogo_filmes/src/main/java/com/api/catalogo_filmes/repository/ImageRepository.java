package com.api.catalogo_filmes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.catalogo_filmes.entities.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
