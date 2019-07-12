/**
 * 
 */
package com.lankesh.test.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.lankesh.controller.PasswordStrengthCheckController;

/**Password strength test
 * @author Lankesh Kumar
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest
@AutoConfigureWebMvc
public class PasswordCheckIntegrationTest {

	@Autowired
	PasswordStrengthCheckController controller;
	
	@Autowired 
	MockMvc mockMvc;
	
	@Test
	public void when_passed_null_or_empty_then_error_response() throws Exception {
		
		inValidInput("password", "");
	}

	@Test
	public void when_passed_less_than_min_length__then_error_response() throws Exception {
		
		inValidInput("password", "test");		
	}
	
	@Test
	public void when_passed_greater_than_max_length__then_error_response() throws Exception {
		
		inValidInput("password", "I am greater than 12 length");	
	}
	
	@Test
	public void when_passed_repeating_character_then_success_response() throws Exception {

		validInput("password", "repeeatte1");	
	}
	
	@Test
	public void when_passed_repeating_ttpeeatte1_character_then_error_response() throws Exception {

		inValidInput("password", "ttpeeatte1");	
	}
	
	@Test
	public void when_passed_valid_then_sucess_response() throws Exception {

		validInput("password", "validpasw12");	
	}

	@Test
	public void when_passed_valid_test1123_then_sucess_response() throws Exception {

		validInput("password", "test1123");	
	}
	
	@Test
	public void when_passed_invalid_then_error_response() throws Exception {

		inValidInput("password", "vaLidpasw12");	
	}
	
	@Test
	public void when_passed_invalid_aaa234_then_error_response() throws Exception {

		inValidInput("password", "aaa234");	
	}
	

	/**
	 * Reuse test creation
	 * @param param
	 * @param paramValue
	 * @throws Exception
	 */
	private void inValidInput(String param, String paramValue) throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/check-password-strength")
				.param(param, paramValue)
				.contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(MockMvcResultMatchers.status().isBadRequest())
		.andDo(MockMvcResultHandlers.print());
	}
	
	/**
	 * Reuse test creation
	 * @param param
	 * @param paramValue
	 * @throws Exception
	 */
	private void validInput(String param, String paramValue) throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/check-password-strength")
				.param(param, paramValue)
				.contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print());
	}
}
