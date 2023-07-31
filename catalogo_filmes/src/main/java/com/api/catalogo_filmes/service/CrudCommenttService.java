package com.api.catalogo_filmes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.catalogo_filmes.entities.Commentt;
import com.api.catalogo_filmes.repository.CommenttRepository;


@Service
public class CrudCommenttService {
	
	
	
	@Autowired
	private CommenttRepository commenttRepository;
	
	public List<Commentt>findALL(){
		return commenttRepository.findAll();
	}
	
	public Commentt findById(Long id) {
		Optional<Commentt> obj =commenttRepository.findById(id);
		return obj.get();
	}
	
	public Commentt insert(Commentt obj) {
		return commenttRepository.save(obj);
	}
	public void delete(Long id) {
	       commenttRepository.deleteById(id);			
	} 
	
	public Commentt update(Long id, Commentt obj) {
		Commentt entity = commenttRepository.getReferenceById(id);
		updateData(entity,obj);
		return commenttRepository.save(entity);
		
	}

	private void updateData(Commentt entity, Commentt obj) {	
		
		if(obj.getText()!=null) {
			entity.setText(obj.getText());
			}
		
		
	}
	
	
}
