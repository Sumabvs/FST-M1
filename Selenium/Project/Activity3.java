package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity3 {
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
        WebElement imageurl=driver.findElement(By.xpath("//img[@src='https://alchemy.hguy.co/jobs/wp-content/uploads/2019/09/career-corporate-job-776615-e1569782235456-1024x271.jpg']"));
        System.out.println("URL of Image is  :" +imageurl.getAttribute("src"));
        driver.quit();

    }
}
