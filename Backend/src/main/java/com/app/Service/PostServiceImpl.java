package com.app.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Dto.NewPostCreateDto;
import com.app.Dto.PostUpdateDto;
import com.app.Exception.PostException;
import com.app.Exception.UserException;
import com.app.Model.Post;
import com.app.Model.User;
import com.app.Repository.PostRepository;
import com.app.Repository.UserRepository;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public Post createNewPost(NewPostCreateDto post) throws PostException, UserException {
		Optional<User> user = userRepository.findById(post.getUser_id());
		if(user.isEmpty()) throw new UserException("User not Exist With this Id : "+post.getUser_id());
		else {
	
			Post newPost = new Post();
			newPost.setContent(post.getContent());
			newPost.setCreated_at(new Date(System.currentTimeMillis()));
			newPost.setUser(user.get());
			newPost.setLikes(0);
			return postRepository.save(newPost);
		}
	}


	@Override
	public Post retrievePostById(Long id) throws PostException{
		return postRepository.findById(id).orElseThrow(() -> new PostException("Not found any post with this id: "+id));
	}

	@Override
	public Post updatePostContent(Long postId, PostUpdateDto postDto) throws PostException {
		Optional<Post> post = postRepository.findById(postId);
		
		if(post.isEmpty()) throw new PostException("Post is not exist With this id: "+postId);
		else {
			Post newPost = post.get();
			newPost.setContent(postDto.getContent());
			newPost.setUpated_at(new Date(System.currentTimeMillis()));
			
			return postRepository.save(newPost);
		}

	}

	@Override
	public String deletePostById(Long id) throws PostException{
		Optional<Post> post = postRepository.findById(id);
		
		if(post.isEmpty()) throw new PostException("Post is not exist With this id: "+id);
		else {
			postRepository.delete(post.get());
			return "Delete SucessFully";
		}
	}

	@Override
	public String likeOnPost(Long id) throws PostException {
		Optional<Post> post = postRepository.findById(id);
		
		if(post.isEmpty()) throw new PostException("Post is not exist With this id: "+id);
		else {
			Post likeUpdate = post.get();
			likeUpdate.setLikes(likeUpdate.getLikes()+1);
			postRepository.save(likeUpdate);
			return likeUpdate.getLikes().toString();
		}
	}

	@Override
	public String unlikeOnPost(Long id) throws PostException{
		Optional<Post> post = postRepository.findById(id);
		
		if(post.isEmpty()) throw new PostException("Post is not exist With this id: "+id);
		else {
			Post likeUpdate = post.get();
			if(likeUpdate.getLikes()>0) {
				likeUpdate.setLikes(likeUpdate.getLikes()-1);
				postRepository.save(likeUpdate);
			}
			return likeUpdate.getLikes().toString();
		}		
	}

	@Override
	public Long totalNumberOfPost() throws PostException{
		return postRepository.count();
	}

	@Override
	public List<Post> topfiveLikedPost() throws PostException{
//		List<Integer> list = postRepository.findTopFiveAticveUser();

		return null;
	}

	
}
