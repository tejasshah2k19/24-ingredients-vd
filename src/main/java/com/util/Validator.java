package com.util;

public class Validator {

	public static boolean isBlank(String data) {
		// if data blank true else false
		if (data == null || data.trim().length() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isAlpha(String data) {
			String regEx = "[a-zA-Z]+";//1 n 
			return data.matches(regEx); //true | false  
		
	}
}
