package com.reskill.testscripts;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTHeaderFooter;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.reskill.actions.CheckButtonAction;
import com.reskill.actions.CheckElement;
import com.reskill.actions.CheckTextField;
import com.reskill.actions.LoginDetails;
import com.reskill.actionutility.SelectWebDriver;
import com.reskill.pages.CartPageLocators;
import com.reskill.pages.ProductPageLocators;
import com.reskill.pages.UserLoginPageLocators;

public class SauceDemoLoginTest {
	
	LoginDetails loginName = new LoginDetails();
			
	static Logger logger = Logger.getLogger(SauceDemoLoginTest.class);

	SelectWebDriver resDriver = new SelectWebDriver();
	

	CheckElement elementCheck = new CheckElement();

	UserLoginPageLocators userLoginPage = new UserLoginPageLocators();
	
	ProductPageLocators productPage = new ProductPageLocators();
	
	CartPageLocators cartPage = new CartPageLocators();

	CheckTextField textFiledCheck = new CheckTextField();

	CheckButtonAction buttonCheck = new CheckButtonAction();
	
	
	public WebDriver driver;


	@BeforeTest
	public void selectBrowser() {
		driver = resDriver.getDriver();
		resDriver.getUrl(driver);
	}

//	@Test
//	public void CheckUserNamesandPasswordTextPresent() {
//		
//		String acceptedUsernamesText = "Accepted usernames are:";
//		String standardUserText = "standard_user";
//		String lockedOutUserText = "locked_out_user";
//		String problemUserText = "problem_user";
//		String performanceGlitchUserText = "performance_glitch_user";
//		String passwordforallusersText = "Password for all users:";
//		String secretSauceText = "secret_sauce";
//		
//		String[] acceptedUsernamess = loginName.getLoginNameDetails(driver, By.xpath(userLoginPage.getLoginName()));
//		String[] passwordforallusers = loginName.getLoginNameDetails(driver, By.xpath(userLoginPage.getstandardPasswordlist()));
//		
//		Assert.assertEquals(acceptedUsernamesText, acceptedUsernamess[0], "Text Missmatched");
//		logger.info(acceptedUsernamess[0] + " Text is Present");
//		
//		Assert.assertEquals(standardUserText, acceptedUsernamess[1], "Text Missmatched");
//		logger.info(acceptedUsernamess[1] + " Text is Present");
//		
//		Assert.assertEquals(lockedOutUserText, acceptedUsernamess[2], "Text Missmatched");
//		logger.info(acceptedUsernamess[2] + " Text is Present");
//		
//		Assert.assertEquals(problemUserText, acceptedUsernamess[3], "Text Missmatched");
//		logger.info(acceptedUsernamess[3] + " Text is Present");
//		
//		Assert.assertEquals(performanceGlitchUserText, acceptedUsernamess[4], "Text Missmatched");
//		logger.info(acceptedUsernamess[4] + " Text is Present");
//			
//		Assert.assertEquals(passwordforallusersText, passwordforallusers[0], "Text Missmatched");
//		logger.info(passwordforallusers[0] + " Text is Present");
//		
//		Assert.assertEquals(secretSauceText, passwordforallusers[1], "Text Missmatched");
//		logger.info(passwordforallusers[1] + " Text is Present");
//	}
	
	@Test(priority = 1)
	public void validLoginTest() {
		textFiledCheck.enterText(driver, By.xpath(userLoginPage.getUserName()), userLoginPage.getUserLabel(), userLoginPage.getStandardUserName());
		textFiledCheck.enterText(driver, By.xpath(userLoginPage.getPassword()), userLoginPage.getuserPasswordLabel(), userLoginPage.getStandardPassword());
		buttonCheck.loginButton(driver, By.xpath(userLoginPage.getLoginButton()), userLoginPage.getLoginLable());	
	}

	String sauceLabsBackpackTitleText = "Sauce Labs Backpack";
	String sauceLabsBackpackDiscriptionText = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
	String sauceLabsBackpackPriceText = "$29.99";

