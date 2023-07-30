package com.api.catalogo_filmes.service;

import com.api.catalogo_filmes.entities.Comment;
import com.api.catalogo_filmes.repository.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CrudCommentService {
    private CommentRepository commentRepository;
    public CrudCommentService(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }
    public void insertData(){
        //Comment avaliacao_do_jorge = new Comment((1, "Jorge Jesus", "21/07/2010", "Que filme bosta", "12:30h");
       // this.commentRepository.save(avaliacao_do_jorge);
        System.out.println("comment insert with sucess");
    }
}
