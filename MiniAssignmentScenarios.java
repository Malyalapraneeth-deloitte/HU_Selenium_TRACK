import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MiniAssignmentScenarios {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","C:\\Users\\malpraneeth\\Documents\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //scenario 1
        driver.get("https://the-internet.herokuapp.com/");
        Thread.sleep(3000);
        By frames=By.xpath("//a[@href='/frames']");
        driver.findElement(frames).click();
        Thread.sleep(3000);
        By Nestedframes=By.xpath("//a[text()='Nested Frames']");
        driver.findElement(Nestedframes).click();
        Thread.sleep(3000);
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement l = driver.findElement(By.cssSelector("body"));
        System.out.println(l.getText());

        //scenario 2
        driver.get("https://jqueryui.com/droppable/");
        WebElement frame=driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
        driver.switchTo().frame(frame);
        WebElement drag=driver.findElement(By.id("draggable"));
        WebElement drop=driver.findElement(By.id("droppable"));
        Actions action=new Actions(driver);
        action.dragAndDrop(drag,drop).perform();

        //scenario 3
        driver.get("https://the-internet.herokuapp.com/");
        Thread.sleep(2000);
        By javascript=By.xpath("//a[@href='/javascript_alerts']");
        driver.findElement(javascript).click();
        Thread.sleep(2000);
        By jspromt=By.xpath("//button[@onclick='jsPrompt()']");
        driver.findElement(jspromt).click();
        System.out.println("Getting the text of the alert:");
        System.out.println(driver.switchTo().alert().getText());//driver.switchTo().alert().getText();
        System.out.println("Passing the keys to the alert:");
        driver.switchTo().alert().sendKeys("Test");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        String result=driver.findElement(By.xpath("//*[@id=\"result\"]")).getText();
        String expected="You entered: Test";
        if(expected.equals(result)==true)
        {
            System.out.println("Pass");
        }
        else
        {
            System.out.println("Fail");
        }}}
