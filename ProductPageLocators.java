package com.reskill.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProductPageLocators {
	
	static Logger logger = LogManager.getLogger(UserLoginPageLocators.class);
	
	public Properties readProductPropertiesFile() {
		
		FileInputStream prodlocator = null;
		Properties pordProperties = null;
		try {
			prodlocator = new FileInputStream("src/main/java/com/reskill/locators/products.properties");
			pordProperties = new Properties();
			pordProperties.load(prodlocator);
		} catch (FileNotFoundException e) {
			logger.error("File Not Found");
		} catch (IOException e) {
			logger.error("IOException");
		}
		return pordProperties;
	}
	
	public String getKey(String key) {
		return (String) readProductPropertiesFile().get(key);
	}
	
	public String getProductImage1() {
		return readProductPropertiesFile().getProperty("productImage1");
	}
	
	public String getSauceLabsBackpackProductTitle() {
		return  readProductPropertiesFile().getProperty("sauceLabsBackpackProductTitle");
	}
	
	public String getSauceLabsBackpackProductDiscription() {
		return  readProductPropertiesFile().getProperty("sauceLabsBackpackProductDiscription");
	}
	
	public String getSauceLabsBackpackProductPrice() {
		return  readProductPropertiesFile().getProperty("sauceLabsBackpackProductPrice");
	}
	
	public String getSauceLabsBackpackProductAddToCart() {
		return  readProductPropertiesFile().getProperty("sauceLabsBackpackProductAddToCart");
	}
	
	public String getSauceLabsBackpackProductRemoveFromCart() {
		return  readProductPropertiesFile().getProperty("sauceLabsBackpackProductRemoveFromCart");
	}
	
	public String getproductBackButton() {
		return  readProductPropertiesFile().getProperty("productBackButton");
	}
	
	public String getSauceLabsBackpackLabel() {
		return  readProductPropertiesFile().getProperty("sauceLabsBackpackLabel");
	}
	
	public String getAddToCartLabel() {
		return  readProductPropertiesFile().getProperty("addToCartLabel");
	}
	
	public String getRemoveFromCartLabel() {
		return  readProductPropertiesFile().getProperty("removeFromCartLabel");
	}
	
	public String getBackToProcductLabel() {
		return  readProductPropertiesFile().getProperty("backToProcduct");
	}
	
	public String getAddCartImage() {
		return  readProductPropertiesFile().getProperty("addCartImage");
	}
	
	public String getcartImageLabel() {
		return  readProductPropertiesFile().getProperty("cartImageClick");
	}
}
