package ru.buttonone.numbersapi.specification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class NumbersApiSpecifications {
    public static final String MAIN_URL = "http://numbersapi.com";
    public static final String NUMBER_URL = "/2";
    public static final String DATE_URL = "/8/27/date";
    public static final String MATH_URL = "/8/math";
    public static final String CONTENT_TYPE = "text/plain; charset=utf-8";

    public static RequestSpecification defaultRequestSpecification() {

        return new RequestSpecBuilder()
                .addHeader("Request method", "GET")
                .addHeader("Accept-Encoding", "gzip, deflate")
                .addHeader("Accept-Language", "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
                .addHeader("Accept", "*/*")
                .addHeader("Cache-Control", "max-age=0")
                .addHeader("Connection", "keep-alive")
                .addHeader("Host", "numbersapi.com")
                .addHeader("Upgrade-Insecure-Requests", "1")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36")
                .build();
    }

    public static RequestSpecification requestSpecificationNumber() {
        return new RequestSpecBuilder()
                .addHeader("Request URI", MAIN_URL + NUMBER_URL)
                .addPathParam("id", 2)
                .setBaseUri(MAIN_URL)
                .build();
    }

    public static RequestSpecification requestSpecificationNumberNegative() {
        return new RequestSpecBuilder()
                .addHeader("Request URI", MAIN_URL + NUMBER_URL)
                .addPathParam("id", 3)
                .setBaseUri(MAIN_URL)
                .build();
    }

    public static RequestSpecification requestSpecificationDate() {

        return new RequestSpecBuilder()
                .addHeader("Request URI", MAIN_URL + DATE_URL)
                .setBaseUri(MAIN_URL)
                .build();
    }

    public static RequestSpecification requestSpecificationDateNegative() {

        return new RequestSpecBuilder()
                .addHeader("Request URI", MAIN_URL + DATE_URL)
                .setBaseUri(DATE_URL)
                .build();
    }

    public static RequestSpecification requestSpecificationMath() {

        return new RequestSpecBuilder()
                .addHeader("Request URI", MAIN_URL + MATH_URL)
                .setBaseUri(MAIN_URL)
                .build();
    }

    public static RequestSpecification requestSpecificationMathNegative() {

        return new RequestSpecBuilder()
                .addHeader("Request URI", MAIN_URL + MATH_URL)
                .setBaseUri(CONTENT_TYPE)
                .build();
    }

    public static ResponseSpecification defaultResponseSpecification() {
        return new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .expectHeader("Cache-Control", "no-store, no-cache, must-revalidate, proxy-revalidate, max-age=0")
                .expectHeader("Expires", "0")
                .expectHeader("Pragma", "no-cache")
                .expectHeader("Server", "nginx/1.4.6 (Ubuntu)")
                .expectHeader("X-Powered-By", "Express")
                .expectHeader("Connection", "keep-alive")
                .expectHeader("Content-Type", CONTENT_TYPE)
                .expectHeader("Access-Control-Allow-Origin", "*")
                .expectStatusCode(200)
                .build();
    }

    public static ResponseSpecification responseSpecificationNumber() {
        return new ResponseSpecBuilder()
                .expectHeader("X-Numbers-API-Type", "trivia")
                .expectHeader("X-Numbers-API-Number", "2")
                .build();
    }

    public static ResponseSpecification responseSpecificationNumberNegative() {
        return new ResponseSpecBuilder()
                .expectStatusCode(300)
                .build();
    }

    public static ResponseSpecification responseSpecificationDate() {
        return new ResponseSpecBuilder()
                .expectHeader("X-Numbers-API-Type", "date")
                .expectHeader("X-Numbers-API-Number", "240")
                .build();
    }

    public static ResponseSpecification responseSpecificationDateNegative() {
        return new ResponseSpecBuilder()
                .expectHeader("Content-Type", "text/plain8")
                .build();
    }

    public static ResponseSpecification responseSpecificationMath() {
        return new ResponseSpecBuilder()

                .expectHeader("X-Numbers-API-Type", "math")
                .expectHeader("X-Numbers-API-Number", "8")
                .build();
    }

    public static ResponseSpecification responseSpecificationMathNegative() {
        return new ResponseSpecBuilder()

                .expectHeader("Expires", "1")
//                .expectHeader("X-Numbers-API-Number", "8")
                .build();
    }

}
