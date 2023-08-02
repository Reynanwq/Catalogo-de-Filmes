package com.api.catalogo_filmes.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.api.catalogo_filmes.entities.Comment;
import com.api.catalogo_filmes.entities.User;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class UserDTO implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
    private String name;
  
    private String date_birth;
   
    private String gender;
    private Set<Comment> comment=new HashSet<>();
	public UserDTO() {
		
	}
	
	
	public UserDTO(User obj) {
		id=obj.getId();
		name=obj.getName();
		date_birth=obj.getDate_birth();
		gender=obj.getGender();
		comment=obj.getComment();
		
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate_birth() {
		return date_birth;
	}

	public void setDate_birth(String date_birth) {
		this.date_birth = date_birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	public Set<Comment> getComment() {
		return comment;
	}
    
 
    
    
    
    
    
}
