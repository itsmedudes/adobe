package com.app.Service;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.app.Dto.UserUpdateDto;
import com.app.Exception.UserException;
import com.app.Model.User;
import com.app.Repository.PostRepository;
import com.app.Repository.UserRepository;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public User createNewUser(User user) throws UserException {
		
		boolean bool = userRepository.existsByEmail(user.getEmail());
		if(bool) throw new UserException("User already exist With this email: "+user.getEmail());
		user.setCreated_at(new Date(System.currentTimeMillis()));
		return userRepository.save(user);
	}

	@Override
	public User retrieveUserById(Long id) throws UserException {
		Optional<User> user = userRepository.findById(id);
		if(user.isEmpty()) throw new UserException("User not found with this id: "+id);
		else return user.get();
	}

	@Override
	public User updateUserNameAndBio(Long id, UserUpdateDto updateUser) throws UserException{
		Optional<User> user = userRepository.findById(id);
		if(user.isEmpty()) throw new UserException("User not found with this id: "+id);
		else {
			User newUser = user.get();
			newUser.setBio(updateUser.getBio());
			newUser.setName(updateUser.getName());
			newUser.setUpdated_at(new Date(System.currentTimeMillis()));
			
			return userRepository.save(newUser);
		}
	}

	@Override
	public String deleteUserById(Long id) throws UserException{
		Optional<User> user = userRepository.findById(id);
		if(user.isEmpty()) throw new UserException("User not found with this id: "+id);
		else {
			userRepository.delete(user.get());
			return "Sucessfully Deleted";
		}
		
	}

	@Override
	public Long retrieveTheTotalNumberUser() {
		return userRepository.count(); 
	}

	@Override
	public List<User> topFiveActiveUser() throws UserException {
		
		List<User> user = postRepository.findTopFiveAticveUser();
		if(user.isEmpty()) throw new UserException("Not Found any user");
		return user;
	}

}
