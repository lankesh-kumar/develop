/**
 * 
 */
package com.crd.rental.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Holds details on the result of Rental request
 * @author Lankesh Kumar
 *
 */
public class RentalResponse {

	public RentalResponse(int statusCode) {
		super();
		this.statusCode = statusCode;
	}

	/** Overall status of the request*/
	private int statusCode;
	
	/** Overall status message */
	private String statusMessage;
	
	/** individual message list */
	List<Message> apiMessageList;

	/**
	 * @return the statusCode
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * @return the apiMessageList
	 */
	public List<Message> getApiMessageList() {
		
		if (apiMessageList == null) {
			apiMessageList = new ArrayList<>();
		}
		
		return apiMessageList;
	}

	/**
	 * @param apiMessageList the apiMessageList to set
	 */
	public void setApiMessageList(List<Message> apiMessageList) {
		this.apiMessageList = apiMessageList;
	}

	/**
	 * @return the statusMessage
	 */
	public String getStatusMessage() {
		return statusMessage;
	}

	/**
	 * @param statusMessage the statusMessage to set
	 */
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RentalResponse [statusCode=" + statusCode + ", statusMessage=" + statusMessage + ", apiMessageList="
				+ apiMessageList + "]";
	}

	
}
