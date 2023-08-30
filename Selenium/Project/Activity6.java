package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.List;
import java.util.Set;


public class Activity6 {


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

       // @Test(dependsOnMethods = {"JobPages"})
       @AfterMethod
        public void SearchJob() throws InterruptedException {
            //sending input to Keyword inputtext
            WebElement searchkey=driver.findElement(By.xpath("//input[@id='search_keywords']"));
            searchkey.sendKeys("Banking");
           Thread.sleep(1000);

            //clicking on search job button
            WebElement searchbutton=driver.findElement(By.xpath("//input[@type='submit']"));
            searchbutton.click();
           Thread.sleep(1000);
            //selecting the BankingTestJob result
            WebElement result=driver.findElement(By.xpath("//div[@class='position']/h3[text()='BankingTestJob']"));
            result.click();
           Thread.sleep(1000);


        }
        @AfterClass
        public void ApplyJob() throws InterruptedException {
            WebElement Apply=driver.findElement(By.xpath("//input[@type='button']"));
            Apply.click();
            Thread.sleep(1000);
            WebElement Email=driver.findElement(By.xpath("//a[text()='abhiram@cklabs.com']"));
            System.out.println("Email id is :" +Email.getText());
        }

      @AfterTest
        public void closeBrowser(){
            driver.quit();

        }

}

