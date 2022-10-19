package Utils;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.File;

import static io.restassured.RestAssured.given;

public class RequestRest {
  public static RequestSpecification Auth(String accessToken) {
    RequestSpecification request = given()
      .auth().oauth2(accessToken)
      .header("Accept-Language", "ru")
      .contentType(ContentType.JSON)
      .filter(new AllureRestAssured())
      .log().uri();

    return request;
  }

  public static RequestSpecification AuthQuery_1(
    String accessToken,
    String key1, Object value1
  ) {
    RequestSpecification request = given()
      .auth().oauth2(accessToken)
      .header("Accept-Language", "ru")
      .queryParam(key1, value1)
      .contentType(ContentType.JSON)
      .filter(new AllureRestAssured())
      .log().uri();

    return request;
  }

  public static RequestSpecification AuthQuery_3(
    String accessToken,
    String key1, Object value1,
    String key2, Object value2,
    String key3, Object value3
  ) {
    RequestSpecification request = given()
      .auth().oauth2(accessToken)
      .header("Accept-Language", "ru")
      .queryParam(key1, value1)
      .queryParam(key2, value2)
      .queryParam(key3, value3)
      .contentType(ContentType.JSON)
      .filter(new AllureRestAssured())
      .log().uri();

    return request;
  }

  public static RequestSpecification AuthQuery_4(
    String accessToken,
    String key1, Object value1,
    String key2, Object value2,
    String key3, Object value3,
    String key4, Object value4
  ) {
    RequestSpecification request = given()
      .auth().oauth2(accessToken)
      .header("Accept-Language", "ru")
      .queryParam(key1, value1)
      .queryParam(key2, value2)
      .queryParam(key3, value3)
      .queryParam(key4, value4)
      .contentType(ContentType.JSON)
      .filter(new AllureRestAssured())
      .log().uri();

    return request;
  }

  public static RequestSpecification AuthMultiPart(String accessToken, String path) {
    RequestSpecification request = given()
      .multiPart("file", new File(path), "image/png")
      .auth().oauth2(accessToken)
      .header("Accept-Language", "ru")
      .filter(new AllureRestAssured())
      .log().uri();

    return request;
  }




  public static RequestSpecification WithoutAuth_1(
          String key1, Object value1
  ) {
    RequestSpecification request = given()
      .header("Accept-Language", "ru")
      .contentType(ContentType.JSON)
      .filter(new AllureRestAssured())
      .log().uri();

    return request;
  }

  public static RequestSpecification WithoutAuth() {
    RequestSpecification request = given()
            .header("Accept-Language", "ru")
            .contentType(ContentType.JSON)
            .filter(new AllureRestAssured())
            .log().uri();

    return request;
  }

  public static RequestSpecification AuthBody(String accessToken, Object object) {
    RequestSpecification request = given()
      .auth().oauth2(accessToken)
      .header("Accept-Language", "ru")
      .contentType(ContentType.JSON)
      .filter(new AllureRestAssured())
      .log().uri()
      .body(object)
      .log().body();

    return request;
  }
  public static RequestSpecification Login(Object object) {
    RequestSpecification request = given()
      .header("Accept-Language", "ru")
      .contentType(ContentType.JSON)
      .log().body()
      .filter(new AllureRestAssured())
      .log().uri()
      .body(object);

    return request;
  }



  public static RequestSpecification AuthQuery_2(
      String accessToken,
      String key1, Object value1,
      String key2, Object value2
  ) {
    RequestSpecification request = given()
        .auth().oauth2(accessToken)
        .header("Accept-Language", "ru")
        .queryParam(key1, value1)
        .queryParam(key2, value2)
        .contentType(ContentType.JSON)
        .filter(new AllureRestAssured())
        .log().uri();

    return request;
  }
}