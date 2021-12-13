from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import logging
import time

from selenium.webdriver.common.by import By

logger = logging.getLogger('simple_example')
logger.setLevel(logging.INFO)
ch = logging.StreamHandler()
ch.setLevel(logging.DEBUG)
formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
ch.setFormatter(formatter)
logger.addHandler(ch)

service = Service(r"C:\Users\bialy\OneDrive\Desktop\UCZELNIA\TAU - Testy Automatyczne\geckodriver-v0.30.0-win64\geckodriver.exe")
#options = ChromiumOptions()
#options.add_argument("--start-maximized")
driver = webdriver.Firefox(service=service)
driver.maximize_window()

logger.info('Start first test')
logger.info('Navigate to wykop.pl website')
driver.get('https://www.wykop.pl/')
time.sleep(5) #time to accept cookies, tbh dont know how to override this...
#driver.find_element(By.XPATH, "/html/body/div/div/div/div/div/div/div[3]/div[2]/button").click()
logger.info('Kill all popups!!!! we hate cookies and layout popups that disrupt our work!')
WebDriverWait(driver, 60).until(EC.presence_of_element_located((By.ID, 'popup-close')))
driver.find_element(By.ID, 'popup-close').click()
driver.find_element(By.CLASS_NAME, 'dropdown-show.auto.js-do-redirect').click()
time.sleep(1)
logger.info('Try to log in')
driver.find_element(By.ID, 'newregister-login').send_keys('dziki dzik')
driver.find_element(By.ID, 'newregister-pass').send_keys('12345678')
driver.find_element(By.CLASS_NAME, 'row.buttons').click()
time.sleep(3)

# ---------------------- SECOND TEST --------------------------

logger.info('Start second test')
logger.info('Navigate to bankier.pl website')

driver.get('https://www.bankier.pl/')
time.sleep(5) #time to accept cookies, tbh dont know how to override this...
driver.find_element(By.CLASS_NAME, 'a-icon.a-icon-user').click()
logger.info('Try to log in')
driver.find_element(By.ID, 'login_email').send_keys('asdfdsafdsaJohnny')
driver.find_element(By.ID, 'password').send_keys('secretpassword')
driver.find_element(By.ID, 'loginSubmit').click()
logger.info('Ooooops, dont know our credentials :/')
driver.find_element(By.CLASS_NAME, 'more-link').click()
driver.find_element(By.ID, 'login_email').send_keys('asdfdsafdsaJohnny')
driver.find_element(By.ID, 'reminderSubmit').click()

time.sleep(2)

driver.close()