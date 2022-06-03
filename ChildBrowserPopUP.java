import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class ChildBrowserPopUP {
    WebDriver driver = null;

    @BeforeMethod
    public void initialization() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void childBrowserPopup() throws InterruptedException {
        driver.get("https://www.naukri.com/");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//body//div[@id='root']//div//div//div//li[1]//a[1]//div[1]")).click();
        Thread.sleep(4000);
        Set<String> allWindowHandles = driver.getWindowHandles();
        Thread.sleep(4000);
        int count = allWindowHandles.size();
        Thread.sleep(4000);
        System.out.println("Number of browser windows opened on the system is : " + count);
        Thread.sleep(4000);
        for (String windowHandle : allWindowHandles) {
            driver.switchTo().window(windowHandle);
            String title = driver.getTitle();
            System.out.println("Window handle id of page -->" + title + " --> is : " + windowHandle);
        }
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

