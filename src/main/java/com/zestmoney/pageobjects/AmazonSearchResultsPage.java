package com.zestmoney.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonSearchResultsPage {

	WebDriver driver;

	public AmazonSearchResultsPage(WebDriver driver) {
		this.driver = driver;
	}

	private By displayingProducts = By.xpath("//span[contains(text(),'@@@@')]/parent::a");
	private By productPrice = By.xpath("//tr[@id='priceblock_ourprice_row']/td[2]");

	public WebElement getDisplayingProducts() {
		return driver.findElement(displayingProducts);
	}

	public WebElement getProductPrice() {
		return driver.findElement(productPrice);
	}

	public static class DynamicLocators {

		public static String displayingProducts = "//span[contains(text(),'@@@@')]/parent::a";
	}
}
