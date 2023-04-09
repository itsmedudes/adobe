package com.app.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorList> allExceptionHandler(Exception e, WebRequest wr){
		MyErrorList error = new MyErrorList();
		error.setLocalDateTime(LocalDateTime.now());
		error.setDetails(e.getMessage());
		error.setMessage(wr.getDescription(false));
		return new ResponseEntity<MyErrorList>(error,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorList> methodArgsInvalid(MethodArgumentNotValidException e,WebRequest wr) {
		MyErrorList err = new MyErrorList();
		err.setLocalDateTime(LocalDateTime.now());
		err.setMessage("Validation Error");
		err.setDetails(e.getBindingResult().getFieldError().getDefaultMessage());
	
		return new ResponseEntity<MyErrorList>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorList> noHandleException(NoHandlerFoundException e,WebRequest req){
		MyErrorList err = new MyErrorList();
		err.setDetails(req.getDescription(false));
		err.setLocalDateTime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		return new ResponseEntity<MyErrorList>(err,HttpStatus.BAD_REQUEST);
	}
	
	//Mannual Exception
	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyErrorList> userExceptionHandler(UserException e,WebRequest req){
		MyErrorList err = new MyErrorList();
		err.setDetails(req.getDescription(false));
		err.setLocalDateTime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		return new ResponseEntity<MyErrorList>(err,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PostException.class)
	public ResponseEntity<MyErrorList> postException(PostException e,WebRequest req){
		MyErrorList err = new MyErrorList();
		err.setDetails(req.getDescription(false));
		err.setLocalDateTime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		return new ResponseEntity<MyErrorList>(err,HttpStatus.BAD_REQUEST);
	}
}
