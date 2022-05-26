import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WaitsInSelenium {
    @Test
    public void implicitWait(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Create New Account")).click();
        List<WebElement> gender = driver.findElements(By.name("sex"));
        gender.get(0).click();
        driver.close();
    }
    @Test
    public void explicitWait(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        WebDriverWait wait=new WebDriverWait(driver, 20);
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        driver.findElement(By.id("email")).sendKeys("Test@gmail.com");
        driver.findElement(By.name("pass")).sendKeys("Test@123");
        driver.findElement(By.name("login")).submit();

    }
    @Test
    public void fluentWait() {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        WebElement fb1 = driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
        System.out.println(fb1.getText());
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")));
        driver.findElement(By.xpath("//input[@placeholder='First name']")).sendKeys("Shubhangi");
    }
}
