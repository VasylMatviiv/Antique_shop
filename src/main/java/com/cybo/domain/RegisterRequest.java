package com.cybo.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.cybo.validator.CheckPasswordsMatch;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
@CheckPasswordsMatch
public class RegisterRequest {
	
	@Pattern(regexp = "[a-zA-Z].+[a-zA-Z0-9+.]+@[A-Za-z]{2,5}+.[A-Za-z]{2,4}$", message = "Typed email has not correct format")
	@NotEmpty private String email;
	@NotEmpty private String firstName;
	@NotEmpty private String lastName;
	@NotEmpty private int age;
	@NotNull private String password;
	@NotEmpty private String passwordConfirmation;

}
