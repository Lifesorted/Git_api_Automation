package com.GitApi.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class getUniqueValue {
	
	public static String getRepoName() {
		String repoval=RandomStringUtils.randomAlphabetic(1);	
		return ("Demorepo"+repoval);
	}
	
	public static String getRepoDesc() {
		String repoval=RandomStringUtils.randomAlphabetic(3);	
		return ("This is demo repo for testing "+repoval);
	}
	
	public static String getRepoHomePageUrl() {
		String repoval=RandomStringUtils.randomAlphabetic(5);	
		return ("https://github.com/"+repoval);
	}

}
