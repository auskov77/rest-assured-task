package ru.buttonone.numbersapi;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static ru.buttonone.numbersapi.specification.NumbersApiSpecifications.*;

public class NumbersApiTest {

    public static final String MAIN_URL = "http://numbersapi.com";
    public static final String NUMBER_URL = "2";
    public static final String DATE_URL = "8/27/date";
    public static final String MATH_URL = "8/math";
    public static final String ID_PATH = "/{id}";

    @DisplayName("rest assured - " + MAIN_URL + "/" + NUMBER_URL)
    @Test
    public void shouldHaveCorrectGetNumberUrl() {

        given()
                .spec(defaultRequestSpecification())
                .spec(requestSpecificationNumber())
                .when()
                .get(ID_PATH)
                .then()
                .contentType(ContentType.TEXT)
                .spec(defaultResponseSpecification())
                .spec(responseSpecificationNumber());
    }

    @DisplayName("rest assured - " + MAIN_URL + "/" + DATE_URL)
    @Test
    public void shouldHaveCorrectGetDateUrl() {
        given()
                .spec(defaultRequestSpecification())
                .spec(requestSpecificationDate())
                .when()
                .get("/" + DATE_URL)
                .then()
                .contentType(ContentType.TEXT)
                .spec(defaultResponseSpecification())
                .spec(responseSpecificationDate());
    }

    @DisplayName("rest assured - " + MAIN_URL + "/" + MATH_URL)
    @Test
    public void shouldHaveCorrectGetMathUrl() {
        given()
                .spec(defaultRequestSpecification())
                .spec(requestSpecificationMath())
                .when()
                .get("/" + MATH_URL)
                .then()
                .contentType(ContentType.TEXT)
                .spec(defaultResponseSpecification())
                .spec(responseSpecificationMath());
    }

}
