package com.api.catalogo_filmes.resources;

import java.io.IOException;
import java.util.List;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.catalogo_filmes.entities.Picture;
import com.api.catalogo_filmes.service.CrudPictureService;

@RestController
@RequestMapping(value="/pictures")
public class PictureResource {
/*
    private static String posterPath;

    @Autowired
    private ResourceLoader resourceLoader;

    @PostConstruct
    public void init() throws IOException {
        posterPath = resourceLoader.getResource("classpath:img/").getFile().getAbsolutePath();
    }
*/
    @Autowired
    private CrudPictureService pictureService;
	   @GetMapping
    public ResponseEntity<List<Picture>> findAll() {
        List<Picture> list = pictureService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Picture> findById(@PathVariable Integer id) {
        Picture obj = pictureService.findById(id);
        if (obj == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping(value="/create")
    public ResponseEntity<Picture> insert(@RequestBody Picture obj) {
        if (obj.getPoster_name() == null || obj.getImage() == null) {
            return ResponseEntity.badRequest().build();
        }

        Picture savedPicture = pictureService.insert(obj);
        return ResponseEntity.ok().body(savedPicture);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        pictureService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Picture> update(@PathVariable Integer id, @RequestBody Picture obj) {
        obj = pictureService.update(id, obj);
        if (obj == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping(value="/{id}/poster")
    public ResponseEntity<Picture> insertPoster(@PathVariable Integer id, @RequestBody String posterPath) {
        Picture picture = pictureService.findById(id);
        if (picture == null) {
            return ResponseEntity.notFound().build();
        }

        picture.setPoster_name(posterPath);
        picture = pictureService.update(id, picture);

        return ResponseEntity.ok().body(picture);
    }
}
