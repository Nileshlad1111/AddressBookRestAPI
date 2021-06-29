package com.bridgelabz.addressbook;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

public class RESTAssureAddressBookTest {
    @Before
    public void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3000;
    }

    public Response getPersonList() {
        return RestAssured.get("/AddressBook");
    }

    @Test
    public void onCallingList_ReturnPersonList() {
        Response response = getPersonList();
        System.out.println("At First: " + response.asString());
        response.then().body("id", Matchers.hasItems(1, 2));
        response.then().body("State", Matchers.hasItems("MH"));
    }

    @Test
    public void givenPersonDetails_OnPost_ShouldReturnAddedPersonDetails() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body("{\"firstName\": \"Nilesh\", \"lastName\": \"Kunmar\", \"address\": \"Kundal\", " +
                        "\"city\": \"GGG\", \"state\": \"MH\", \"zipCode\": \"457885\"," +
                        "\"phone\": \"9999999999\"}")
                .when()
                .post("/AddressBook");
        String responseString = response.asString();
        response.then().body("id", Matchers.any(Integer.class));
        System.out.println(responseString);
    }
}



// json-server --port 3000 --routes routes.json --watch RESTAssureJSONFile.json