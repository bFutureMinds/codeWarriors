/**
 * 
 */
package com.ws.processor;

import com.ws.processor.dto.VerifyCustomerResDto;

/**
 * @author Chetan, Rahul
 *
 */
public interface Processor {

	public ResponseDto processChatInput(RequestDto inputData);
	
	public VerifyCustomerResDto verifyCustomer(String cardNumber, String passcode);	
}
