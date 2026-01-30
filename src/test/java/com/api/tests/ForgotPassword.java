package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;

import io.restassured.response.Response;

public class ForgotPassword {
	
	@Test(description = "Verify if Forgot-Password API is working...")
	
	public void forgotPasswordTest() {
		
		AuthService authService = new AuthService();
		Response response = authService.forgotPassword("panchahardik2291@gmail.com");
		
		System.out.println(response.asPrettyString());
	}

}
