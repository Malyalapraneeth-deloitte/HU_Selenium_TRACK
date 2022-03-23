package Mini_Assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.ous.jtoml.impl.SymbolToken.Equals;

public class ChromeBrowser {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\malpraneeth\\Documents\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://phptravels.com/demo");
        Thread.sleep(2000);
        String parentWindow = driver.getWindowHandle();
        String actualTitle = driver.getTitle();
        if(actualTitle.contains("PHPTRAVELS")){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        Thread.sleep(2000);
        By loginButton = By.xpath("//a[text()='Login']");
        driver.findElement(loginButton).click();
        Thread.sleep(2000);
        String Title = driver.getTitle();
        if(Title.contains(actualTitle)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        Thread.sleep(2000);


        driver.switchTo().window(parentWindow);
        Thread.sleep(2000);
        String CurrentUrl = driver.getCurrentUrl();
        System.out.println("current url: "+CurrentUrl);
        By priceOpt = By.xpath("//a[text()='Pricing']");
        driver.findElement(priceOpt).click();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.close();
    }

}
