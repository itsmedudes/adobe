package com.app.Dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostUpdateDto {
	
	@Size(min =1, max=300, message = "content must be between 1 to 300 characters" )
	private String content;
	
	
}
