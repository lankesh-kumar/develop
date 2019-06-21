/**
 * 
 */
package com.lankesh.entity;

import java.util.List;

/**
 * Validator interface
 * @author Lankesh Kumar
 *
 */
public interface IValidator {

	/**
	 * Validate input based on different conditions
	 * @param argInput
	 * @return
	 */
	public List<Message> validate(String argInput);
}
