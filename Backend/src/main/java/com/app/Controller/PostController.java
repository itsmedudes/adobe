package com.app.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.Dto.NewPostCreateDto;
import com.app.Dto.PostUpdateDto;
import com.app.Exception.PostException;
import com.app.Exception.UserException;
import com.app.Model.Post;
import com.app.Service.PostService;

@RestController
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@PostMapping("/posts")
	public ResponseEntity<Post> createNewPostHandler(@Validated @RequestBody NewPostCreateDto post) throws PostException,UserException{
		return new ResponseEntity<>(postService.createNewPost(post),HttpStatus.CREATED);
	}
	@GetMapping("/posts/{id}")
	public ResponseEntity<Post> retrieveByPostIdHandler(@PathVariable Long id) throws PostException{
		return new ResponseEntity<>(postService.retrievePostById(id),HttpStatus.OK);
	}
	@PutMapping("/posts/{id}")
	public ResponseEntity<Post> updatePostbyIdHandler(@Validated @PathVariable Long id,@RequestBody PostUpdateDto updateDto) throws PostException{
		return new ResponseEntity<>(postService.updatePostContent(id,updateDto),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/posts/{id}")
	public ResponseEntity<String> deletePostbyIdHandler(@PathVariable Long id) throws PostException{
		return new ResponseEntity<>(postService.deletePostById(id),HttpStatus.OK);
	}
	
	@PostMapping("/posts/{id}/like")
	public ResponseEntity<String> likeCountHandler(@PathVariable Long id) throws PostException{
		return new ResponseEntity<>(postService.likeOnPost(id),HttpStatus.OK);
	}
	
	@PostMapping("/posts/{id}/unlike")
	public ResponseEntity<String> unlikeCountHandler(@PathVariable Long id) throws PostException{
		return new ResponseEntity<>(postService.unlikeOnPost(id),HttpStatus.OK);
	}
	
	@GetMapping("/analytics/posts")
	public ResponseEntity<Long> retrieveTheTotalPostNumberHandler() throws PostException{
		return new ResponseEntity<>(postService.totalNumberOfPost(),HttpStatus.OK);
	}
	@GetMapping("/analytics/posts/top-liked")
	public ResponseEntity<List<Post>> topfiveLikedPostHandler() throws PostException{
		return new ResponseEntity<>(postService.topfiveLikedPost(),HttpStatus.OK);
	}
}
