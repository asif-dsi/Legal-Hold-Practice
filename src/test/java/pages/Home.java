package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Home {
    WebDriver driver;
    WebDriverWait wait;

    public Home(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void navigateToLogin() throws InterruptedException {
        String head = driver.findElement(By.xpath("//h1[contains(text(),'Welcome to Legal Hold')]")).getText();
        Assert.assertTrue(head.contains("Welcome to Legal Hold"));
        String subHead=driver.findElement(By.xpath("//h6[contains(text(),'Your personal litigation notification and reminder Assistant')]")).getText();
        Assert.assertTrue(subHead.contains("Your personal litigation notification and reminder Assistant"));

        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement btnLogin = driver.findElement(By.id("loginLink"));
        wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
        btnLogin.click();
        Thread.sleep(2000);
        String subHead2=driver.findElement(By.xpath("//p[contains(text(),'Please log in using your existing User name and Password.')]")).getText();
        Assert.assertTrue(subHead2.contains("Please log in using your existing User name and Password."));

        WebElement inputUserName = driver.findElement(By.id("UserName"));
        inputUserName.sendKeys("dsi\\asif.shahriar");
        WebElement inputPass = driver.findElement(By.id("Password"));
        inputPass.sendKeys("Unique?HallMarketing");
        WebElement btnSubmit = driver.findElement(By.cssSelector("[type='submit']"));
        wait.until(ExpectedConditions.elementToBeClickable(btnSubmit));
        btnSubmit.click();
    }

    public void navigateToCase() throws InterruptedException {
        List<WebElement> btnCase= driver.findElements(By.xpath("//a[@href='/Case']"));
        Thread.sleep(3000);
        btnCase.get(1).click();

        Thread.sleep(3000);
        String subHead=driver.findElement(By.id("TitleDescId")).getText();
        Assert.assertTrue(subHead.contains("Create a new case, edit an existing case, or obtain a report for the custodians within a case."));
    }
}
