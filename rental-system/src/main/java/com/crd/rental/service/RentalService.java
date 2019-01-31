package com.crd.rental.service;

import java.util.Map;

import com.crd.rental.entity.CarType;
import com.crd.rental.entity.RentalRequest;
import com.crd.rental.entity.RentalResponse;
import com.crd.rental.entity.Reservation;

public interface RentalService {

	/**
	 * Processes the rental request
	 * @param argRequest
	 * @return
	 */
	RentalResponse processRequest(RentalRequest argRequest);

	/**
	 * Another type of request processing based on noOf Days
	 * @param argRequest
	 * @return
	 */
	RentalResponse processRequest(Reservation argRequest);

	Map<CarType, Integer> getInventoryMap();

}