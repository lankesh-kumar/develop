/**
 * 
 */
package com.crd.rental.entity;

/**
 * Message details.
 * used to hold any validations or error messages
 * @author Lankesh Kumar
 *
 */
public class Message {

	/** identifier for message */
	int code;
	
	/** message */
	String message;

	public Message(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Message [code=" + code + ", message=" + message + "]";
	}
	
	
}
