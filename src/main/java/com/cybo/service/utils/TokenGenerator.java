package com.cybo.service.utils;

import org.apache.commons.lang.RandomStringUtils;

public class TokenGenerator {
	
private static int defaultLength = 60;
	
	static String generate() {
		return RandomStringUtils.randomAlphabetic(defaultLength);
	}
	
	static String generate(int length) {
		return RandomStringUtils.randomAlphabetic(length);
	}	

}
