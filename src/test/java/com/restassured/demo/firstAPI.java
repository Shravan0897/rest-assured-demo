package com.restassured.demo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import com.restassured.demo.files.payload;

public class firstAPI {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://rahulshettyacademy.com"; // Use HTTPS
        String response = given().log().all()
                .queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body(payload.addPlace())
                .when().post("maps/api/place/add/json")
                .then().assertThat()
                .statusCode(200)
                .body("scope", equalTo("APP"))
                .extract().response().asString();
        JsonPath js = new JsonPath(response);
        String placeId = js.getString("place_id");
        System.out.println(placeId);
    }

}
