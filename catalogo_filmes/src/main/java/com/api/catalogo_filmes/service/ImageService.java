package com.api.catalogo_filmes.service;

import java.util.List;
import java.util.Optional;

import com.api.catalogo_filmes.dto.CommentDTO;
import com.api.catalogo_filmes.dto.ImageDTO;
import com.api.catalogo_filmes.entities.Comment;
import com.api.catalogo_filmes.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.catalogo_filmes.entities.Image;

@Service
public interface ImageService {
    public Image create(Image image);
    public List<Image> viewAll();
    public Image viewById(long id);


}