package com.example.ritikkumar.watchlist.entity.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RatingAnotationLogic.class)
public @interface Rating {
String message() default "Please enter the rating b/w 5 to 10";
	
	Class<?>[]groups()default{};
	Class<? extends Payload>[] payload() default{};
}
