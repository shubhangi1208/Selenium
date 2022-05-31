import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class JavaScriptExecutor {
    @Test
    public void disabledFieldText() throws InterruptedException {
        WebDriverManager.edgedriver() .setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("C:\\Users\\Hp\\IdeaProjects\\selenium\\src\\main\\resources\\disabledTextField.html");
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(2000);
        //enter "admin" in first textbox using javascript
        js.executeScript("document.getElementById('t1').value='shubhangi'");
        Thread.sleep(2000);
        js.executeScript("document.getElementById('t2').value=''");
        Thread.sleep(2000);
        js.executeScript("document.getElementById('t2').value='shubhangi Topale'");
    }
}
