package com.api.catalogo_filmes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.catalogo_filmes.entities.Picture;
import com.api.catalogo_filmes.repository.PictureRepository;

@Service
public class CrudPictureService {

	@Autowired
	private PictureRepository pictureRepository;
	
	public List<Picture> findAll() {
		return pictureRepository.findAll();
	}
	
	public Picture findById(Integer id) {
		Optional<Picture> obj = pictureRepository.findById(id);
		return obj.get();
	}

	public Picture insert(Picture obj) {
		return pictureRepository.save(obj);
	}

	public void delete(Integer id) {
		pictureRepository.deleteById(id);			
	}

	public Picture update(Integer id, Picture obj) {
    Optional<Picture> optionalEntity = pictureRepository.findById(id);
    if (optionalEntity.isPresent()) {
        Picture entity = optionalEntity.get();
        updateData(entity, obj);
        return pictureRepository.save(entity);
    }else {
        return null;
     }
    }

	 private void updateData(Picture entity, Picture obj) {
        if (obj.getPoster_name() != null) {
            entity.setPoster_name(obj.getPoster_name());
        }
        if (obj.getImage() != null) {
            entity.setImage(obj.getImage());
        }
    }
}
