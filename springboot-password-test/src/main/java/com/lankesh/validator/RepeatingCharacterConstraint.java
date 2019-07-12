/**
 * 
 */
package com.lankesh.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Repeasting character constraint annotation
 * @author Lankesh Kumar
 *
 */
@Documented
@Constraint(validatedBy = RepeatingCharacterValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface RepeatingCharacterConstraint {

	String message() default "Same character is repeating";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
