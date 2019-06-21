/**
 * 
 */
package com.lankesh.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lankesh.entity.IValidator;
import com.lankesh.entity.Message;

/**
 * Controller for password check
 * @author lchalava
 *
 */
@RestController
public class PasswordStrengthCheckController {

	@Resource(name="passwordValidator")//inject validator of choice implementation
	IValidator validator;
	
	@PostMapping("/check-password-strength")
	public ResponseEntity<List<Message>> checkPasswordStrength(@RequestParam(name="input") String argInput) {
		
		List<Message> messages = validator.validate(argInput);
		
		HttpStatus status = HttpStatus.BAD_REQUEST;// for invalid input
		
		if (messages.size() == 0) {//success scenario - for valid input
			status = HttpStatus.OK;
			messages.add(new Message("SUCCESS", "Input meets required conditions for password"));
		}
		
		ResponseEntity<List<Message>> response = new ResponseEntity<List<Message>>(messages, status);
		
		return response;
		
	}
	
}
