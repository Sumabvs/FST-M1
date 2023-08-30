import time

import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


@pytest.fixture(scope="session")
def setup(request):


    driver = webdriver.Firefox()


    session = request.node


    for item in session.items:
        cls = item.getparent(pytest.Class)
        setattr(cls.obj,"driver",driver)

    # Execute the test method
    yield

    # Close the browser once the test has ended
    request.addfinalizer(driver.close)

@pytest.mark.usefixtures("setup")
class TestSite:

    def test_home_page(self):
        self.driver.get("https://alchemy.hguy.co/jobs/")
        self.driver.maximize_window()
        #click on job
        JobsPage=self.driver.find_element(By.LINK_TEXT,"Jobs")
        JobsPage.click()
        time.sleep(2)
        #providing Keyword in Textbox
        searchkey=self.driver.find_element(By.XPATH,"//input[@id='search_keywords']")
        searchkey.send_keys("Banking")
        time.sleep(2)
        # click on search button
        searchbutton=self.driver.find_element(By.XPATH,"//input[@type='submit']")
        searchbutton.click()
        time.sleep(2)
        #selecting the BankingTestJob result
        result=self.driver.find_element(By.XPATH,"//div[@class='position']/h3[text()='BankingTestJob']")
        result.click()
        time.sleep(2)
        #click on apply job
        Apply=self.driver.find_element(By.XPATH,"//input[@type='button']")
        Apply.click()
        time.sleep(2)
        #prinitng the email id
        Email=self.driver.find_element(By.XPATH,"//a[text()='abhiram@cklabs.com']")
        print("\nEmail id is :" +Email.text)









