package com.api.catalogo_filmes.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.catalogo_filmes.entities.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User>findAll(){
		User user01 = new User(1, "Cesar", "cesar@gmail.com", "12345678", "01/04/1987", "Male");
		return ResponseEntity.ok().body(user01);
	}

}
