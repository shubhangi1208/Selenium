import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;


public class KeyboardOperations {
    @Test
    public  void keyboardOperations() throws InterruptedException, AWTException {
        WebDriverManager.edgedriver().setup();
        WebDriver driver =new EdgeDriver();
        driver.get("https://www.facebook.com/");
        Thread.sleep(2000);
        Robot r = new Robot(); //Creating an object of Robot Clas
        r.mouseMove(300,500);  //move the mouse by x and y coordinate
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_SHIFT);
        r.keyPress(KeyEvent.VK_I);
        Thread.sleep(2000);
        r.keyRelease(KeyEvent.VK_I);
        r.keyPress(KeyEvent.VK_C);
        r.keyRelease(KeyEvent.VK_SHIFT);
        r.keyRelease(KeyEvent.VK_CONTROL);
    }
}
