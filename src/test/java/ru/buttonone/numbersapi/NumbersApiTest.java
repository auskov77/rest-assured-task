package ru.buttonone.numbersapi;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class NumbersApiTest {

    public static final String MAIN_URL = "http://numbersapi.com";
    public static final String NUMBER_URL = "/2";
    public static final String NUMBER_URL_2 = "http://numbersapi.com/{id}";
    public static final String DATE_URL = "/8/27/date";
    public static final String MATH_URL = "/8/math";
    public static final String CONTENT_TYPE = "text/plain; charset=utf-8";
    public static final Header requestMethod = new Header("Request method", "GET");
    public static final Header requestUriNumber = new Header("Request URI", MAIN_URL + NUMBER_URL);
    public static final Header requestUriDate = new Header("Request URI", MAIN_URL + DATE_URL);
    public static final Header requestUriMath = new Header("Request URI", MAIN_URL + MATH_URL);
    public static final Header acceptEncoding = new Header("Accept-Encoding", "gzip, deflate");
    public static final Header acceptLanguage = new Header("Accept-Language", "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7");
    public static final Header accept = new Header("Accept", "*/*");
    public static final Header cacheControl = new Header("Cache-Control", "max-age=0");
    public static final Header connection = new Header("Connection", "keep-alive");
    public static final Header host = new Header("Host", "numbersapi.com");
    public static final Header upgradeInsecureRequests = new Header("Upgrade-Insecure-Requests", "1");
    public static final Header userAgent = new Header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36");
    public static final String ID_PATH = "/{id}";


    @DisplayName("rest assured - " + MAIN_URL + NUMBER_URL_2)
    @Test
    public void shouldHaveCorrectGetNumberUrl() {

        given()
                .baseUri(MAIN_URL)
                .header(requestMethod)
                .header(requestUriNumber)
                .header(acceptEncoding)
                .header(acceptLanguage)
                .header(accept)
                .header(cacheControl)
                .header(connection)
                .header(host)
                .header(upgradeInsecureRequests)
                .header(userAgent)
                .when()
                .get(NUMBER_URL)
                .then()
                .contentType(ContentType.TEXT)
                .log().all()
                .header("Cache-Control", "no-store, no-cache, must-revalidate, proxy-revalidate, max-age=0")
                .header("Expires", "0")
                .header("Pragma", "no-cache")
                .header("X-Numbers-API-Type", "trivia")
                .header("X-Numbers-API-Number", "2")
                .header("Server", "nginx/1.4.6 (Ubuntu)")
                .header("X-Powered-By", "Express")
                .header("Connection", "keep-alive")
                .header("Content-Type", CONTENT_TYPE)
                .header("Access-Control-Allow-Origin", "*")
                .statusCode(200);
    }

    @DisplayName("rest assured - " + MAIN_URL + DATE_URL)
    @Test
    public void shouldHaveCorrectGetDateUrl() {
        given()
                .baseUri(MAIN_URL)
                .header(requestMethod)
                .header(requestUriDate)
                .header(acceptEncoding)
                .header(acceptLanguage)
                .header(accept)
                .header(cacheControl)
                .header(connection)
                .header(host)
                .header(upgradeInsecureRequests)
                .header(userAgent)
                .when()
                .get(DATE_URL)
                .then()
                .contentType(ContentType.TEXT)
                .log().all()
                .header("Cache-Control", "no-store, no-cache, must-revalidate, proxy-revalidate, max-age=0")
                .header("Expires", "0")
                .header("Pragma", "no-cache")
                .header("X-Numbers-API-Type", "date")
                .header("X-Numbers-API-Number", "240")
                .header("Server", "nginx/1.4.6 (Ubuntu)")
                .header("X-Powered-By", "Express")
                .header("Connection", "keep-alive")
                .header("Content-Type", CONTENT_TYPE)
                .header("Access-Control-Allow-Origin", "*")
                .statusCode(200);
    }

    @DisplayName("rest assured - " + MAIN_URL + MATH_URL)
    @Test
    public void shouldHaveCorrectGetMathUrl() {
        given()
                .baseUri(MAIN_URL)
                .header(requestMethod)
                .header(requestUriMath)
                .header(acceptEncoding)
                .header(acceptLanguage)
                .header(accept)
                .header(cacheControl)
                .header(connection)
                .header(host)
                .header(upgradeInsecureRequests)
                .header(userAgent)
                .when()
                .get(MATH_URL)
                .then()
                .contentType(ContentType.TEXT)
                .log().all()
                .header("Cache-Control", "no-store, no-cache, must-revalidate, proxy-revalidate, max-age=0")
                .header("Expires", "0")
                .header("Pragma", "no-cache")
                .header("X-Numbers-API-Type", "math")
                .header("X-Numbers-API-Number", "8")
                .header("Server", "nginx/1.4.6 (Ubuntu)")
                .header("X-Powered-By", "Express")
                .header("Connection", "keep-alive")
                .header("Content-Type", CONTENT_TYPE)
                .header("Access-Control-Allow-Origin", "*")
                .statusCode(200);
    }

}
