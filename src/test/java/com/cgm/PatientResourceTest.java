package com.cgm;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.core.IsNot.not;

@QuarkusTest
public class PatientResourceTest {

    @Test
    public void getPatientShouldReturnPatients() {
        given()
          .when().get("/patient")
          .then()
            .statusCode(200)
            .body("size()", is(5))
            .body(
                containsString("Sam"),
                containsString("John"),
                containsString("Cate"),
                containsString("Julia"),
                containsString("Liam"));
    }

    @Test
    public void getPatientByIdShouldReturnPatient() {
        given()
            .when().get("/patient/2")
            .then()
            .statusCode(200)
            .body("id", hasItem(1))
            .body("name", hasItem("John"))
            .body("surname", hasItem("Stevens"))
            .body("dateOfBirth", hasItem("15-10-1953"))
            .body("socialSecurityNumber", hasItem("KG92I7463876"));
    }

    @Test
    public void getPatientByIdWithInvalidIdShouldNotReturnPatient() {
        given()
            .when().get("/patient/20")
            .then()
            .statusCode(404);
    }

}