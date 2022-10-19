package Utils.BaseUri;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import Utils.Api;

public class BaseUriProd {
  @BeforeAll
  public static void BaseUtils() {
    RestAssured.baseURI = (Api.baseUriProd);
  }
}
