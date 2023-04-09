package com.app.Dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDto {
		
	@NotNull(message = "Name not be null")
	@Size(min=1, max=50, message = "Name size must be between 1 to 50 characters")
	private String name;
	
	@Size(max =200,message="Bio not be more than 200")
	private String bio;
}
