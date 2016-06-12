package com.ws.processor.dto;

public class VerifyCustomerResDto {
	
	private String responseString;
	
	private boolean validationResponse;

	public String getResponseString() {
		return responseString;
	}

	public void setResponseString(String responseString) {
		this.responseString = responseString;
	}

	public boolean isValidationResponse() {
		return validationResponse;
	}

	public void setValidationResponse(boolean validationResponse) {
		this.validationResponse = validationResponse;
	}



}
