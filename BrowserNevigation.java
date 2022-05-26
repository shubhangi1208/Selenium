import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;


public class BrowserNevigation {

    @Test
    public void browserNevigationTest() throws InterruptedException {
    WebDriverManager.edgedriver().setup();
    WebDriver driver =new EdgeDriver();
    driver.get("https://www.facebook.com/");
    Thread.sleep(2000);
    driver.navigate().to("https://www.amazon.in/");
    Thread.sleep(2000);
    driver.navigate().back();
    Thread.sleep(2000);
    driver.navigate().forward();
    Thread.sleep(2000);
    driver.navigate().refresh();
    Thread.sleep(2000);
    }
}
