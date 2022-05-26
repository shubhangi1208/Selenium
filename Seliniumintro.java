import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.Scanner;

public class Seliniumintro {
    @Test
    public static void facebookLoginChrome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hp\\IdeaProjects\\selenium\\src\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        Thread.sleep(2000);
        //System.out.println("Title of web page:"+driver.getTitle());
       //System.out.println("Current web page url: "+driver.getCurrentUrl());
        driver.findElement(By.id("email")).sendKeys("Test@gmail.com");
        Thread.sleep(2000);
        //driver.findElement(By.id("email")).clear();
        //Thread.sleep(2000);
        driver.findElement(By.name("pass")).sendKeys("Test@123");
        driver.findElement(By.name("login")).submit();
    }

    @Test
    public static void facebookLoginEdge() throws InterruptedException {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Hp\\IdeaProjects\\selenium\\src\\Driver\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        Thread.sleep(2000);
        driver.findElement(By.id("email")).sendKeys("Test@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.name("pass")).sendKeys("Test@123");
        driver.findElement(By.name("login")).submit();
    }

    @Test
    public static void facebookLoginFirefox() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Hp\\IdeaProjects\\selenium\\src\\Driver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        Thread.sleep(2000);
        driver.findElement(By.id("email")).sendKeys("Test@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.name("pass")).sendKeys("Test@123");
        driver.findElement(By.name("login")).submit();
    }

    public static void main(String[] args) throws InterruptedException {
        int choice;
        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("Kindly Enter choice \n 1. Facebook Login through Chrome \n 2. Facebook Login through Microsoft edge \n 3. Facebook Login through firefox \n 4. Exit ");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    facebookLoginChrome();
                    break;
                case 2:
                    facebookLoginEdge();
                    break;
                case 3:
                    facebookLoginFirefox();
                    break;
                case 4:
                    System.out.println("Thank you.");
                    break;
            }
        } while (choice != 4);
    }
}