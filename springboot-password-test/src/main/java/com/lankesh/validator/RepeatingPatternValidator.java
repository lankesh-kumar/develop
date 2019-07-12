/**
 * 
 */
package com.lankesh.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;

/**
 * @author Lankesh Kumar
 * @param <RepeatingPatternConstraint>
 *
 */
public class RepeatingPatternValidator implements ConstraintValidator<RepeatingPatternConstraint, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		//validate for same character repeating twice scenario
		boolean result = true; 
		//check for two characters repeating
		char[] arr = value.toCharArray();
		for (int i = 0; i < arr.length-1; i++) {
			String str = arr[i]+""+arr[i+1];
			if (value.indexOf(str, i+1) != -1) {
	            HibernateConstraintValidatorContext hibernateContext =
	                    context.unwrap( HibernateConstraintValidatorContext.class );

	                hibernateContext.disableDefaultConstraintViolation();
	                hibernateContext.buildConstraintViolationWithTemplate( String.format("Same character' %s' is repeating", str))
	                    .addConstraintViolation();
	                
	            result = false;    
			}
		}
		
		//check for three characters 
		
		//check for three characters repeating
		
		return result;
	}



}
