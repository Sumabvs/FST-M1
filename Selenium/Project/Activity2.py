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
        time.sleep(100)
        headline=self.driver.find_element(By.XPATH,"//h1[text()='Welcome to Alchemy Jobs']")
        actualheadline="Welcome to Alchemy Jobs"
        if headline.text==actualheadline:
            print("\nHeadline Matched")
        else:
            print("Headline is not Matched")

