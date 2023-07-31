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

import com.api.catalogo_filmes.entities.Commentt;
import com.api.catalogo_filmes.service.CrudCommenttService;


@RestController
@RequestMapping(value="/comments")
public class CommenttResource {
	
	@Autowired
	private CrudCommenttService commenttService;
	
	@GetMapping
	public ResponseEntity<List<Commentt>> findAll(){
		List<Commentt> list = commenttService.findALL();
		//List<Commentt> listDto= list.stream().map(x -> new Commentt(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Commentt> findById(@PathVariable Long id){
		Commentt obj = commenttService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping(value="/create")
	public ResponseEntity<Commentt> insert(@RequestBody Commentt obj){
		obj=commenttService.insert(obj);
		//URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		//.buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.ok().body(obj);
		
	}
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		commenttService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Commentt> update(@PathVariable Long id,@RequestBody Commentt obj){
		 obj= commenttService.update(id, obj);
		return ResponseEntity.ok().body(obj);
		
	}
}
