package com.june2ndweek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FindElements {
    WebDriver driver = null;

    @BeforeMethod
    public void initialization(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void findElementsDemo(){
        driver.get("https://www.engagebay.com/products/crm?utm_source=bing-ppc&utm_medium=cpc&matchtype=e&device=c&campaign=CRM_Intl&msclkid=4ba2bd9614321e3bdea2df0b7f16a883");
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        int totalLinks = allLinks.size();
        System.out.println("total number of links present on the web page is : "+totalLinks);
        int visibleLinkCount = 0;
        int hiddenLinkCount = 0;
        for (WebElement link : allLinks) {
            if (link.isDisplayed()) {
                visibleLinkCount++;
                System.out.println(visibleLinkCount+" --> "+link.getText());
            }else{
                hiddenLinkCount++;
            }
        }
        System.out.println("Total number of visible links :" + visibleLinkCount);
        System.out.println("Total number of hidden links :" + hiddenLinkCount);
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


