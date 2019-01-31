/**
 * 
 */
package com.crd.rental;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.crd.rental.entity.Message;
import com.crd.rental.entity.RentalRequest;
import com.crd.rental.service.CarRentalService;
import com.crd.rental.service.RentalService;
import com.crd.rental.validator.CarRentalValidator;
import com.crd.rental.validator.Validator;

/**
 * @author Lankesh Kumar
 *
 */
public class RentalValidatorTest extends BaseValidatorTest {

	private static final Logger log = Logger.getLogger( RentalValidatorTest.class.getName() );
	
	static Validator validator;
	
	static RentalService service = null;
	
	List<Message> errors = null;	
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		validator = new CarRentalValidator();
		service = new CarRentalService();
	}
	
	/**
	 * setup before each test
	 */
	@Before
	public void setup() {
		errors = new ArrayList<>();
	}
	
	/**
	 * clean up after each test
	 */
	@After
	public void tearDown() {
		errors = null;
	}	
	

	/**
	 * Pass when there is a overlapping in the request with car type count IS matching with inventory
	 * Test method for {@link com.crd.rental.validator.CarRentalValidator#performOverLappingDatesCheck(com.crd.rental.entity.RentalRequest, java.util.List, java.util.Map)}.
	 */
	@Test
	public void test_Perform_Over_Lapping_Dates_Check_Pass() {
		
		//create request
		RentalRequest request = create_Perform_Over_Lapping_Dates_Check_Pass();		
		
		List<Message> messages = validator.validate(request, service.getInventoryMap());
		log.info("" + messages);
		
		//assert
		assertEquals("Over lapping dates within car count availability has no errors ", 0, messages.size());
		
	}


	/**
	 * Fail when there is a overlapping in the request with car type count NOT matching with inventory
	 */
	@Test
	public void test_Perform_Over_Lapping_Dates_Check_All_Fail() {
		
		//create request
		RentalRequest request = create_Perform_Over_Lapping_Dates_Check_All_Fail();		
		
		List<Message> messages = validator.validate(request, service.getInventoryMap());
		log.info("" + messages);
		
		//assert
		assertNotEquals("Over lapping dates with more cars in the request than in inventory should fail", 0, messages.size());
		
	}

	

	/**
	 * Fail when there is a overlapping in the request with car type count NOT matching with inventory
	 */
	@Test
	public void test_Perform_Over_Lapping_Dates_Check_Pass_For_More_Count_But_No_Overlapping() {
		
		//create request
		RentalRequest request = create_Perform_Over_Lapping_Dates_Check_Pass_For_More_Count_But_No_Overlapping();	
		
		List<Message> messages = validator.validate(request, service.getInventoryMap());
		log.info("" + messages);

		//assert
		assertNotEquals("Over lapping dates with more cars in the request than in inventory should fail", 0, messages.size());
		
	}



	/**
	 * Fail when there is a overlapping in the request with car type count NOT matching with inventory
	 */
	@Test
	public void test_Perform_Over_Lapping_Dates_Check_Fail_For_Each_Car_Type() {
		
		//create request
		RentalRequest request = create_Request_For_Perform_Over_Lapping_Dates_Check_Fail_For_Each_Car_Type();	
		
		List<Message> messages = validator.validate(request, service.getInventoryMap());
		log.info("" + messages);
		
		//assert
		assertNotEquals("Over lapping dates with more cars in the request than in inventory should fail", 0, messages.size());
		
	}
}
