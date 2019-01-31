/**
 * 
 */
package com.crd.rental.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.junit.Test;

import com.crd.rental.entity.RentalResponse;
import com.crd.rental.service.BaseValidatorTest;
import com.crd.rental.service.CarRentalService;
import com.crd.rental.service.CarRentalValidator;

/**
 * Rental System test
 * @author Lankesh Kumar
 *
 */
public class RentalControllerTest extends BaseValidatorTest {

	private static final Logger log = Logger.getLogger( RentalControllerTest.class.getName() );
	
	/** Rental system */
	static RentalController controller;
	
	/**
	 * prepare environment for testing
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		controller = new RentalController();
		
		CarRentalService service = new CarRentalService();
		service.setValidator(new CarRentalValidator());
		
		controller.setService(service);
	}

	@Test
	public void test_Perform_Over_Lapping_Dates_Check_All_Fail() {
		
		RentalResponse resp = controller.createReservation(create_Perform_Over_Lapping_Dates_Check_All_Fail());
		
		assertNotEquals("Response status code is not 201", 201, resp.getStatusCode());
		
		assertTrue("Api message list has some errors in it with size greater than zero", resp.getApiMessageList().size() > 0);		

		log.info("" + resp);		
	}
	
	@Test
	public void test_Perform_Over_Lapping_Dates_Check_Fail_For_Each_Car_Type() {

		RentalResponse resp = controller.createReservation(create_Request_For_Perform_Over_Lapping_Dates_Check_Fail_For_Each_Car_Type());
		
		assertNotEquals("Response status code is not 201", 201, resp.getStatusCode());
		
		assertTrue("Api message list has some errors in it and with size greater than zero", resp.getApiMessageList().size() > 0);

		log.info("" + resp);				
	}
	
	@Test
	public void test_Perform_Over_Lapping_Dates_Check_Pass() {
		
		RentalResponse resp = controller.createReservation(create_Perform_Over_Lapping_Dates_Check_Pass());
		
		assertEquals("Response status code is 201", 201, resp.getStatusCode());
		
		assertEquals("Api message list has no errors", 0, resp.getApiMessageList().size());
		
		log.info("" + resp);
	}
	
	
	@Test
	public void test_Perform_Over_Lapping_Dates_Check_Pass_For_More_Count_But_No_Overlapping() {
		
		RentalResponse resp = controller.createReservation(create_Perform_Over_Lapping_Dates_Check_Pass());
		
		assertEquals("Response status code is 201", 201, resp.getStatusCode());
		
		assertEquals("Api message list has no errors", 0, resp.getApiMessageList().size());
		
		log.info("" + resp);
		
	}

}
