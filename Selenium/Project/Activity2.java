package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {

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
        WebElement heading=driver.findElement(By.xpath("//h1[text()='Welcome to Alchemy Jobs']"));
        if(heading.getText().equals("Welcome to Alchemy Jobs"))
        {
            System.out.println("Headline matches  :" +heading.getText());
            driver.quit();
        }
        else{
            System.out.println("Headline doesn't matches:" +heading.getText());
        }
    }
}
