/**
 * 
 */
package com.crd.rental.controller;

import com.crd.rental.entity.RentalRequest;
import com.crd.rental.entity.RentalResponse;
import com.crd.rental.entity.Reservation;
import com.crd.rental.service.RentalService;

/**
 * Entry point to the system.
 * it will delegate requests to appropriate service
 * @author Lankesh Kumar
 *
 */
public class RentalController {

	/** Rental service */
	RentalService service;
	
	/**
	 * Rental request based on list of individual reservations
	 * @param argRequest
	 * @return
	 */
	public RentalResponse createReservation(RentalRequest argRequest) {
		
		RentalResponse response = service.processRequest(argRequest);
		
		return response;
		
	}
	

	/**
	 * Rental reservation based on noOfDays
	 * @param argRequest
	 * @return
	 */
	public RentalResponse createReservation(Reservation argRequest) {
		
		RentalResponse response = service.processRequest(argRequest);
		
		return response;
		
	}


	/**
	 * @param service the service to set
	 */
	public void setService(RentalService service) {
		this.service = service;
	}
	
	
}
