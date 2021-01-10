package com.GitApiTest;
import org.apache.http.StatusLine;
import org.testng.annotations.Test;
import org.testng.internal.BaseClassFinder;

import com.GitApi.baseClass;
import com.GitApi.utils.getUniqueValue;

import io.restassured.assertion.BodyMatcher;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.Map;

public class gitApiTest extends baseClass{
	
	//GET request for all repos by a owner
	@Test
	public void getRepoTest() {
		
		given()
		      
		      .headers(setUp())
		      
		  .when()
		  
		      .get("https://api.github.com/user/repos?owner=Lifesorted")
		      
		  .then()
		       .statusCode(200)
		       .statusLine("HTTP/1.1 200 OK")
	           .log().all();
	}

	//get repo by username path parameter
	@Test
    public void getRepoByUsername() {
	
		given()
		    
		    .pathParam("username", "qascript20")
		    .headers(setUp())
		    
		  .when()
		    
		    .get("https://api.github.com/users/{username}/repos")
		    
		  .then()
		  
		    .statusCode(200)
	        .statusLine("HTTP/1.1 200 OK")
            .log().all();
		
	}
	
	//get single repo information
	@Test
	public void getRepoInfo() {
				
		given()
		    
		    .pathParam("owner", "Lifesorted")
		    .pathParam("repo", "Demorepoc")
		    .headers(setUp())
		    
		  .when()
		    
		    .get("https://api.github.com/repos/{owner}/{repo}")
		    
		  .then()
		  
		    .statusCode(200)
	        .statusLine("HTTP/1.1 200 OK")
            .log().all();
		
	}
	
	//post request to add a repo
	@Test
	public void postRepo() {
		HashMap<String, Object> jsonpayload=new HashMap<String,Object>(){
			{
				put("name", getUniqueValue.getRepoName());
				put("description", "This is my repository");
				put("homepage", "https://github.com");
				put("private", "true");
				put("has_issues", "true");
				put("has_projects", "true");
				put("has_wiki", "true");
			}
		};
		
		given()
		
		     .headers(setUp())
		     .body(jsonpayload)
		     
		   .when()
		   
		     .post("https://api.github.com/user/repos")
		     
		   .then()
		      .statusCode(201)
		      .statusLine("HTTP/1.1 201 Created")
		      .log().all();
		      //.body("private",equalTo(true))
		      //.body("login", equalTo("Lifesorted"));
	}

	//patch request to update 
	@Test
	public void updateRepo() {
		HashMap<String, Object> patchdata=new HashMap<String,Object>(){
			{
				put("name",getUniqueValue.getRepoName());
			}
		};
		
		given()
		
		      .headers(setUp())
		      .pathParam("owner", "Lifesorted")
		      .pathParam("repo", "DemorepoR")
		      .body(patchdata)
		      
		    .when()
		    
		       .patch("https://api.github.com/repos/{owner}/{repo}")
		    
		    .then()
		    
		       .statusCode(200)
		       .statusLine("HTTP/1.1 200 OK")
	           .log().all();    
	}

}