
package com.api.catalogo_filmes.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.catalogo_filmes.dto.UserDTO;
import com.api.catalogo_filmes.entities.User;
import com.api.catalogo_filmes.service.CrudUserService;



@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private CrudUserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = userService.findALL();
		List<UserDTO> listDto= list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable Long id){
		User obj = userService.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}

	@GetMapping(value = "/name/{name}")
	public ResponseEntity<List<User>> getUserByName(@PathVariable String name){
		List<User> users = userService.findUserByName(name);
		if (users.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(users);
		}
	}

	@GetMapping(value = "/gender/{gender}")
	public ResponseEntity<List<User>> findByGender(@PathVariable String gender){
		List<User> users = userService.findUserByGender(gender);
		if (users.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(users);
		}
	}
	
	@PostMapping(value="/create")
	public ResponseEntity<UserDTO> insert(@RequestBody User obj){
		obj=userService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		.buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new UserDTO(obj));
		
	}
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id,@RequestBody UserDTO objDto){
		User obj= userService.fromDTO(objDto);
		obj=userService.update(id, obj);
		return ResponseEntity.noContent().build();
		
	}
	
}
