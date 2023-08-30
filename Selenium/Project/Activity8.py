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
    driver.get("https://alchemy.hguy.co/jobs/wp-login.php?loggedout=true&wp_lang=en_US")
    driver.maximize_window()
    print("Page Title is ", driver.title)
    time.sleep(8)

    #login
    username=driver.find_element(By.XPATH,"//input[@id='user_login']")
    username.send_keys("root")
    time.sleep(8)

    password=driver.find_element(By.XPATH,"//input[@id='user_pass']")
    password.send_keys("pa$$w0rd")
    time.sleep(8)

    #click on login button
    loginbutton=driver.find_element(By.XPATH,"//input[@value='Log In']")
    loginbutton.click()
    print("Login is successful")
    driver.quit()