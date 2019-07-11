/**
 * 
 */
package com.lankesh.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Password validator
 * @author Lankeh Kumar
 *
 */
@Component("passwordValidator")
public class PasswordValidator implements IValidator {

	
	@Override
	public List<Message> validate(String argInput) {
		
		//list of validation errors
		List<Message> messageList = new ArrayList<>();
		
		if (StringUtils.isEmpty(argInput)) {//null or empty check
			messageList.add(new Message("ERR-EMPTY", "Input is empty"));
		} 
		else if (argInput.length() < 5) { //min length check
			messageList.add(new Message("ERR-MIN-LEN", "Minium of 5 Characters are required"));
		} 
		else if (argInput.length() > 12) { //max length check
			messageList.add(new Message("ERR-MAX-LEN", "Maximum of 12 Characters are allowed"));
		} 
		else if (!argInput.matches("[a-z]+[0-9]+")) { //small case aplha numeric check with at least one character of each type present
			messageList.add(new Message("ERR-ALPHA-NUM-ONLY", "Only small case alpha and numeric values are allowed"));
		} 
		else {//validate for same character repeating twice scenario
			char[] arr = argInput.toCharArray();
			for (int i = 0; i < arr.length-1; i++) {
				if (arr[i] == arr[i+1]) {
					messageList.add(new Message("ERR-REPEAT", String.format("Same character' %s' is repeating more than once", arr[i])));
					break;
				}
			}
		}
		
		return messageList;
	}

}
