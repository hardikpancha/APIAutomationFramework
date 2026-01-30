package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationTest {

	@Test(description = "Verify if SignUp API is working...")

	public void createAccountTest() {

		SignUpRequest signUpRequest = new SignUpRequest.Builder().userName("Hpancha").firstName("Hardik")
				.lastName("pancha").email("hpancha@gmail.com").password("12345").mobileNumber("1234567890").build();

		AuthService authService = new AuthService();
		Response response = authService.signUp(signUpRequest);
		System.out.println(response.asPrettyString());

		Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
		System.out.println(response.statusCode());
		
	}
}
