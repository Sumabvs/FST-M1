import pytest
import time

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())
# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Open the browser to the URL
    driver.get("https://alchemy.hguy.co/jobs")
    driver.maximize_window()
    print("Page Title is ", driver.title)
    time.sleep(8)

    SecondHeader = driver.find_element(By.XPATH,"//h2[contains(text(),'Quia quis non')]")
    print("The SecondHeader title is " , SecondHeader.text)
    assert "Quia quis non" in SecondHeader.text
    driver.quit()