package bank;

import java.lang.reflect.Method;

import javax.security.auth.login.LoginException;

public class Authenticator {

  public static Customer login(String username, String password) throws LoginException {
    Customer customer = DataSource.getCustomer(username);
    if (customer == null) {
      throw new LoginException("Username not found");
    }
    if (password.equals(customer.getPassword())) {
      customer.setAutheticated(true);
      return customer;
    }else{
      throw new LoginException("Incorrect Password");
    }
    
  }

  public static void logout(Customer customer) {
    customer.setAutheticated(false);
  }
}
