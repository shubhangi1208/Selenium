package com.june2ndweek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SearchSelenium {

    WebDriver driver = null;

    @BeforeMethod
    public void initialization() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void autoSuggestion() {
        driver.get("http://www.google.com");
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("selenium");
        List<WebElement> suggesstions = driver.findElements(By.xpath("//ul[@class='erkvQe']"));
        int count = suggesstions.size();
        System.out.println("No of suggesstions available on google : "+count);
        String expectedValue = "selenium interview questions";
        for (WebElement option : suggesstions ) {
            String text = option.getText();
            System.out.println("Suggestions Available: "+ text);
            if(text.equalsIgnoreCase(expectedValue)){
                option.click();
                break;
            }
        }
    }

    @AfterMethod
    public void closeDriver() {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

}
