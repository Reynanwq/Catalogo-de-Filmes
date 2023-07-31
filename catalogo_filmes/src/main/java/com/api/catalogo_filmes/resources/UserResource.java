package com.api.catalogo_filmes.resources;

import java.util.List;

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

import com.api.catalogo_filmes.entities.User;
import com.api.catalogo_filmes.service.CrudUserService;


@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private CrudUserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = userService.findALL();
		//List<User> listDto= list.stream().map(x -> new User(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = userService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping(value="/create")
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj=userService.insert(obj);
		//URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		//.buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.ok().body(obj);
		
	}
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<User> update(@PathVariable Long id,@RequestBody User obj){
		 obj= userService.update(id, obj);
		return ResponseEntity.ok().body(obj);
		
	}
}
