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

public class HtmlTable {

    WebDriver driver = null;

    @BeforeMethod
    public void initialization() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void htmlTable(){
        driver.get("C:\\Users\\Hp\\IdeaProjects\\selenium\\src\\main\\resources\\HtmlTable.html");
        List<WebElement> allRows = driver.findElements(By.xpath("//tr"));
        int totalRows = allRows.size();
        System.out.println("total number of rows present in the table is :"+ totalRows);
        List<WebElement> allColumns = driver.findElements(By.xpath("//th"));
        int totalColumns = allColumns.size();
        System.out.println("Total number of columns in the table is :" + totalColumns);

        List<WebElement> allCells = driver.findElements(By.xpath("//th|//td"));
        int totalCells = allCells.size();
        System.out.println("Total number of cells present in the table is :" + totalCells);
        int countNumberValue = 0;
        int sum=0;

        for (WebElement cell : allCells) {
            String cellValue = cell.getText();
            try{
                int number = Integer.parseInt(cellValue);
                System.out.println(number);
                countNumberValue++;
                sum = sum+number;
            }catch (Exception e) {
            }
        }
        System.out.println("Total count of numeric values is :"+countNumberValue);
        System.out.println("Total sum of all the numeric values is :"+sum);
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
