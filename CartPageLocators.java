package com.reskill.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CartPageLocators {
	
static Logger logger = LogManager.getLogger(UserLoginPageLocators.class);
	
	public Properties readProductPropertiesFile() {
		
		FileInputStream prodlocator = null;
		Properties pordProperties = null;
		try {
			prodlocator = new FileInputStream("src/main/java/com/reskill/locators/cartPage.properties");
			pordProperties = new Properties();
			pordProperties.load(prodlocator);
		} catch (FileNotFoundException e) {
			logger.error("File Not Found");
		} catch (IOException e) {
			logger.error("IOException");
		}
		return pordProperties;
	}
	
	
	public String getHeaderTextCart() {
		return readProductPropertiesFile().getProperty("headerTextCart");
	}
	
	public String getQtyHeaderText() {
		return readProductPropertiesFile().getProperty("qtyHeaderText");
	}
	
	public String getDiscriptioHeaderText() {
		return readProductPropertiesFile().getProperty("discriptioHeaderText");
	}
	
	public String getSauceLabsBackpackCartLabel() {
		return readProductPropertiesFile().getProperty("sauceLabsBackpackCartLabel");
	}
	
	public String getSauceLabsBackpackCartDiscription() {
		return readProductPropertiesFile().getProperty("sauceLabsBackpackCartDiscription");
	}
	
	public String getSauceLabsBackpackCartPrice() {
		return readProductPropertiesFile().getProperty("sauceLabsBackpackCartPrice");
	}
	
	public String getSauceLabsBackpackCartContinueShoping() {
		return readProductPropertiesFile().getProperty("sauceLabsBackpackCartContinueShoping");
	}
	
	public String getSauceLabsBackpackCartCheckout() {
		return readProductPropertiesFile().getProperty("sauceLabsBackpackCartCheckout");
	}

	public String getcheckoutCartLabel() {
		return readProductPropertiesFile().getProperty("checkoutCart");
	}
}
