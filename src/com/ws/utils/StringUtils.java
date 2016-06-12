/**
 * 
 */
package com.ws.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Chetan, Rahul
 *
 */
public class StringUtils {

	public static final String EXTRA_WORDS_CSV_PATH = "E:\\hackthon\\code\\chatbot\\VirtualAgentEngine\\src\\ExtraWordsSet.csv";

	public static List<String> removeExtraWords(String str) {
		List<String> splittedInput = new ArrayList<String>();
		splittedInput = Arrays.asList(str.split(Constants.SPACE_CHAR));

		List<String> finalList = new ArrayList<String>();
		for (String elment : splittedInput) {
			if (!getExtraWordsFromCSV().contains(elment)) {
				finalList.add(elment);
			}
		}
		return finalList;
		
	}
	
	public static Set<String> getExtraWordsFromCSV() {
		Set<String> extraSet = new HashSet<String>();
		BufferedReader bufferedReader = null;
		String line = Constants.EMPTY_CHAR;
		String splitChar = Constants.DELIM_COMMA;
		String[] outputArr = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(EXTRA_WORDS_CSV_PATH));
			while ((line = bufferedReader.readLine()) != null) {
				outputArr = line.split(splitChar);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		extraSet.addAll(Arrays.asList(outputArr));
		return extraSet;
	  }

	public static List<String> prepareSearchStmt(List<String> resultList) {
		List<String> finalSearchStmt = new ArrayList<String>();
		for (int i = 0; i < resultList.size() ; i++) {
			String str = "";
			if (i==0) {
				str = resultList.get(i);
			} else {
				str = resultList.get(i-1) + " " + resultList.get(i);
			}
			finalSearchStmt.add(str);
		}
		return finalSearchStmt;
	}

	public static String trimString(String value) {
		String result = value;
		if (value != null) {
			result = value.trim();
		}
		return result;
	}

	public static boolean isEmptyOrNull(String value) {
		boolean result = false;
		if (value == null || value == Constants.EMPTY_CHAR) {
			result = true;
		}
		return result;
	}

	public static boolean isEqual(String value1, String value2, boolean ignoreCase) {
		boolean result = false;
		if (!isEmptyOrNull(value1) && !isEmptyOrNull(value2)) {
			if (ignoreCase) {
				if (value1.equalsIgnoreCase(value2)) {
 
				}
			}
		}
		
		return result;
	}
	
	    public static boolean checkCreditCard(String ccNumber){
            int sum = 0;
            boolean alternate = false;
            for (int i = ccNumber.length() - 1; i >= 0; i--){
                    int n = Integer.parseInt(ccNumber.substring(i, i + 1));
                    if (alternate){
                            n *= 2;
                            if (n > 9){
                            	n = (n % 10) + 1;
                            }
                    }
                    sum += n;
                    alternate = !alternate;
            }
            return (sum % 10 == 0);
    }
	
}
