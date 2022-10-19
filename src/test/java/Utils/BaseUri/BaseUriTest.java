package Utils.BaseUri;

import Utils.Api;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;


public class BaseUriTest {
  @BeforeAll
  public static void BaseUtils() {
    RestAssured.baseURI = (Api.baseUriTest);
  }
}
