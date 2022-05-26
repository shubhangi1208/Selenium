import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
public class CaptureScreenshot {

    @Test
    public void captureScreenshotTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\IdeaProjects\\selenium\\src\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        try {
            FileHandler.copy(takesScreenshot.getScreenshotAs(OutputType.FILE), new File("C:\\Users\\Hp\\IdeaProjects\\selenium\\Screenshot\\Screenshot_" + System.currentTimeMillis() + ".png"));
        } catch (WebDriverException e) {

        } catch (IOException e) {

        }
        Thread.sleep(2000);
        driver.close();
    }
}
