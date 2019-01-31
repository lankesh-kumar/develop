/**
 * 
 */
package com.crd.rental.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Reservation details for a day
 * @author Lankesh Kumar
 *
 */
public class Reservation {

	/** Car type */
	CarType carType;
	
	/** Start of rental */
	Calendar start;

	/** End of rental */
	Calendar end;
	
	/** no of days. end date will be ignored only time will be considered */
	Integer noOfDays;
	
	/**
	 * 
	 * @param carType
	 * @param start
	 * @param end
	 */
	public Reservation(CarType carType, Calendar start, Calendar end) {
		super();
		this.carType = carType;
		this.start = start;
		this.end = end;
	}

	/**
	 * @return the carType
	 */
	public CarType getCarType() {
		return carType;
	}

	/**
	 * @param carType the carType to set
	 */
	public void setCarType(CarType carType) {
		this.carType = carType;
	}

	/**
	 * @return the start
	 */
	public Calendar getStart() {
		return start;
	}

	/**
	 * @param start the start to set
	 */
	public void setStart(Calendar start) {
		this.start = start;
	}

	/**
	 * @return the end
	 */
	public Calendar getEnd() {
		return end;
	}

	/**
	 * @param end the end to set
	 */
	public void setEnd(Calendar end) {
		this.end = end;
	}

	/**
	 * @return the noOfDays
	 */
	public Integer getNoOfDays() {
		return noOfDays;
	}

	/**
	 * @param noOfDays the noOfDays to set
	 */
	public void setNoOfDays(Integer noOfDays) {
		this.noOfDays = noOfDays;
	}

	/**
	 * Custom clone method
	 */
	public Reservation clone() {
		
		Reservation res = new Reservation(this.carType, this.start, this.end);
		
		return res;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
		return "Reservation [carType=" + carType + ", start=" + sdf.format(start.getTime()) + ", end=" + sdf.format(end.getTime()) + ", noOfDays=" + noOfDays + "]";
	}
	
	
	
	
}