	@Test(priority = 2)
	public void productVerification(){
		
		buttonCheck.loginButton(driver, By.xpath(productPage.getProductImage1()), productPage.getSauceLabsBackpackLabel());
		
		String sauceLabsBackpackTitleGetText = driver.findElement(By.xpath(productPage.getSauceLabsBackpackProductTitle())).getText();
		Assert.assertEquals(sauceLabsBackpackTitleText, sauceLabsBackpackTitleGetText, "Text NOT matched");
		logger.info(sauceLabsBackpackTitleGetText + " Text is Present");
		
		String sauceLabsBackpackDiscriptionGetText = driver.findElement(By.xpath(productPage.getSauceLabsBackpackProductDiscription())).getText();
		Assert.assertEquals(sauceLabsBackpackDiscriptionText, sauceLabsBackpackDiscriptionGetText, "Text NOT matched");
		logger.info(sauceLabsBackpackDiscriptionGetText + " Text is Present");
		
		String sauceLabsBackpackDiscriptionPriceText = driver.findElement(By.xpath(productPage.getSauceLabsBackpackProductPrice())).getText();
		Assert.assertEquals(sauceLabsBackpackPriceText, sauceLabsBackpackDiscriptionPriceText, "Text NOT matched");
		logger.info(sauceLabsBackpackDiscriptionPriceText + " Text is Present");
		
		buttonCheck.loginButton(driver, By.xpath(productPage.getSauceLabsBackpackProductAddToCart()), productPage.getSauceLabsBackpackLabel());
//		buttonCheck.loginButton(driver, By.xpath(productPage.getSauceLabsBackpackProductRemoveFromCart()), productPage.getRemoveFromCartLabel());
		buttonCheck.loginButton(driver, By.xpath(productPage.getproductBackButton()), productPage.getBackToProcductLabel());
		buttonCheck.loginButton(driver, By.xpath(productPage.getAddCartImage()), productPage.getcartImageLabel());
		
	}
	
	@Test(priority = 3)
	public void verifyProductInCart(){
		String cartText = "YOUR CART";
		String cartQty = "QTY";
		String cartDes = "DESCRIPTION";
		
		
		String getHeaderText = driver.findElement(By.xpath(cartPage.getHeaderTextCart())).getText();
		Assert.assertEquals(cartText, getHeaderText, "Text NOT Matched");
		logger.info(getHeaderText + " Text is Present");
		
		String getQtyHeaderTextCart = driver.findElement(By.xpath(cartPage.getQtyHeaderText())).getText();
		Assert.assertEquals(cartQty, getQtyHeaderTextCart, "Text NOT Matched");
		logger.info(getQtyHeaderTextCart + " Text is Present");
		
		String getDiscriptioHeaderTextCart = driver.findElement(By.xpath(cartPage.getDiscriptioHeaderText())).getText();
		Assert.assertEquals(cartDes, getDiscriptioHeaderTextCart, "Text NOT Matched");
		logger.info(getDiscriptioHeaderTextCart + " Text is Present");
		
		String getSauceLabsBackpackCartLabelText = driver.findElement(By.xpath(cartPage.getSauceLabsBackpackCartLabel())).getText();
		Assert.assertEquals(sauceLabsBackpackTitleText, getSauceLabsBackpackCartLabelText, "Text NOT Matched");
		logger.info(getSauceLabsBackpackCartLabelText + " Text is Present");
		
		String getSauceLabsBackpackCartDiscriptionText = driver.findElement(By.xpath(cartPage.getSauceLabsBackpackCartDiscription())).getText();
		Assert.assertEquals(sauceLabsBackpackDiscriptionText, getSauceLabsBackpackCartDiscriptionText, "Text NOT Matched");
		logger.info(getSauceLabsBackpackCartDiscriptionText + "Text is Present");
		
		String getSauceLabsBackpackCartPriceText = driver.findElement(By.xpath(cartPage.getSauceLabsBackpackCartPrice())).getText();
		Assert.assertEquals(sauceLabsBackpackPriceText, getSauceLabsBackpackCartPriceText, "Text NOT Matched");
		logger.info(getSauceLabsBackpackCartPriceText + " Text is Present");
	
		buttonCheck.loginButton(driver, By.xpath(cartPage.getSauceLabsBackpackCartCheckout()), cartPage.getcheckoutCartLabel());
	}
	
	public void checkOut() {
		
		
	}
	
	
//	@AfterTest
//	public void closeDriver() {
//		resDriver.closeBrowser(driver);
//	}

}
