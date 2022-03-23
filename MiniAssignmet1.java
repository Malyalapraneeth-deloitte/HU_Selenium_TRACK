package Mini_Assignment;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class MiniAssignmet1<by> {
    public WebDriver driver;
   // By PHPTRAVELSlogo = By.xpath("//img[@alt=\"logo\"]");
    By logo = By.xpath("//img[@alt='logo']");
    By home = By.xpath("//a[contains(@class,'logo')]");
    By flight = By.xpath("//a[text()='flights']");
    By tours = By.xpath("//a[text()='Tours']");
    By company = By.xpath("//a[@href='company']");
    By signUpBtn = By.className("theme-btn theme-btn-small theme-btn-small waves-effect");
    By loginBtn = By.xpath("//a[text()='Login']");
    By agentsDropDown=By.id("agents");

    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\malpraneeth\\Documents\\chromedriver.exe");
        WebDriver Driver = new ChromeDriver();
        Driver.manage().window().maximize();
        Driver.get("https://www.phptravels.net/hotels");
    }

}
