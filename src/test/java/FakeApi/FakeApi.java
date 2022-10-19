package FakeApi;

import Utils.BaseUri.BaseUriTest;
import Utils.Steps.Otvet;
import org.junit.jupiter.api.*;

import static io.qameta.allure.Allure.step;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

@Tag("TEST")
@DisplayName("FAke API (TEST)")
public class FakeApi extends BaseUriTest {

  @Test
  @Order(1)
  @DisplayName("Авторизация пользователя")
  void Login() {
    step("Авторизация пользователя", () -> {
      Otvet.Login("admin@gmail.com", "admin");  //Вставить логин и пароль для авторизации
    });
  }

  @Test
  @Order(2)
  @DisplayName("Проверка товара")
  void Products() {
    step("Проверка товара", () -> {
      Otvet.Products();
    });
  }

  @Test
  @Order(3)
  @DisplayName("Проверка категорий товара")
  void ProductsCategories() {
    step("Проверка категорий товара", () -> {
      Otvet.ProductsCategories();
    });
  }

  @Test
  @Order(4)
  @DisplayName("Проверка Карт")
  void Cart() {
    step("Проверка Карт", () -> {
      Otvet.Cart();
    });
  }

  @Test
  @Order(5)
  @DisplayName("Проверка товара тело")
  void ProductBody() {
    step("Проверка товара тело", () -> {
      Otvet.ProductBody();
    });
  }

  @Test
  @Order(6)
  @DisplayName("Пользователь")
  void Users() {
    step("Пользователь", () -> {
      Otvet.Users();
    });
  }

}
