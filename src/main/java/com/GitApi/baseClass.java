package com.GitApi;

import java.util.HashMap;

import org.testng.annotations.BeforeMethod;

public class baseClass {
	
	@BeforeMethod
	public HashMap<String, String> setUp() {
		String token="fb52d5ec840e3ff7b42ab32f54daa60e02f635c5";
		HashMap<String, String> mapobj=new HashMap<String,String>(){
			{
				put("accept","application/json");
				put("Authorization","Bearer "+ token);
			}
		};
		
		return mapobj;
	}

}
