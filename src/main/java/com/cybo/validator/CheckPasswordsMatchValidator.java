package com.cybo.validator;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import com.cybo.domain.RegisterRequest;



@Component
public class CheckPasswordsMatchValidator implements ConstraintValidator<CheckPasswordsMatch, RegisterRequest> {
	
	@Override
	public void initialize(CheckPasswordsMatch constraintAnnotation) {
		
	}
	
	public boolean isValid(RegisterRequest user, ConstraintValidatorContext context) {
		
		if(user.getPassword() == null || user.getPasswordConfirmation() == null) {
			return false;
		}
		
		if(user.getPassword().equals(user.getPasswordConfirmation())) {
			return true;
	}
		
		return false;
	}

}
