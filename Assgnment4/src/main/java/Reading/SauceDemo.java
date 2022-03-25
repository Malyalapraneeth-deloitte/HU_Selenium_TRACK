package Reading;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class SauceDemo extends Excel_Reading{
    WebDriver driver;
    By username = By.xpath("//input[@id='user-name']");
    By password = By.xpath("//input[@id='password']");
    By login_button = By.xpath("//input[@id='login-button']");

    Excel_Reading excel = new Excel_Reading();
    public SauceDemo(WebDriver driver) throws IOException {
        this.driver = driver;
        excel.readCells();
    }

    public void enterUsername(){
        String name = excel.getName();
        System.out.println(name);
        WebElement nameEle = driver.findElement(username);
        nameEle.sendKeys(name);
    }

    public void enterPassword(){
        String pass = excel.getPass();
        WebElement passELe = driver.findElement(password);
        passELe.sendKeys(pass);
    }
    public void clickLogin(){
        WebElement loginEle = driver.findElement(login_button);
        loginEle.click();
    }
}
