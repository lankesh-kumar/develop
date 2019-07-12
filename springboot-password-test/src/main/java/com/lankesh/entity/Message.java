/**
 * 
 */
package com.lankesh.entity;

/**
 * @author Lankesh Kumar
 *
 */
public class Message {

	/** Unique identifier */
	private String code;
	
	/** Description */
	private String description;
	
	/**
	 * Constructor
	 * @param code
	 * @param description
	 */
	public Message(String code, String description) {
		super();
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
