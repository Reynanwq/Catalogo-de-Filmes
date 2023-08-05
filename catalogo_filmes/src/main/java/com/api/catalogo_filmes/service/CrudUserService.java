package com.api.catalogo_filmes.service;

import java.util.List;
import java.util.Optional;

import com.api.catalogo_filmes.service.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.catalogo_filmes.dto.UserDTO;
import com.api.catalogo_filmes.entities.User;
import com.api.catalogo_filmes.repository.UserRepository;



@Service
public class CrudUserService {
	@Autowired
	private UserRepository userRepository;
	public List<User>findALL(){
		return userRepository.findAll();
	}

	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow(
				() -> new EntityNotFoundException("id not found " + id));
	}

	public User insert(User obj) {
		return userRepository.save(obj);
	}
	public void delete(Long id) {
	       userRepository.deleteById(id);			
	}
	public User update(Long id, User obj) {
		User entity = userRepository.getReferenceById(id);
		updateData(entity,obj);
		return userRepository.save(entity);
	}

	private void updateData(User entity, User obj) {
		if(obj.getName()!=null) {
			entity.setName(obj.getName());
		}
		if(obj.getEmail()!=null) {
			entity.setEmail(obj.getEmail());
		}
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName() ,null,null,objDto.getDate_birth(), objDto.getGender());
	}
	
	
	
}
