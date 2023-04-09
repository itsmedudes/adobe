package com.app.Service;

import java.util.List;

import com.app.Dto.NewPostCreateDto;
import com.app.Dto.PostUpdateDto;
import com.app.Exception.PostException;
import com.app.Exception.UserException;
import com.app.Model.Post;

public interface PostService {
	
	public Post createNewPost(NewPostCreateDto post) throws PostException,UserException;
	
	public Post retrievePostById(Long postId) throws PostException;
	
	public Post updatePostContent(Long id,PostUpdateDto postDto) throws PostException;
	
	public String deletePostById(Long id) throws PostException;
	
	public String likeOnPost(Long id) throws PostException;
	
	public String unlikeOnPost(Long id) throws PostException;
	
	//total post count
	public Long totalNumberOfPost() throws PostException;
	
	//find top 5 most like post
	public List<Post> topfiveLikedPost() throws PostException;
}
