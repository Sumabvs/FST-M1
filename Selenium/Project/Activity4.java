package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Activity4 {
    WebDriver driver = new FirefoxDriver();

    @BeforeMethod
    public void openBrowser() throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        driver.get("https://alchemy.hguy.co/jobs/");
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }
    @Test
    public void verifyTitle(){
        WebElement secondhead=driver.findElement(By.xpath("//h2[contains(text(),'Quia quis non')]"));
        assertEquals(secondhead.getText(),"Quia quis non");
        System.out.println("Second Heading   :" +secondhead.getText());
        driver.quit();

    }
}
