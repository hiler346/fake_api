package Utils;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TypeRequest {
  public static Response LOGIN_BODY(String path, Object object, int statusCode) {
    Response response = given()
        .spec(RequestRest.Login(object))
        .when()
        .post(path)
        .then()
        .log().body()
        .spec(ResponseRest.Status(statusCode))
        .extract()
        .response();

    return response;
  }

  public static Response GET_AUTH(String accessToken, String path, int statusCode) {
    Response response = given()
      .spec(RequestRest.Auth(accessToken))
      .when()
      .get(path)
      .then()
      .log().body()
      .spec(ResponseRest.Status(statusCode))
      .extract()
      .response();

    return response;
  }

  public static Response GET_AUTH(String accessToken, String path) {
    Response response = given()
      .spec(RequestRest.Auth(accessToken))
      .when()
      .get(path)
      .then()
      .log().body()
      .extract()
      .response();

    return response;
  }

  public static Response GET_AUTH_QUERY_3(
    String accessToken,
    String path,
    String key1, Object value1,
    String key2, Object value2,
    String key3, Object value3,
    int statusCode) {
    Response response = given()
      .spec(RequestRest.AuthQuery_3(
        accessToken,
        key1, value1,
        key2, value2,
        key3, value3
      ))
      .when()
      .get(path)
      .then()
      .log().body()
      .spec(ResponseRest.Status(statusCode))
      .extract()
      .response();

    return response;
  }

  public static Response GET_AUTH_QUERY_4(
    String accessToken,
    String path,
    String key1, Object value1,
    String key2, Object value2,
    String key3, Object value3,
    String key4, Object value4,
    int statusCode) {
    Response response = given()
      .spec(RequestRest.AuthQuery_4(
        accessToken,
        key1, value1,
        key2, value2,
        key3, value3,
        key4, value4
      ))
      .when()
      .get(path)
      .then()
      .log().body()
      .spec(ResponseRest.Status(statusCode))
      .extract()
      .response();

    return response;
  }

  public static Response GET_AUTH_QUERY_1(
    String accessToken,
    String path,
    String key1, Object value1,
    int statusCode) {
    Response response = given()
      .spec(RequestRest.AuthQuery_1(
        accessToken,
        key1, value1
      ))
      .when()
      .get(path)
      .then()
      .log().body()
      .spec(ResponseRest.Status(statusCode))
      .extract()
      .response();

    return response;
  }

  public static Response GET_AUTH_QUERY_NO_AUTH(
          String path,
          String key1, Object value1,
          int statusCode) {
    Response response = given()
            .spec(RequestRest.WithoutAuth_1(
                    key1, value1
            ))
            .when()
            .get(path)
            .then()
            .log().body()
            .spec(ResponseRest.Status(statusCode))
            .extract()
            .response();

    return response;
  }


  public static Response GET(String path, int statusCode) {
    Response response = given()
      .spec(RequestRest.WithoutAuth())
      .when()
      .get(path)
      .then()
      .log().body()
      .spec(ResponseRest.Status(statusCode))
      .extract()
      .response();

    return response;
  }

  public static Response POST_BODY(String accessToken, String path, Object object, int statusCode) {
    Response response = given()
      .spec(RequestRest.AuthBody(accessToken, object))
      .when()
      .post(path)
      .then()
      .log().body()
      .spec(ResponseRest.Status(statusCode))
      .extract()
      .response();

    return response;
  }

  public static Response DELETE_BODY(String accessToken, String path, Object object, int statusCode) {
    Response response = given()
      .spec(RequestRest.AuthBody(accessToken, object))
      .when()
      .delete(path)
      .then()
      .log().body()
      .spec(ResponseRest.Status(statusCode))
      .extract()
      .response();

    return response;
  }

  public static Response DELETE(String accessToken, String path, int statusCode) {
    Response response = given()
      .spec(RequestRest.Auth(accessToken))
      .when()
      .delete(path)
      .then()
      .log().body()
      .spec(ResponseRest.Status(statusCode))
      .extract()
      .response();

    return response;
  }

  public static Response POST_BODY_LOGIN_ERROR(String path, Object object, int statusCode) {
    Response response = given()
      .spec(RequestRest.Login(object))
      .when()
      .post(path)
      .then()
      .log().body()
      .spec(ResponseRest.Status(statusCode))
      .extract()
      .response();

    return response;
  }

  public static Response POST(String accessToken, String path, int statusCode) {
    Response response = given()
      .spec(RequestRest.Auth(accessToken))
      .when()
      .post(path)
      .then()
      .log().body()
      .spec(ResponseRest.Status(statusCode))
      .extract()
      .response();

    return response;
  }

  public static Response POST_MULTIPART(String accessToken, String path, String imagePath, int statusCode) {
    Response response = given()
      .spec(RequestRest.AuthMultiPart(accessToken, imagePath))
      .when()
      .post(path)
      .then()
      .log().body()
      .spec(ResponseRest.Status(statusCode))
      .extract()
      .response();

    return response;
  }

  public static Response PUT_BODY(String accessToken, String path, Object object, int statusCode) {
    Response response = given()
        .spec(RequestRest.AuthBody(accessToken, object))
        .when()
        .put(path)
        .then()
        .log().body()
        .spec(ResponseRest.Status(statusCode))
        .extract()
        .response();

    return response;
  }
  public static Response GET_AUTH_QUERY_2(
      String accessToken,
      String path,
      String key1, Object value1,
      String key2, Object value2,
      int statusCode) {
    Response response = given()
        .spec(RequestRest.AuthQuery_2(
            accessToken,
            key1, value1,
            key2, value2
        ))
        .when()
        .get(path)
        .then()
        .log().body()
        .spec(ResponseRest.Status(statusCode))
        .extract()
        .response();

    return response;
  }


}