import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class IsEnabled {
    @Test
    public void isEnable() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.hubspot.com/login");
        driver.findElement(By.id("username")).sendKeys("ashubhangi1996@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.id("password")).sendKeys("Shubh@1234");
        WebElement UN =driver.findElement(By.id("loginBtn"));
        if (UN.isEnabled()) {
            System.out.println("Login button is enabled");
        }else {
            System.out.println("Login button is disabled");
        }
        //driver.close();
    }
    @Test
    public void isSelectedCheckbox() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        Thread.sleep(2000);
        driver.findElement(By.linkText("Create New Account")).click();
        Thread.sleep(2000);
        WebElement gender = driver.findElement(By.xpath("//label[contains(text(),'Female')]"));
        gender.click();
        Thread.sleep(2000);
        if (gender.isSelected()) {
            System.out.println("Checkbox is selected");
        }else{
            System.out.println("Checkbox is NOT selected");
        /*driver.get("https://app.hubspot.com/login");
        WebElement rememberMe_Checkbox =driver.findElement(By.id("checkbox-content-4"));
        rememberMe_Checkbox.click();
        Thread.sleep(2000);
        if (rememberMe_Checkbox.isSelected()) {
            System.out.println("Checkbox is selected");
        }else{
            System.out.println("Checkbox is NOT selected");*/

        }
    }
}
