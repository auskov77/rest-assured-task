package ru.buttonone.numbersapi.specification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class NumbersApiSpecifications {
    public static final String MAIN_URL = "http://numbersapi.com";
    public static final String NUMBER_URL = "/2";


    public static RequestSpecification defaultRequestSpecification(){

        return new RequestSpecBuilder()
                .addHeader("Accept-Language", "ru")
                .addPathParam("id", 2)
                .setBaseUri(MAIN_URL)
                .build();

    }

}
