package com.example.ritikkumar.watchlist.entity.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RatingAnotationLogic implements ConstraintValidator<Rating, Double>{

	@Override
	public boolean isValid(Double value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return value >= 5 && value <= 10;
	}
	
}
