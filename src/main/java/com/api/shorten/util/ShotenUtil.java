package com.api.shorten.util;




public class ShotenUtil {

	public static String randomGenerationCode() {
		
		String returnText ="";		
		
		String possibility = "ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijklmnporstuvwxyz1234567890";
		
		
		for(int i = 0; i < 5 ; i++) {			
			returnText += possibility.charAt(Math.toIntExact( Math.round(Math.random() * possibility.length())));
		}
		
		return returnText;
	}

}
