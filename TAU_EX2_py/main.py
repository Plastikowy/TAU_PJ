from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import ChromiumOptions
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

service = Service(r"C:\Users\bialy\OneDrive\Desktop\UCZELNIA\TAU - Testy Automatyczne\chromedriver_win32\chromedriver.exe")
options = ChromiumOptions()
options.add_argument("--start-maximized")
driver = webdriver.Chrome(options=options, service=service)

logger.info('Start first test')
logger.info('Navigate to trojmiasto.pl website')
driver.get('https://www.trojmiasto.pl/')
driver.find_element(By.ID, 'search_input').send_keys('praca')
driver.find_element(By.ID, 'search_submit_button').click()
driver.find_element(By.CLASS_NAME, 'serviceList__item').click()
driver.find_element(By.CLASS_NAME, 'employers__searchbar__input').send_keys('intel')
logger.info('Search for Intel jobs')
driver.find_element(By.CLASS_NAME, 'btn__praca').click()
driver.find_element(By.CLASS_NAME, 'emplotersListItemCounter').click()

# ---------------------- SECOND TEST --------------------------

logger.info('Start second test')
logger.info('Navigate to hltv.org website')
driver.get('https://www.hltv.org/')
# driver.find_element(By.CLASS_NAME, 'twitter-typeahead')[0]
time.sleep(2)
input = driver.find_element(By.CLASS_NAME, "twitter-typeahead")
logger.info('Search for Natus Vincere team')
input.find_element(By.CLASS_NAME, "navsearchinput.tt-input").send_keys("Natus Vincere")
input.submit()
table = driver.find_element(By.CLASS_NAME, "table")
table.find_element(By.CLASS_NAME, "team-logo").click()
logger.info('Check out their current roster with their history and players ratings')
time.sleep(2)
driver.find_element(By.XPATH, "/html/body/div[3]/div/div[2]/div[1]/div[2]/div[7]/div/div[2]").click()
time.sleep(5)


driver.close()