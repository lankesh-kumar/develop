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
		mockMvc.perform(MockMvcRequestBuilders.get("/check-password-strength")
				.param("password", "")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(MockMvcResultMatchers.status().isBadRequest())
		.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void when_passed_less_than_min_length__then_error_response() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/check-password-strength")
				.param("password", "test")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(MockMvcResultMatchers.status().isBadRequest())
		.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void when_passed_greater_than_max_length__then_error_response() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/check-password-strength")
				.param("password", "I am greater than 12 length")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(MockMvcResultMatchers.status().isBadRequest())
		.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void when_passed_repeating_character_then_error_response() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/check-password-strength")
				.param("password", "repeeate17")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(MockMvcResultMatchers.status().isBadRequest())
		.andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void when_passed_valid_then_sucess_response() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/check-password-strength")
				.param("password", "validpasw12")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void when_passed_invalid_then_error_response() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/check-password-strength")
				.param("password", "vaLidpasw12")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(MockMvcResultMatchers.status().isBadRequest())
		.andDo(MockMvcResultHandlers.print());
	}
}
