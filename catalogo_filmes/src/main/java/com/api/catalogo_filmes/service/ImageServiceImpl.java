package com.api.catalogo_filmes.service;

import java.util.List;
import java.util.Optional;

import com.api.catalogo_filmes.dto.ImageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.catalogo_filmes.entities.Image;
import com.api.catalogo_filmes.repository.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public Image create(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public List<Image> viewAll() {
        return (List<Image>) imageRepository.findAll();
    }

    @Override
    public Image viewById(long id) {
        return imageRepository.findById(id).get();
    }

    public Image findById(Long id) {
        Optional<Image> obj = imageRepository.findById(id);
        return obj.get();
    }

    public Image fromDTO(ImageDTO objDto){
        return new Image(objDto.getId(), objDto.getImage(), objDto.getDate());
    }
}