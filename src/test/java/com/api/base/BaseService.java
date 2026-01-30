package com.api.base;

import static io.restassured.RestAssured.given;

import com.api.filters.LoggingFilter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BaseService {

    private static final String BASE_URL = "http://64.227.160.186:8080";
    
    static {
    	RestAssured.filters(new LoggingFilter());
    }

    // POST request
    protected Response postRequest(Object payload, String endpoint) {
        return given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body(payload)
                .post(endpoint);
    }

    // GET request with auth token
    protected Response getRequest(String endpoint, String token) {
        return given()
                .baseUri(BASE_URL)
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .get(endpoint);
    }
    
    // PUT request with auth token
    protected Response putRequest(Object payload, String endpoint, String token) {
        return given()
                .baseUri(BASE_URL)
                .header("Authorization", "Bearer " + token)
                .contentType(ContentType.JSON)
                .put(endpoint);
    }
}
