/**
 * 
 */
package com.crd.rental.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Rental request details
 * @author Lankesh Kumar
 *
 */
public class RentalRequest {

	/**
	 * @return the reservations
	 */
	public List<Reservation> getReservations() {
		if (reservations == null) {
			reservations = new ArrayList<>();
		}
		return reservations;
	}

	/**
	 * @param reservations the reservations to set
	 */
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	/** Rental details */
	List<Reservation> reservations;

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RentalRequest [reservations=" + reservations + "]";
	}
	
	
	
}
