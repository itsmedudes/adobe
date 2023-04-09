package com.app.Service;

import java.util.List;

import com.app.Dto.UserUpdateDto;
import com.app.Exception.UserException;
import com.app.Model.User;

public interface UserService {
	
	public User createNewUser(User user) throws UserException;
	
	public User retrieveUserById(Long id)throws UserException;
	
	public User updateUserNameAndBio(Long id,UserUpdateDto updateUser) throws UserException;
	
	public String deleteUserById(Long id) throws UserException;
	
	//Total number of user 
	public Long retrieveTheTotalNumberUser();
	
 
	// find the top five active user based on number of posts.
	public List<User> topFiveActiveUser() throws UserException;
}
