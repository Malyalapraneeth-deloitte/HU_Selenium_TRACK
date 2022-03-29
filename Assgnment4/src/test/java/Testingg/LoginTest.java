package Testingg;
import Reading.SauceDemo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest
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
    public void validateLogin() throws Exception {
        login = new SauceDemo(driver);
        login.enterUsername();
        login.enterPassword();
        login.clickLogin();
    }
    @Test(priority = 2)
    public void exp_prod() throws Exception {
        WebElement ele = driver.findElement(By.xpath("//*[@class='product_sort_container']"));
        ele.click();
        WebElement ele1 = driver.findElement(By.xpath("//*[@value='hilo']"));
        ele1.click();

        WebElement e1 = driver.findElement(By.xpath("//*[@class='btn btn_primary btn_small btn_inventory']"));
        e1.click();
        Thread.sleep(5000);
        WebElement e2 = driver.findElement(By.xpath("//*[@id='remove-sauce-labs-fleece-jacket']"));
        e2.click();
        Thread.sleep(5000);
        WebElement e3 = driver.findElement(By.xpath("//*[@class='btn btn_primary btn_small btn_inventory']"));
        e3.click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a/span")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@class='btn btn_secondary back btn_medium']")).click();
        least_prod();
    }
    @Test(priority = 3)
    public void least_prod() throws Exception {
        WebElement ele = driver.findElement(By.xpath("//*[@class='product_sort_container']"));
        ele.click();
        WebElement ele1 = driver.findElement(By.xpath("//*[@value='lohi']"));
        ele1.click();
        WebElement e1 = driver.findElement(By.xpath("//*[@class='btn btn_primary btn_small btn_inventory']"));
        e1.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a/span")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@class='btn btn_action btn_medium checkout_button']")).click();
    }

}