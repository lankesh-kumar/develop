/**
 * 
 */
package com.crd.rental.validator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.crd.rental.entity.CarType;
import com.crd.rental.entity.Message;
import com.crd.rental.entity.RentalRequest;
import com.crd.rental.entity.Reservation;

/**
 * Rental Validator
 * 1. Validate more than one same car type can be booked on overlapping times where available cartype quantity is <= total of same cartype in the request
 * 
 * 2. Validate more than one same car type can not be booked on overlapping date and time when car quantiy available is < total no. of same car type in the request
 * 3.  
 * @author Lankesh Kumar
 *
 */
public class CarRentalValidator implements Validator {

	private static final Logger log = Logger.getLogger( CarRentalValidator.class.getName() );
	
	/* (non-Javadoc)
	 * @see com.crd.rental.service.Validator#validate(com.crd.rental.entity.RentalRequest, java.util.Map)
	 */
	@Override
	public List<Message> validate(RentalRequest argRequest, Map<CarType, Integer> argInventoryMap) {
		
		List<Message> errors = new ArrayList<>();
				
		//validate if dates are overlapping, consider counts available while checking
		performOverLappingDatesCheck(argRequest, errors, argInventoryMap);
		
		
		return errors;
	}

	/**
	 * Check if dates are overlapping within car quantities
	 * @param argRequest
	 * @param errors
	 * @param argInventoryMap
	 */
	public void performOverLappingDatesCheck(RentalRequest argRequest, List<Message> errors, Map<CarType, Integer> argInventoryMap) {
		List<Reservation> reservations = argRequest.getReservations();
		if (reservations == null) {
			errors.add(new Message(400, "No reservation data found in the input"));
		}
		else {
			//count each car type in the request
			argInventoryMap.forEach((key, value) -> {
				
				List<Reservation> resByCarType = reservations.stream().filter(p -> p.getCarType() == key).collect(Collectors.toList());
				
					if (resByCarType.size() > value) { //if car count is greater than check if they are overlapping otherwise we are good
						int overLappingCount = 0;
						
						//take top element and compare with other elements
						Reservation top = resByCarType.get(0);
						
						//iterate remaining reservations
						for (int i = 1; i < resByCarType.size(); i++) {
							if (isReservationOverLapping(top, resByCarType.get(i))) {
								overLappingCount++;
							}
						}
						if (overLappingCount >= value) {
							errors.add(new Message(400, "Overlapping reservations found for " + key.name()  + " , please correct them"));
						}
				}
				
				
			});
		}
		
	}

	/**
	 * checks if dates are over lapping on each other
	 * @param argIs
	 * @param argOverLappingOn
	 * @return
	 */
	private boolean isReservationOverLapping(Reservation argIs, Reservation argOverLappingOn) {
		
		boolean isOverLapping = isBetweenTwo(argIs.getStart(), argOverLappingOn.getStart(), argOverLappingOn.getEnd())
				|| isBetweenTwo(argIs.getEnd(), argOverLappingOn.getStart(), argOverLappingOn.getEnd())
				|| isBetweenTwo(argOverLappingOn.getStart(), argIs.getStart(), argIs.getEnd())
				|| isBetweenTwo(argOverLappingOn.getEnd(), argIs.getStart(), argIs.getEnd());
		

		log.info("Is " + argIs + " overlapping with \n   " + argOverLappingOn + " --> " + isOverLapping);
		
		return isOverLapping;
	}

	/**
	 * Checks if first argument falls between next two arguments
	 * @param argDate
	 * @param argStart
	 * @param argEnd
	 */
	private boolean isBetweenTwo(Calendar argDate, Calendar argStart, Calendar argEnd) {
		
		boolean isInBetween = (argDate.equals(argStart) || argDate.after(argStart)) && argDate.before(argEnd);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
		log.info(sdf.format(argDate.getTime()) + " , "+ sdf.format(argStart.getTime()) + " , " + sdf.format(argEnd.getTime()) + " --> " + isInBetween);
		
		return isInBetween;		
	}



}
