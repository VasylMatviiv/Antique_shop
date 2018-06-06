package com.cybo.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class IfExistMaker implements ConstraintValidator<IfExistItemMaker, String> {
	
	@Autowired ItemMakerServise itemMakerServise;
	
	
		
		@Override
		public boolean isValid(String title, ConstraintValidatorContext context) {
			if (itemMakerServise.findAll()!=null) {
				return false;
			}
			else {
			return true;
			
		}
		
		}
	}

