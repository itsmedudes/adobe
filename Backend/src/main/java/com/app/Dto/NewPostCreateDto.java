package com.app.Dto;

import java.util.Date;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewPostCreateDto {

	
	@NotNull(message = "User id not be blank or null")
	private Long user_id;
	
	@Size(min =1, max=300, message = "content must be between 1 to 300 characters" )
	private String content;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date upated_at;

}
