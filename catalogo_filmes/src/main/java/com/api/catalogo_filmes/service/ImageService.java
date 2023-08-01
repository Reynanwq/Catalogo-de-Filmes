package com.api.catalogo_filmes.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.catalogo_filmes.entities.Image;

@Service
public interface ImageService {
    public Image create(Image image);
    public List<Image> viewAll();
    public Image viewById(long id);
}