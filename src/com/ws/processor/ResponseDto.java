/**
 * 
 */
package com.ws.processor;

/**
 * @author Chetan
 *
 */
public class ResponseDto {

	private String answerString;
	
	private String verificationRequired;

	public String getAnswerString() {
		return answerString;
	}

	public void setAnswerString(String answerString) {
		this.answerString = answerString;
	}

	public String isVerificationRequired() {
		return verificationRequired;
	}

	public void setVerificationRequired(String verificationRequired) {
		this.verificationRequired = verificationRequired;
	}
	
	
}
