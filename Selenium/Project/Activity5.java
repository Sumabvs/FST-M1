package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class Activity5 {

    WebDriver driver = new FirefoxDriver();

    @BeforeMethod
    public void openBrowser() throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        driver.get("https://alchemy.hguy.co/jobs/");
        driver.manage().window().maximize();
        Thread.sleep(1000);
    }

    @Test
    public void JobPages() throws InterruptedException {
        WebElement JobsPage= driver.findElement(By.linkText("Jobs"));
        JobsPage.click();
        Thread.sleep(1000);

    }
    @AfterMethod
    public void verifyTitle(){
        WebElement title=driver.findElement(By.xpath("//title"));
        if(title.getAttribute("innerHTML").equals("Jobs – Alchemy Jobs"))
        {
            System.out.println("Title is :" +title.getAttribute("innerHTML"));
            driver.quit();
        }
        else{
            System.out.println("Title is not equals to:" +title.getAttribute("innerHTML"));
        }
    }



    @AfterTest
    public void closeBrowser(){
        driver.quit();

    }

}
