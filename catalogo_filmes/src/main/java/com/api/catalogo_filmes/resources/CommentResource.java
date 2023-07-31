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

import com.api.catalogo_filmes.entities.Comment;
import com.api.catalogo_filmes.entities.Comment;
import com.api.catalogo_filmes.service.CrudCommentService;


@RestController
@RequestMapping(value="/comments")
public class CommentResource {
	
	@Autowired
	private CrudCommentService commentService;
	
	@GetMapping
	public ResponseEntity<List<Comment>> findAll(){
		List<Comment> list = commentService.findALL();
		//List<Commentt> listDto= list.stream().map(x -> new Commentt(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Comment> findById(@PathVariable Long id){
		Comment obj = commentService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping(value="/create")
	public ResponseEntity<Comment> insert(@RequestBody Comment obj){
		obj=commentService.insert(obj);
		//URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		//.buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.ok().body(obj);
		
	}
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		commentService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Comment> update(@PathVariable Long id,@RequestBody Comment obj){
		 obj= commentService.update(id, obj);
			return ResponseEntity.ok().body(obj);
		
	}
}
