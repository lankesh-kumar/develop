/**
 * 
 */
package com.lankesh.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Password strength check annotation combining multiple annotation configurations
 * @author Lankesh Kumar
 *
 */
@Size(min = 5, max = 12, message = "Password length must be min 5 and max 12") 
@Pattern(regexp = "[a-z0-9]*(([a-z]+[0-9]+)|([0-9]+[a-z]+))[a-z0-9]*", message = "Only small case alpha and numeric values are allowed") 
@RepeatingPatternConstraint //can be re-used any where 
@Constraint(validatedBy = {})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordStrengthCheck {
	String message() default "Password Strength check failed";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
