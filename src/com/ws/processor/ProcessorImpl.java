package com.ws.processor;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ws.dbconnection.DBConnection;
import com.ws.processor.dto.VerifyCustomerResDto;
import com.ws.utils.StringUtils;
import com.ws.va.domain.QuestionBank;

public class ProcessorImpl implements Processor {

	@Override
	public ResponseDto processChatInput(RequestDto inputData) {
		ResponseDto result = new ResponseDto();
		List<String> searchStmtList = new ArrayList<String>();
		searchStmtList.add(inputData.getSearchString()); // add complete chat input for search
		
		// remove extra words from chat input
		List<String> resultList = StringUtils.removeExtraWords(inputData.getSearchString());
		
		searchStmtList = StringUtils.prepareSearchStmt(resultList); // prepare list of words for further search
		DBConnection db = new DBConnection();
		
		List<QuestionBank> questionBankData = db.getQuestionBankData();

		resultList.add(inputData.getSearchString());
		QuestionBank qb = getValidResponse(questionBankData, resultList);
		// TODO : call database with searchStmtList
		result.setAnswerString(qb.getAnswer());
		result.setVerificationRequired(qb.getVerify());
		return result;
	}

	private QuestionBank getValidResponse(List<QuestionBank> questionBankData, List<String> finalSearchList) {
		QuestionBank finalConfirmedData = new QuestionBank();
		QuestionBank mixData = new QuestionBank();
		List<QuestionBank> mixDataList = new ArrayList<QuestionBank>();
		QuestionBank finalData = new QuestionBank();
		int matchedNumber = 0;
		int ctr = 0;
		for (int i = 0; i < finalSearchList.size(); i++) {
			String searchString = finalSearchList.get(i);
			for (int j = 0; j < questionBankData.size(); j++) {
				QuestionBank dataItr = questionBankData.get(j);
				if (dataItr.getQuestion().toLowerCase().contains(searchString.toLowerCase())) {
					finalConfirmedData.setQuestionId(dataItr.getQuestionId());
					finalConfirmedData.setTopicId(dataItr.getTopicId());
					finalConfirmedData.setCatId(dataItr.getCatId());
					finalConfirmedData.setAmbiguity(dataItr.getAmbiguity());
					finalConfirmedData.setAnswer(dataItr.getAnswer());
					finalConfirmedData.setQuestion(dataItr.getQuestion());
					finalConfirmedData.setVerify(dataItr.getVerify());
					finalData.copy(finalConfirmedData);
					break;
				} /*else if (dataItr.getQuestion().contains(searchString)) {
					matchedNumber++;
					mixData = new QuestionBank();
					mixData.setPercentageData(searchString, matchedNumber);
					mixDataList.add(mixData);
				}*/
			}
			//mixDataList.add(mixData);
		}
		//System.out.println("percentage : " + mixDataList.get(0).getPercentageData().size());
/*		for (QuestionBank data : questionBankData) {
			if (data.getQuestion().equals(finalSearchString)) {
				finalConfirmedData.setQuestionId(data.getQuestionId());
				finalConfirmedData.setTopicId(data.getTopicId());
				finalConfirmedData.setCatId(data.getCatId());
				finalConfirmedData.setAmbiguity(data.getAmbiguity());
				finalConfirmedData.setAnswer(data.getAnswer());
				finalConfirmedData.setQuestion(data.getQuestion());
				finalConfirmedData.setVerify(data.getVerify());
				matchedNumber++;
				finalData.copy(finalConfirmedData);
				break;
			} else if (data.getQuestion().contains(finalSearchString)) {
				mixData.setQuestionId(data.getQuestionId());
				mixData.setTopicId(data.getTopicId());
				mixData.setCatId(data.getCatId());
				mixData.setAmbiguity(data.getAmbiguity());
				mixData.setAnswer(data.getAnswer());
				mixData.setQuestion(data.getQuestion());
				mixData.setVerify(data.getVerify());
				mixData.setNumberOfRecordsReturned(matchedNumber++);
				finalData.copy(mixData);
			}
		}*/
		System.out.println("number of match" + matchedNumber);
		return finalConfirmedData;
	}

	@Override
	public VerifyCustomerResDto verifyCustomer(String cardNumber, String passcode) {
		VerifyCustomerResDto verifyCustomerResponse = new VerifyCustomerResDto();
		if(StringUtils.checkCreditCard(cardNumber)){
			verifyCustomerResponse.setResponseString("Please enter correct Card Number");
		}
		
		//Call Actual Customer DB here
		String creditCardNumber = "4000000000000002";
		String secretNumber = "123321";
		
		if(secretNumber.equalsIgnoreCase(passcode) && creditCardNumber.equalsIgnoreCase(cardNumber)){
			verifyCustomerResponse.setResponseString("It's correct. That was smooth. Isn't it?");
			verifyCustomerResponse.setValidationResponse(true);
		} else{
			verifyCustomerResponse.setResponseString("I'm afraid that doesn't seem to be a correct passcode");
			verifyCustomerResponse.setValidationResponse(false);
		}
		return verifyCustomerResponse;
	}	
	
}
