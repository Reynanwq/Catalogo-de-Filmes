package com.api.catalogo_filmes.service;

import java.util.List;
import java.util.Optional;

import com.api.catalogo_filmes.dto.CommentDTO;
import com.api.catalogo_filmes.dto.MovieDTO;
import com.api.catalogo_filmes.entities.Movie;
import com.api.catalogo_filmes.service.exceptions.EntityNotFoundException;
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
		return CommentRepository.findById(id).orElseThrow(
				() -> new EntityNotFoundException("Id not found: " + id));
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
		public Comment fromDTO(CommentDTO objDto){
		return new Comment(objDto.getId(), objDto.getAuthor(), objDto.getMovie(), objDto.getDate(), objDto.getText(), objDto.getTime());
	}
	
	
}
