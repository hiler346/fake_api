package Utils.Steps;

import Models.*;
import Utils.Generator;
import Utils.HelpModels.HelpModels;
import Utils.RandomUtils;
import Utils.TypeRequest;
import io.restassured.response.Response;
import org.junit.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Otvet {
  protected static HelpModels otvet = new HelpModels();

  public static void Login(String username, String password) {
    Login login = Generator.ParamsLogin(
        username,
        password
    );

    Response response = TypeRequest.LOGIN_BODY(
        "/users/login",
        login,
        200
    );

    otvet.accessToken = response.path("accessToken");
    otvet.refreshToken = response.path("refreshToken");
  }

  public static void Filter() {
    LocalDate dateFrom = LocalDate.now().minusMonths(7);
    LocalDate dateTo = LocalDate.now();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    TypeRequest.GET_AUTH_QUERY_3(
        HelpModels.accessToken,
        "",
        "companyId", 1,
        "dateFrom", dtf.format(dateFrom),
        "dateTo", dtf.format(dateTo),
        200
    );
  }


  public static void Show(int companyId) {
    Response response = TypeRequest.GET_AUTH_QUERY_3(
        HelpModels.accessToken,
        "",
        "companyId", companyId,
        "page", 0,
        "size", 12,
        200
    );
    ArrayList content = response.path("content");
    int index = RandomUtils.getRandomInt(0, content.size() - 1);

    otvet.networkId = response.path("content[" + index +"].id");
    otvet.networkManagerName = response.path("content[" + index +"].managerName");
    otvet.networkName = response.path("content["+ index +"].name");
  }
  public static void Edit() {
    Response response = TypeRequest.GET_AUTH_QUERY_3(
        HelpModels.accessToken,
        "",
        "companyId", 2,
        "page", 0,
        "size", 12,
        200
    );

    ArrayList content = response.path("content");

    for(int i = 0; i < content.size() - 1; i++) {
      int contentId = response.path("content[" + i + "].id");
      if ( contentId == otvet.networkId ) {
        Assert.assertNotEquals(otvet.networkNewName, otvet.networkName);
        Assert.assertNotEquals(otvet.networkNewManagerName, otvet.networkManagerName);
        break;
      }
    }
  }

  public static void Products() {
    TypeRequest.GET(
            "/products",
            200
    );
  }

  public static void ProductsCategories() {
    TypeRequest.GET(
            "/products/categories",
            200
    );
  }

  public static void Cart() {
    TypeRequest.GET_AUTH_QUERY_NO_AUTH(
            "/cart",
            "userId",1,
            200
    );
  }

  public static void ProductBody()  {
    ProductsModels products = Generator.ParamsProductsModels(
            "test product",
            13.5,
            "lorem ipsum set",
            "https://i.pravatar.cc",
            "electronic"
    );
   Response response = TypeRequest.POST_BODY_LOGIN_ERROR(
           "/products",
          products,
          200);
}

  public static void Users()  {
    UsersModels user = Generator.ParamsUsersModels(
            "John@gmail.com",
            "johnd",
            "m38rmF$",
            "John",
            "Doe",
            "kilcoole",
            "7835 new road",
            3,
            "12926-3874",
            -37.3159,
            81.1496,
            "1-570-236-7033"
    );
    Response response = TypeRequest.POST_BODY_LOGIN_ERROR(
            "/products",
            user,
            200);
  }



}
