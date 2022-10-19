package Utils;

import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.expect;

public class ResponseRest {
  public static ResponseSpecification Status(int statusCode) {
    ResponseSpecification responseStatus = expect()
      .statusCode(statusCode);

    return responseStatus;
  }
}