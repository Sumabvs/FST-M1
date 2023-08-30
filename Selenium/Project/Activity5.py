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

    #click on job
    JobsPage=driver.find_element(By.LINK_TEXT,"Jobs")
    JobsPage.click()
    time.sleep(2)
    #verify title of Jobs page
    title=driver.find_element(By.XPATH,"//title")
    actualtitle="Jobs – Alchemy Jobs"
    if title.get_attribute("innerHTML")==actualtitle:
        print("\nTitle Matched")
    else:
        print("Title is not Matched")