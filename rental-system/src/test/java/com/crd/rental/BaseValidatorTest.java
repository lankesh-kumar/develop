package com.crd.rental;

import java.util.Calendar;
import java.util.List;

import com.crd.rental.entity.CarType;
import com.crd.rental.entity.RentalRequest;
import com.crd.rental.entity.Reservation;

public class BaseValidatorTest {

	public BaseValidatorTest() {
		super();
	}

	/**
	 * @return
	 */
	public RentalRequest create_Request_For_Perform_Over_Lapping_Dates_Check_Fail_For_Each_Car_Type() {
		RentalRequest request = new RentalRequest();
		
		List<Reservation> reservations = request.getReservations();		
		
		reservations.add(new Reservation(CarType.COMPACT, date(2019,1,2,2,30), date(2019,1,2,8,30)));	
		reservations.add(new Reservation(CarType.COMPACT, date(2019,1,3,4,30), date(2019,1,2,9,30)));	
		reservations.add(new Reservation(CarType.COMPACT, date(2019,1,2,5,30), date(2019,1,2,7,30)));
		reservations.add(new Reservation(CarType.COMPACT, date(2019,1,3,3,0), date(2019,1,2,9,30)));
		reservations.add(new Reservation(CarType.COMPACT, date(2019,1,4,5,30), date(2019,1,2,7,30)));
		reservations.add(new Reservation(CarType.COMPACT, date(2019,1,3,3,0), date(2019,1,2,9,30)));
		reservations.add(new Reservation(CarType.SUV, date(2019,1,2,4,30), date(2019,1,2,9,30)));	
		reservations.add(new Reservation(CarType.SUV, date(2019,1,2,5,30), date(2019,1,2,9,30)));	
		reservations.add(new Reservation(CarType.SUV, date(2019,1,2,6,30), date(2019,1,2,11,30)));	
		reservations.add(new Reservation(CarType.MINI_VAN, date(2019,1,2,1,30), date(2019,1,2,12,30)));		
		reservations.add(new Reservation(CarType.MINI_VAN, date(2019,1,3,1,30), date(2019,1,2,12,30)));	
		reservations.add(new Reservation(CarType.MINI_VAN, date(2019,1,3,4,30), date(2019,1,2,6,30)));	
		reservations.add(new Reservation(CarType.MINI_VAN, date(2019,1,5,1,30), date(2019,1,2,12,30)));
		return request;
	}

	/**
	 * @return
	 */
	public RentalRequest create_Perform_Over_Lapping_Dates_Check_Pass_For_More_Count_But_No_Overlapping() {
		RentalRequest request = new RentalRequest();
		
		List<Reservation> reservations = request.getReservations();		
		
		reservations.add(new Reservation(CarType.COMPACT, date(2019,1,2,2,30), date(2019,1,2,8,30)));	
		reservations.add(new Reservation(CarType.COMPACT, date(2019,1,3,4,30), date(2019,1,2,9,30)));	
		reservations.add(new Reservation(CarType.COMPACT, date(2019,1,4,5,30), date(2019,1,2,7,30)));
		reservations.add(new Reservation(CarType.COMPACT, date(2019,1,5,3,0), date(2019,1,2,9,30)));
		reservations.add(new Reservation(CarType.COMPACT, date(2019,1,6,5,30), date(2019,1,2,7,30)));
		reservations.add(new Reservation(CarType.COMPACT, date(2019,1,2,3,0), date(2019,1,2,9,30)));
		reservations.add(new Reservation(CarType.SUV, date(2019,1,2,4,30), date(2019,1,2,9,30)));	
		reservations.add(new Reservation(CarType.SUV, date(2019,1,3,4,30), date(2019,1,2,9,30)));	
		reservations.add(new Reservation(CarType.SUV, date(2019,1,4,4,30), date(2019,1,2,9,30)));	
		reservations.add(new Reservation(CarType.MINI_VAN, date(2019,1,2,1,30), date(2019,1,2,12,30)));		
		reservations.add(new Reservation(CarType.MINI_VAN, date(2019,1,3,1,30), date(2019,1,2,12,30)));	
		reservations.add(new Reservation(CarType.MINI_VAN, date(2019,1,4,1,30), date(2019,1,2,12,30)));	
		reservations.add(new Reservation(CarType.MINI_VAN, date(2019,1,5,1,30), date(2019,1,2,12,30)));
		return request;
	}

	/**
	 * @return
	 */
	public RentalRequest create_Perform_Over_Lapping_Dates_Check_All_Fail() {
		RentalRequest request = new RentalRequest();
		
		List<Reservation> reservations = request.getReservations();		
		
		reservations.add(new Reservation(CarType.COMPACT, date(2019,1,2,2,30), date(2019,1,2,8,30)));	
		reservations.add(new Reservation(CarType.COMPACT, date(2019,1,2,4,30), date(2019,1,2,9,30)));	
		reservations.add(new Reservation(CarType.COMPACT, date(2019,1,2,5,30), date(2019,1,2,7,30)));
		reservations.add(new Reservation(CarType.COMPACT, date(2019,1,2,3,0), date(2019,1,2,9,30)));
		reservations.add(new Reservation(CarType.SUV, date(2019,1,2,4,30), date(2019,1,2,9,30)));	
		reservations.add(new Reservation(CarType.MINI_VAN, date(2019,1,2,1,30), date(2019,1,2,12,30)));
		return request;
	}

	/**
	 * @return
	 */
	public RentalRequest create_Perform_Over_Lapping_Dates_Check_Pass() {
		RentalRequest request = new RentalRequest();
		
		List<Reservation> reservations = request.getReservations();		
		
		reservations.add(new Reservation(CarType.COMPACT, date(2019,1,2,2,30), date(2019,1,2,8,30)));	
		reservations.add(new Reservation(CarType.COMPACT, date(2019,1,2,4,30), date(2019,1,2,9,30)));	
		reservations.add(new Reservation(CarType.SUV, date(2019,1,2,4,30), date(2019,1,2,9,30)));	
		reservations.add(new Reservation(CarType.MINI_VAN, date(2019,1,2,1,30), date(2019,1,2,12,30)));
		return request;
	}

	/**
	 * util method to create Calendar date object
	 * @param year
	 * @param month
	 * @param day
	 * @param hour
	 * @param min
	 * @return
	 */
	private Calendar date(int year, int month, int day, int hour, int min) {
		
		Calendar date = Calendar.getInstance();
		
		date.set(year, month, day, hour, min);
		
		return date;
	}

}