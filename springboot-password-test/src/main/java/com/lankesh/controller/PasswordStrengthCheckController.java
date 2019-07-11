/**
 * 
 */
package com.lankesh.controller;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lankesh.validator.RepeatingCharacterConstraint;

/**
 * Controller for password check
 * @author Lankesh Kumar
 *
 */
@RestController
@Validated
public class PasswordStrengthCheckController {


	/**
	 * 
	 * @param argPassword password with validations
	 * @return
	 */
	@GetMapping("/check-password-strength")//for demo purpose it is configured as GET instead of POST
	public ResponseEntity<String> checkPasswordStrength(@Size(min = 5, max = 12, message = "Password length must be min 5 and max 12") 
															   @Pattern(regexp = "[a-z0-9]*(([a-z]+[0-9]+)|([0-9]+[a-z]+))[a-z0-9]*", message = "Only small case alpha and numeric values are allowed") 
															   @RepeatingCharacterConstraint //can be re-used any where 													   
															   @RequestParam(name="password") String passsword) {
		
		
		
		
		ResponseEntity<String> response = new ResponseEntity<String>("{\"status\":\"password is valid\"}", HttpStatus.OK);
		
		return response;
		
	}
	
}
