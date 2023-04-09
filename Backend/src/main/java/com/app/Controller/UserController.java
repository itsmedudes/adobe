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

import com.app.Dto.UserUpdateDto;
import com.app.Exception.UserException;
import com.app.Model.User;
import com.app.Service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/users")
	public ResponseEntity<User> createNewUserHandler(@Validated @RequestBody User user) throws UserException{
		return new ResponseEntity<>(userService.createNewUser(user),HttpStatus.CREATED);
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> retrieveUserByIdHandler(@Validated @PathVariable("id") Long id) throws UserException{
		return new ResponseEntity<>(userService.retrieveUserById(id),HttpStatus.OK);
	} 
	
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUsernameAndBioHandler(@Validated @PathVariable("id") Long id,@RequestBody UserUpdateDto userUpdateDao) throws UserException{
		return new ResponseEntity<>(userService.updateUserNameAndBio(id,userUpdateDao),HttpStatus.OK);
	} 
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deleteUserByIdHandler(@Validated @PathVariable("id") Long id) throws UserException{
		return new ResponseEntity<>(userService.deleteUserById(id),HttpStatus.OK);
	} 
	
	@GetMapping("/analytics/users")
	public ResponseEntity<Long> retrieveTheTotalUserHandler(){
		return new ResponseEntity<>(userService.retrieveTheTotalNumberUser(),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/analytics/users/top-active")
	public ResponseEntity<List<User>> retrieveTheTopFiveUserHandler() throws UserException{
		return new ResponseEntity<>(userService.topFiveActiveUser(),HttpStatus.ACCEPTED);
	}
	
	
}
