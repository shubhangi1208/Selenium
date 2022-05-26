import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FacrbookCreateAccount {
    @Test
    public void facebookCreateNewAcount() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\IdeaProjects\\selenium\\src\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        Thread.sleep(2000);
        driver.findElement(By.linkText("Create New Account")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("firstname")).sendKeys("Shubhangi");
        Thread.sleep(2000);
        driver.findElement(By.name("lastname")).sendKeys("Amilkanthwar");
        Thread.sleep(2000);
        driver.findElement(By.name("reg_email__")).sendKeys("Test@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("Test@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.name("reg_passwd__")).sendKeys("Test@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.name("birthday_day")).sendKeys("12");
        Thread.sleep(2000);
        driver.findElement(By.name("birthday_month")).sendKeys("Aug");
        Thread.sleep(2000);
        driver.findElement(By.name("birthday_year")).sendKeys("1995");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[contains(text(),'Female')]")).click();
        Thread.sleep(2000);
    }
}
