/**
 * 
 */
package com.crd.rental.service;

import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.crd.rental.entity.CarType;
import com.crd.rental.entity.Message;
import com.crd.rental.entity.RentalRequest;
import com.crd.rental.entity.RentalResponse;
import com.crd.rental.entity.Reservation;

/**
 * Service class facilitating various actions for the rental system
 * @author Lankesh Kumar
 *
 */
public class CarRentalService implements RentalService {

	private static final Logger log = Logger.getLogger( CarRentalService.class.getName() );
	
	Validator validator;

	//car inventory config
	final Map<CarType, Integer> inventoryMap = new HashMap<>();
	

	public CarRentalService() {

		inventoryMap.put(CarType.COMPACT, 3);
		inventoryMap.put(CarType.SUV, 2);
		inventoryMap.put(CarType.MINI_VAN, 1);
		
		Collections.unmodifiableMap(inventoryMap);
	}


	/* (non-Javadoc)
	 * @see com.crd.rental.service.RentalService#processRequest(com.crd.rental.entity.RentalRequest)
	 */
	@Override
	public RentalResponse processRequest(RentalRequest argRequest) {
		
		RentalResponse response = new RentalResponse(201);
		
		//validate rental request
		List<Message> validationErrors = validator.validate(argRequest, inventoryMap);
		
		if (validationErrors.size() == 0) { //valid request submit request to db
			
			/*
			 * Generally you would Call DAO method to update details to data base.
			 * here we will just log the successful request
			 */
			//update success message
			response.setStatusMessage("Reservation successfully done.");
			log.info("Request submitted success full as " + argRequest);			
			
		}
		else {
			//update error message
			response.setStatusCode(400);
			response.setStatusMessage("Invalid request please refer api message list in the response for the details");
			
			response.setApiMessageList(validationErrors);
			
			log.warning("Invalid request" + argRequest);
		}
		
		
		return response;
	}


	/* (non-Javadoc)
	 * @see com.crd.rental.service.RentalService#processRequest(com.crd.rental.entity.Reservation)
	 */
	@Override
	public RentalResponse processRequest(Reservation argRequest) {
		RentalRequest request = new RentalRequest();
		
		if (argRequest.getNoOfDays() != null) {
			populateResrevationsUsingNoOfDays(argRequest, request);
		}
		
		// reuse original method
		return processRequest(request);
	}


	/**
	 * @param argRequest
	 * @param request
	 */
	private void populateResrevationsUsingNoOfDays(Reservation argRequest, RentalRequest request) {
		for (int i = 0; i < argRequest.getNoOfDays(); i++) {
			Reservation res = argRequest.clone();
			
			
			int date = argRequest.getStart().get(Calendar.DAY_OF_MONTH)+(i+1);

			//update start date & End date
			res.getStart().set(Calendar.DAY_OF_MONTH, date);
			res.getEnd().set(Calendar.DAY_OF_MONTH, date);
			
			//add to reservation list
			request.getReservations().add(res);
		}
	}


	/**
	 * @return the inventoryMap
	 */
	@Override
	public Map<CarType, Integer> getInventoryMap() {
		return inventoryMap;
	}


	/**
	 * @param validator the validator to set
	 */
	public void setValidator(Validator validator) {
		this.validator = validator;
	}
	
	

}
