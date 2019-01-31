package com.crd.rental.service;

import java.util.List;
import java.util.Map;

import com.crd.rental.entity.CarType;
import com.crd.rental.entity.Message;
import com.crd.rental.entity.RentalRequest;

public interface Validator {

	/**
	 * Performs various validations
	 * @param argRequest
	 * @param argInventoryMap 
	 * @return
	 */
	List<Message> validate(RentalRequest argRequest, Map<CarType, Integer> argInventoryMap);

}