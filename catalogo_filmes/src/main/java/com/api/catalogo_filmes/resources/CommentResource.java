package com.api.catalogo_filmes.resources;

import com.api.catalogo_filmes.entities.Comment;
import com.api.catalogo_filmes.entities.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/comment")
public class CommentResource {
    @GetMapping
    public ResponseEntity<Comment> findAll(){
        Comment avaliacao_do_jorge = new Comment(1, "Jorge Jesus", "21/07/2010", "Que filme bosta", "12:30h");
        return ResponseEntity.ok().body(avaliacao_do_jorge);
    }
}
