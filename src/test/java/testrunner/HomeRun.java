package testrunner;

import environment.Setup;
import org.testng.annotations.Test;
import pages.Home;

public class HomeRun extends Setup {
    @Test(priority = 1)
    public void goToLoginPage() throws InterruptedException {
        driver.get("https://legalholdqa.legility.com");
        Home home = new Home(driver);
        home.navigateToLogin();
    }

    @Test(priority = 2)
    public void goToCaseTab() throws InterruptedException {
        driver.get("https://legalholdqa.legility.com");
        Home home = new Home(driver);
        home.navigateToCase();
    }

}
