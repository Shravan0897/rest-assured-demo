package com.restassured.demo;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;

public class secondAPI {
    public static void main(String[] args) {
        RestAssured.baseURI = "http://rahulshettyacademy.com";
        given().log().all()
                .queryParam("key", "qaclick123")
                .when().get("maps/api/place/get/json")
                .then().log().all().assertThat()
                .statusCode(200);
    }
}
