package com.app.Model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Name not be null")
	@Size(min=1, max=50, message = "Name must be between 1 to 50 characters")
	private String name;
	
	@NotNull(message = "Email not be null")
	@Column(unique = true)
	@Email(message = "Not a valid email format")
	private String email;
	
	@Size(max =200,message="Bio not be more than 200")
	private String bio;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated_at;
}
