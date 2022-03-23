package Mini_Assignment2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Headless_Mode {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\malpraneeth\\Documents\\chromedriver.exe");


        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        System.out.println("Chrome window size is maximized");
        driver.get("https://phptravels.com/demo");
        System.out.println("navigation to the given url is successful!");
        Thread.sleep(2000);

        String parentWindow = driver.getWindowHandle();

        String actualTitle = driver.getTitle();
        System.out.println("if the title of the url is same as 'PHPTRAVELS' then return pass else fail: ");
        if(actualTitle.contains("PHPTRAVELS")){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        Thread.sleep(2000);


        By loginButton = By.xpath("//a[text()='Login']");
        driver.findElement(loginButton).click();
        System.out.println("clicking on login button is successful!");
        Thread.sleep(2000);
        String actualTitle1 = driver.getTitle();
        System.out.println("=========================================================================================================");
        System.out.println("if the title of the currenturl is same as previousurl title then return pass else fail: ");
        if(actualTitle1.contains(actualTitle)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }
        Thread.sleep(2000);
        System.out.println("==============================================================================================================");

        driver.switchTo().window(parentWindow);
        System.out.println();
        System.out.println("switching back to the parent window is successful");
        Thread.sleep(2000);

        String currentUrl = driver.getCurrentUrl();
        System.out.println("current url: "+currentUrl);
        System.out.println("===========================================================================================================");

        By priceOpt = By.xpath("//a[text()='Pricing']");
        driver.findElement(priceOpt).click();
        System.out.println();
        System.out.println("clicking on price is successful!");
        Thread.sleep(2000);

        driver.navigate().back();
        System.out.println("navigate backwards in the existing window is successful!");
        Thread.sleep(2000);

        driver.navigate().refresh();
        System.out.println("reloading the current webpage is successful!");
        Thread.sleep(2000);

        driver.quit();
        System.out.println("driver is closed successfully...");

    }
}