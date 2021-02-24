package com.zestmoney.tests;

import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.zestmoney.pageobjects.AmazonHomePage;
import com.zestmoney.pageobjects.AmazonSearchResultsPage;
import com.zestmoney.pageobjects.AmazonSettingsPage;
import com.zestmoney.pageobjects.FlipkartHomePage;
import com.zestmoney.pageobjects.FlipkartLoginPage;
import com.zestmoney.pageobjects.FlipkartSearchResultsPage;
import com.zestmoney.utils.Utilities;

public class PriceComparision extends Utilities {
	public static WebDriver driver;
	String productName;
	String productNameinAmazon;
	String productNameinFlipkart;

	@BeforeClass
	public void setup() throws Exception {
		productName = getValueFromPropertiesFile("ProductName");
		productNameinAmazon = getValueFromPropertiesFile("ProductNameinAmazon");
		productNameinFlipkart = getValueFromPropertiesFile("ProductNameinFlipkart");
		driver = initiateDriver();
	}

	@Test
	public void doPriceComparision() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		AmazonHomePage amazonHomePage = new AmazonHomePage(driver);
		AmazonSettingsPage amazonSettingsPage = new AmazonSettingsPage(driver);
		AmazonSearchResultsPage amazonSearchResultsPage = new AmazonSearchResultsPage(driver);

		launchURL("https://amazon.com");
		amazonHomePage.getFlagIcon().click();
		selectDropDownByValue(amazonSettingsPage.getCurrencyDropDown(), "INR");
		amazonSettingsPage.getSaveChangesButton().click();
		amazonHomePage.getSearchBox().sendKeys(productName);
		amazonHomePage.getSearchIcon().click();
		scrollToElement(getElement(
				AmazonSearchResultsPage.DynamicLocators.displayingProducts.replaceAll("@@@@", productNameinAmazon)));
		wait.until(ExpectedConditions.elementToBeClickable(getElement(
				AmazonSearchResultsPage.DynamicLocators.displayingProducts.replaceAll("@@@@", productNameinAmazon))));
		getElement(AmazonSearchResultsPage.DynamicLocators.displayingProducts.replaceAll("@@@@", productNameinAmazon))
				.click();
		Double priceInAmazon = Double
				.parseDouble(amazonSearchResultsPage.getProductPrice().getText().replaceAll("[^0-9.]", ""));

		FlipkartLoginPage flipkartLoginPage = new FlipkartLoginPage(driver);
		FlipkartHomePage flipkartHomePage = new FlipkartHomePage(driver);
		FlipkartSearchResultsPage flipkartSearchResultsPage = new FlipkartSearchResultsPage(driver);

		launchURL("https://flipkart.com");
		if (flipkartLoginPage.getCloseButton().isDisplayed()) {
			flipkartLoginPage.getCloseButton().click();
		}
		flipkartHomePage.getSearchField().sendKeys(productName);
		flipkartHomePage.getSearchButton().click();
		scrollToElement(getElement(FlipkartSearchResultsPage.DynamicLocators.displayingProducts.replaceAll("@@@@",
				productNameinFlipkart)));
		wait.until(ExpectedConditions
				.elementToBeClickable(getElement(FlipkartSearchResultsPage.DynamicLocators.displayingProducts
						.replaceAll("@@@@", productNameinFlipkart))));
		getElement(
				FlipkartSearchResultsPage.DynamicLocators.displayingProducts.replaceAll("@@@@", productNameinFlipkart))
						.click();

		String parentWindowID = driver.getWindowHandle();
		Set<String> windowIDs = driver.getWindowHandles();
		for (String ID : windowIDs) {
			if (!ID.equals(parentWindowID)) {
				driver.switchTo().window(ID);
			}
		}
		Double priceInFlipkart = Double
				.parseDouble(flipkartSearchResultsPage.getProductPrice().getText().replaceAll("[^0-9.]", ""));

		System.out.println("Price In Amazon : " + priceInAmazon);
		System.out.println("Price In Flipkart : " + priceInFlipkart);

		if (priceInAmazon < priceInFlipkart) {
			System.out.println(productName + " has less price in Amazon");
		} else {
			System.out.println(productName + " has less price in Flipkart");
		}
	}

	@AfterClass
	public void tearDown() {
		closeBrowser();
	}
}
