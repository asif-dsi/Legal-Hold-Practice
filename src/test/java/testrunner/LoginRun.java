package testrunner;

import environment.Setup;
import org.testng.annotations.Test;
import pages.Login;

public class LoginRun extends Setup {
    @Test(priority = 1)
    public void loginValid(){
        driver.get("https://legalholdqa.legility.com");
        Login login = new Login(driver);
        login.validLogin();
    }

    @Test(priority = 2)
    public void loginInvalidUserName(){
        driver.get("https://legalholdqa.legility.com");
        Login login = new Login(driver);
        login.invalidUserName();
    }

    @Test(priority = 3)
    public void loginInvalidPassword(){
        driver.get("https://legalholdqa.legility.com");
        Login login = new Login(driver);
        login.invalidPassword();
    }

    @Test(priority = 4)
    public void loginEmptyField(){
        driver.get("https://legalholdqa.legility.com");
        Login login = new Login(driver);
        login.emptyField();
    }

    @Test(priority = 5)
    public void clickRememberMe(){
        driver.get("https://legalholdqa.legility.com");
        Login login = new Login(driver);
        login.rememberMeClick();
    }

}
