package Testingg;
import Reading.SauceDemo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class Test_Login
{
    WebDriver driver;
    String urlpage = "https://www.saucedemo.com/";
    SauceDemo login;

    @BeforeTest



    public void SetUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\malpraneeth\\Documents\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(urlpage);
    }


    @Test(priority=1)
    public void validateLogin() throws IOException {
        login = new SauceDemo(driver);
        login.enterUsername();
        login.enterPassword();
        login.clickLogin();
    }
}