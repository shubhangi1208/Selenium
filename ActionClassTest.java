import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ActionClassTest {
    @Test
    public void mouseHover(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.istqb.in/");
        Actions actions = new Actions(driver);
        WebElement foundation = driver.findElement(By.xpath("//a[contains(text(),'Foundation')]"));
        actions.moveToElement(foundation).perform();
        WebElement examDates = driver.findElement(By.linkText("EXAM DATES"));
        actions.moveToElement(examDates).click().perform();

    }
@Test
    public void dragAndDrop() throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://jqueryui.com/droppable/");
    Thread.sleep(2000);
    driver.switchTo().frame(0);
    Thread.sleep(2000);
    Actions actions = new Actions(driver);
    actions.dragAndDrop(driver.findElement(By.id("draggable")),
            driver.findElement(By.id("droppable"))).perform();
    Thread.sleep(2000);
    }

    @AfterMethod
    public void closeDriver() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }

}
