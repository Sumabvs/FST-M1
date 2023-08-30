import string

import pytest
import time
from random import randrange, random
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

    #click on Post job
    PostJobs=driver.find_element(By.LINK_TEXT,"Post a Job")
    PostJobs.click()
    time.sleep(2)

    #capturing elements
    data=[0 for i in range(7)]
    data[0]=driver.find_element(By.XPATH,"//input[@id='create_account_email']")
    data[1]=driver.find_element(By.XPATH,"//input[@id='job_title']")
    data[2]=driver.find_element(By.XPATH,"//input[@id='job_location']")
    data[3]=driver.find_element(By.XPATH,"//select[@id='job_type']")
    data[4]=driver.find_element(By.XPATH,"//iframe[@id='job_description_ifr']")
    data[5]=driver.find_element(By.XPATH,"//input[@id='application']")
    data[6]=driver.find_element(By.XPATH,"//input[@id='company_name']")

    #provide inputs

    str_Key=str(randrange(10))
    data[0].send_keys("example"+str_Key+"@test.com")
    data[1].send_keys("QA Job")
    data[2].send_keys("Banglore")
    data[3].send_keys("Full Time")
    data[4].send_keys("Looking for new opportunity")
    data[5].send_keys("example"+str_Key+"@test.com")
    data[6].send_keys("IBM")

    #driver.execute_script("window.scrollTo(0, Y)")
    driver.execute_script("window.scrollTo(0,document.body.scrollHeight)")#execute_script("window.scrollTo(0,document.body.scrollHeight)")
    #click on preview
    preview=driver.find_element(By.XPATH,"//input[@value='Preview']")
    preview.click()
    time.sleep(2)

    #click on submit listing
    submitlist=driver.find_element(By.XPATH,"//input[@value='Submit Listing']")
    submitlist.click()
    time.sleep(2)

    JobsPage=driver.find_element(By.LINK_TEXT,"Jobs")
    JobsPage.click()
    time.sleep(2)
    #providing Keyword in Textbox
    searchkey=driver.find_element(By.XPATH,"//input[@id='search_keywords']")
    searchkey.send_keys("QA Job")
    time.sleep(3)
    # click on search button
    searchbutton=driver.find_element(By.XPATH,"//input[@value='Search Jobs']")
    searchbutton.click()
    time.sleep(4)

    #verify QA Job result
    result=driver.find_element(By.XPATH,"//div[@class='position']/h3[text()='QA Job']")
    #assert "QA Job" in result.text
    actualresult="QA Job"
    if result.text==actualresult:
        print("\nResult Matched")
    else:
        print("Result is not Matched")
    time.sleep(2)
    driver.quit()
