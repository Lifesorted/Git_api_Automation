package com.GitApi;

import java.util.HashMap;

import org.testng.annotations.BeforeMethod;

public class baseClass {
	
	@BeforeMethod
	public HashMap<String, String> setUp() {
		String token="92a9a019633ce0b11467eaf0fc913797461592d5";
		HashMap<String, String> mapobj=new HashMap<String,String>(){
			{
				put("accept","application/json");
				put("Authorization","Bearer "+ token);
			}
		};
		
		return mapobj;
	}

}
