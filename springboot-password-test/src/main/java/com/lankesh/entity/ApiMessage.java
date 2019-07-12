/**
 * 
 */
package com.lankesh.entity;

/**
 * @author Lankesh Kumar
 *
 */
public class ApiMessage {

	private String code;
	
	private String message;
	
	/* ERROR, WARNING **/
	private Severity severity;

	
	/**
	 * @param code
	 * @param message
	 * @param severity
	 */
	public ApiMessage(String code, String message, Severity severity) {
		this.code = code;
		this.message = message;
		this.severity = severity;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the severity
	 */
	public Severity getSeverity() {
		return severity;
	}

	/**
	 * @param severity the severity to set
	 */
	public void setSeverity(Severity severity) {
		this.severity = severity;
	}


	
	
}
