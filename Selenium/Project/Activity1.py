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
        title=self.driver.find_element(By.XPATH,"//title")
        actualtitle="Alchemy Jobs – Job Board Application"
        if title.get_attribute("innerHTML")==actualtitle:
            print("\nTitle Matched")
        else:
            print("Title is not Matched")

