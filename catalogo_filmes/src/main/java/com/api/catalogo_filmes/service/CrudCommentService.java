package com.api.catalogo_filmes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.catalogo_filmes.entities.Comment;
import com.api.catalogo_filmes.entities.Comment;
import com.api.catalogo_filmes.repository.CommentRepository;


@Service
public class CrudCommentService {
	@Autowired
	private CommentRepository CommentRepository;
	public List<Comment>findALL(){
		return CommentRepository.findAll();
	}
	
	public Comment findById(Long id) {
		Optional<Comment> obj =CommentRepository.findById(id);
		return obj.get();
	}
	public Comment insert(Comment obj) {
		return CommentRepository.save(obj);
	}
	public void delete(Long id) {
	       CommentRepository.deleteById(id);			
	} 
	
	public Comment update(Long id, Comment obj) {
		Comment entity = CommentRepository.getReferenceById(id);
		updateData(entity,obj);
		return CommentRepository.save(entity);
	}

	private void updateData(Comment entity, Comment obj) {
		if(obj.getText()!=null) {
			entity.setText(obj.getText());
		}
	}
	
	
}
