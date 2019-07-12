/**
 * 
 */
package com.lankesh.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lankesh.validator.PasswordStrengthCheck;

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
	public ResponseEntity<String> checkPasswordStrength(@PasswordStrengthCheck @RequestParam(name="password") String passsword) {
		
		
		
		
		ResponseEntity<String> response = new ResponseEntity<String>("{\"status\":\"password is valid\"}", HttpStatus.OK);
		
		return response;
		
	}
	
}
