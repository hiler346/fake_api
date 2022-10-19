package Utils;

import Models.*;
import Utils.HelpModels.HelpModels;

import java.util.Date;

public class Generator {
  public static Login ParamsLogin(
    String username,
    String password
  )
  {
    Login login = new Login();
    login.setUsername(username);
    login.setPassword(password);

    return login;
  }

  public static ProductsModels ParamsProductsModels(
          String title,
          Double price,
          String description,
          String image,
          String category
  )
  {
    ProductsModels products = new ProductsModels();

            products.setTitle(title);
            products.setPrice(price);
            products.setDescription(description);
            products.setImage(image);
            products.setCategory(category);

    return products;
  }

    public static UsersModels ParamsUsersModels(
            String email,
            String username,
            String password,
            String firstname,
            String lastname,
            String city,
            String street,
            int number,
            String zipcode,
            Double lat,
            Double long1,
            String phone
    )
    {
        UsersModels user = new UsersModels();

        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);

        Name name = new Name();

        name.setFirstname(firstname);
        name.setLastname(lastname);

        user.setName(name);

        Address address = new Address();

        address.setCity(city);
        address.setStreet(street);
        address.setNumber(number);
        address.setZipcode(zipcode);

        Geolocation geo = new Geolocation();

        geo.setLat(lat);
        geo.setLong1(long1);

        address.setGeolocation(geo);

        user.setAddress(address);

        user.setPhone(phone);

        return user;
    }




}