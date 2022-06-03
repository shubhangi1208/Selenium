import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class JavascriptPopUp {
    @Test
    public void javaScriptPopUp() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.tizag.com/javascriptT/javascriptprompt.php");
        driver.findElement(By.xpath("//input[@value='Say my name!']")).click();

        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        System.out.println(alert.getText());
        alert.sendKeys("Shuhangi");
        alert.accept();
        Thread.sleep(2000);
         //print the text present on the second alert pop up
        //System.out.println(alert.getText());
         //click on Cancel button
        //alert.dismiss();

    }
}
