/**
 * 
 */
package com.lankesh.exception.handler;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.lankesh.entity.ApiMessage;
import com.lankesh.entity.Severity;

/**
 * Transofrms constraint violation exceptions into readable format
 * @author Lankesh Kumar 
 *
 */
@ControllerAdvice
public class ConstraintViolationsHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ ConstraintViolationException.class })
	public ResponseEntity<Object> handleConstraintViolation(
	  ConstraintViolationException ex, WebRequest request) {
		
		List<ApiMessage> messages = new ArrayList<>();
		ex.getConstraintViolations().forEach(con -> {
			messages.add(new ApiMessage("VALIDATION-ERROR",  con.getMessage(), Severity.ERROR));
		});
		
	    return new ResponseEntity<Object>(
	    		messages, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}
}
