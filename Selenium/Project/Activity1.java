package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {

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
       WebElement title=driver.findElement(By.xpath("//title"));
        if(title.getAttribute("innerHTML").equals("Alchemy Jobs – Job Board Application"))
        {
            System.out.println("Title is :" +title.getAttribute("innerHTML"));
            driver.quit();
        }
        else{
            System.out.println("Title is not equals to:" +title.getAttribute("innerHTML"));
        }
    }
}
