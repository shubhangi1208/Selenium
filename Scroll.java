import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Scroll {
    @Test
    public void scroolupandDown() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://seleniumhq.org/download");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 1; i < 10; i++) {
//scroll down on the webpage
            js.executeScript("window.scrollBy(0, 100)");
            Thread.sleep(2000);
        }
        for (int i = 1; i < 10; i++) {
//scroll up on the webpage
            js.executeScript("window.scrollBy(0, -100)");
            Thread.sleep(2000);
        }
    }

}
