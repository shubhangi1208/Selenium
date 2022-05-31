import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FrameTest {

    @Test
    public void frameTest() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("C:\\Users\\Hp\\IdeaProjects\\selenium\\src\\main\\resources\\page2.html");

        driver.findElement(By.id("t2")).sendKeys("T2 Text field");

        driver.switchTo().frame("f1");
        Thread.sleep(2000);
        driver.findElement(By.id("t1")).sendKeys("T1 Text field");
        Thread.sleep(2000);

        driver.switchTo().parentFrame();
        driver.switchTo().frame("f2");
        Thread.sleep(2000);
        driver.findElement(By.id("t3")).sendKeys("T3 Text Field");
        Thread.sleep(2000);

        driver.switchTo().defaultContent();
        driver.findElement(By.id("t2")).clear();
        Thread.sleep(2000);
        driver.findElement(By.id("t2")).sendKeys("Re-entered text in T2");
    }

    @AfterMethod
    public void closeDriver() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //driver.quit();
    }
}
