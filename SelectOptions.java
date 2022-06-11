package com.june2ndweek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class SelectOptions {


    @Test
    public void fbsignup_SelectType() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='First name']")).sendKeys("Test123");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("test@123");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("test@yahoo.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("test@yahoo.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("test@1234");
        Thread.sleep(1000);

        WebElement day = driver.findElement(By.xpath("//select[@name='birthday_day']"));
        Select select = new Select(day);
        List<WebElement> options = select.getOptions();
        int size = options.size();
        select.selectByIndex(0);
        Thread.sleep(3000);
        select.selectByIndex(3);
        Thread.sleep(3000);
        boolean value1 = select.isMultiple();
        Thread.sleep(3000);
        System.out.println(value1);


        System.out.println("Number of elements present inside the listBox is : " + size);
        for (WebElement webElement : options) {
            String text = webElement.getText();
            System.out.println(text);
        }
        Thread.sleep(1000);

        WebElement month = driver.findElement(By.xpath("//select[@name='birthday_month']"));
        Select select1 = new Select(month);
        List<WebElement> option = select1.getOptions();
        select1.selectByVisibleText("Jan");
        select1.isMultiple();
        int size_month = option.size();
        System.out.println("Number of elements present inside the Month_List is : " + size_month);
        Thread.sleep(1000);

        WebElement year = driver.findElement(By.xpath("//select[@name='birthday_year']"));
        Select select2 = new Select(year);
        select2.selectByValue("1905");
        Thread.sleep(1000);
        select2.selectByIndex(20);
        Thread.sleep(1000);
        boolean value = select2.isMultiple();
        System.out.println(value);

        driver.findElement(By.xpath("//label[contains(text(),'Female')]")).click();
        driver.findElement(By.xpath("//label[contains(text(),'Male')]")).click();
        Thread.sleep(1000);
        //driver.findElement(By.xpath("//button[@name='websubmit']")).click();
        //Thread.sleep(2000);
        driver.close();
    }

}
