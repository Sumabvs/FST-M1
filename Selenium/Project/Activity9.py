import pytest
import time

from selenium import webdriver
from random import randrange, random
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
    time.sleep(3)

    password=driver.find_element(By.XPATH,"//input[@id='user_pass']")
    password.send_keys("pa$$w0rd")
    time.sleep(3)

    #click on login button
    loginbutton=driver.find_element(By.XPATH,"//input[@value='Log In']")
    loginbutton.click()
    print("Login is successful")
    time.sleep(8)

    #Clicking on Job Findings
    jobfindlink=driver.find_element(By.XPATH,"//li[@id='menu-posts-job_listing']")
    jobfindlink.click()
    time.sleep(3)

    #click on Add New button
    addnew=driver.find_element(By.XPATH,"//a[@class='page-title-action'] | //a[text()='Add New'][7]")
    addnew.click()
    time.sleep(3)

    data=[0 for i in range(7)]
    data[0]=driver.find_element(By.XPATH,"//div[@class='block-library-classic__toolbar has-advanced-toolbar']")
   # data[0].click()
    #data[1]=driver.find_element(By.XPATH,"//div[@class='wp-block-freeform block-library-rich-text__tinymce mce-content-body html5-captions mce-edit-focus']")
    data[1]=driver.find_element(By.XPATH,"//textarea[@id='post-title-0']")

    data[2]=driver.find_element(By.XPATH,"//input[@id='_company_website']")
    data[3]=driver.find_element(By.XPATH,"//input[@id='_company_twitter']")
    data[4]=driver.find_element(By.XPATH,"//input[@id='_job_location']")
    data[5]=driver.find_element(By.XPATH,"//input[@id='_company_name']")
    data[6]=driver.find_element(By.XPATH,"//input[@id='_company_tagline']")
   # data[6]=driver.find_element(By.XPATH,"//input[@id='company_name']")


    popup_link = driver.find_element(By.XPATH, "//button[@aria-label='Close dialog']").click()
    time.sleep(1)
    data[1].click()
    data[1].send_keys("Quality Assurance ")
    driver.execute_script("window.scrollTo(0,document.body.scrollHeight)")
    data[2].send_keys("www.test.com")
    data[3].send_keys("test.twit")
    data[4].send_keys("Banglore")
    data[5].send_keys("New Look")
    data[6].send_keys("Look here")
    #data[6].send_keys("IBM")
    time.sleep(3)

    #click on publish
    publish=driver.find_element(By.XPATH,"//button[text()='Publish…']")
    publish.click()
    time.sleep(3)

    #are you ready to publish
    publishready=driver.find_element(By.XPATH,"//button[text()='Publish']")
    publishready.click()
    time.sleep(3)

    #verify new job live message
    jobtitle=driver.find_element(By.XPATH,"//a[text()='"+data[1].text+"']")
    print("Job Title is:" +jobtitle.text)
#    resttitle=driver.find_element(By.XPATH,"//div //text()[normalize-space()='is now live.']")
    resttitle=driver.find_element(By.XPATH,"//div[text()='is now live.']")
    if resttitle.text==jobtitle.text+" is now live.":
     print("Job Title is:" +resttitle.text)
    else:
        print("Job Title is not matching:")