/**
 * 
 */
package com.lankesh.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;

/**
 * @author Lankesh Kumar
 * @param <RepeatingCharacterConstraint>
 *
 */
public class RepeatingCharacterValidator implements ConstraintValidator<RepeatingCharacterConstraint, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		//validate for same character repeating twice scenario
		char[] arr = value.toCharArray();
		for (int i = 0; i < arr.length-1; i++) {
			if (arr[i] == arr[i+1]) {
				
	            HibernateConstraintValidatorContext hibernateContext =
	                    context.unwrap( HibernateConstraintValidatorContext.class );

	                hibernateContext.disableDefaultConstraintViolation();
	                hibernateContext.buildConstraintViolationWithTemplate( String.format("Same character' %s' is repeating more than once", arr[i]))
	                    .addConstraintViolation();
				return false;
			}
		}
		return true;
	}



}
