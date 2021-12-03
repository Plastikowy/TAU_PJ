from selenium import webdriver
from selenium.webdriver.chrome.service import Service
import logging

logger = logging.getLogger('simple_example')
logger.setLevel(logging.INFO)
ch = logging.StreamHandler()
ch.setLevel(logging.DEBUG)
formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
ch.setFormatter(formatter)
logger.addHandler(ch)

service = Service(r"C:\Users\bialy\OneDrive\Desktop\UCZELNIA\TAU - Testy Automatyczne\chromedriver_win32\chromedriver.exe")
driver = webdriver.Chrome(service=service)

logger.info('Przechodzę na stronę Zalando')
driver.get('https://www.zalando.pl/')
temp = driver.find_element_by_class_name('z-navicat-header_navToolItemLink')
temp.click()
logger.warning('Jakieś ostrzeżenie')
temp = driver.find_element_by_id('login.email')
temp.send_keys("login")
logger.error('Jakiś Error')

driver.close()