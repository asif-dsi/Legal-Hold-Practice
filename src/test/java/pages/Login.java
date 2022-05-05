package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Login {
    WebDriver driver;
    WebDriverWait wait;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void validLogin(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement btnLogin = driver.findElement(By.id("loginLink"));
        wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
        btnLogin.click();
        String subHead = driver.findElement(By.xpath("//p[contains(text(),'Please log in using your existing User name and Password.')]")).getText();
        Assert.assertTrue(subHead.contains("Please log in using your existing User name and Password"));
        WebElement inputUserName = driver.findElement(By.id("UserName"));
        inputUserName.sendKeys("dsi\\asif.shahriar");
        WebElement inputPass = driver.findElement(By.id("Password"));
        inputPass.sendKeys("Unique?HallMarketing");
        WebElement btnSubmit = driver.findElement(By.cssSelector("[type=\"submit\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(btnSubmit));
        btnSubmit.click();

        WebElement btnLogOut = driver.findElement(By.id("logoff"));
        wait.until(ExpectedConditions.elementToBeClickable(btnLogOut));
        btnLogOut.click();
    }


    public void invalidUserName(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement btnLogin = driver.findElement(By.id("loginLink"));
        wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
        btnLogin.click();
        String subHead = driver.findElement(By.xpath("//p[contains(text(),'Please log in using your existing User name and Password.')]")).getText();
        Assert.assertTrue(subHead.contains("Please log in using your existing User name and Password"));
        WebElement inputUserName = driver.findElement(By.id("UserName"));
        inputUserName.sendKeys("wrongusername");
        WebElement inputPass = driver.findElement(By.id("Password"));
        inputPass.sendKeys("Unique?HallMarketing");
        WebElement btnSubmit = driver.findElement(By.cssSelector("[type=\"submit\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(btnSubmit));
        btnSubmit.click();

        String errorMessage = driver.findElement(By.className("error")).getText();
        Assert.assertTrue(errorMessage.contains("Credentials rejected by domain: dsi"));
    }


    public void invalidPassword(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement btnLogin = driver.findElement(By.id("loginLink"));
        wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
        btnLogin.click();
        String subHead = driver.findElement(By.xpath("//p[contains(text(),'Please log in using your existing User name and Password.')]")).getText();
        Assert.assertTrue(subHead.contains("Please log in using your existing User name and Password"));
        WebElement inputUserName = driver.findElement(By.id("UserName"));
        inputUserName.sendKeys("dsi\\asif.shahriar");
        WebElement inputPass = driver.findElement(By.id("Password"));
        inputPass.sendKeys("wrong");
        WebElement btnSubmit = driver.findElement(By.cssSelector("[type=\"submit\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(btnSubmit));
        btnSubmit.click();

        String errorMessage = driver.findElement(By.className("error")).getText();
        Assert.assertTrue(errorMessage.contains("Credentials rejected by domain: dsi"));
    }


    public void emptyField(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement btnLogin = driver.findElement(By.id("loginLink"));
        wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
        btnLogin.click();
        String subHead = driver.findElement(By.xpath("//p[contains(text(),'Please log in using your existing User name and Password.')]")).getText();
        Assert.assertTrue(subHead.contains("Please log in using your existing User name and Password"));
        WebElement btnSubmit = driver.findElement(By.cssSelector("[type=\"submit\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(btnSubmit));
        btnSubmit.click();
    }


    public void rememberMeClick(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement btnLogin = driver.findElement(By.id("loginLink"));
        wait.until(ExpectedConditions.elementToBeClickable(btnLogin));
        btnLogin.click();
        String subHead = driver.findElement(By.xpath("//p[contains(text(),'Please log in using your existing User name and Password.')]")).getText();
        Assert.assertTrue(subHead.contains("Please log in using your existing User name and Password"));
        WebElement inputUserName = driver.findElement(By.id("UserName"));
        inputUserName.sendKeys("dsi\\asif.shahriar");
        WebElement inputPass = driver.findElement(By.id("Password"));
        inputPass.sendKeys("Unique?HallMarketing");
        WebElement btnToRemember = driver.findElement(By.id("RememberMe"));
        btnToRemember.click();
        WebElement btnSubmit = driver.findElement(By.cssSelector("[type=\"submit\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(btnSubmit));
        btnSubmit.click();

        WebElement btnLogOut = driver.findElement(By.id("logoff"));
        wait.until(ExpectedConditions.elementToBeClickable(btnLogOut));
        btnLogOut.click();
    }
}
