package Utils;

public class Api {
  //Выберите среду и запустите тесты в консоли
  //gradle clean test_env @Tag("TEST")


  //Поменять ссылки API Dev
  public static String baseUriDev = System.getProperty("stand", "Ссылка для DEV");

  //Test
  public static String baseUriTest = System.getProperty("stand", "https://fakestoreapi.com/");

  //Поменять ссылки API Prod
  public static String baseUriProd = System.getProperty("stand", "Ссылка для PROD");
}