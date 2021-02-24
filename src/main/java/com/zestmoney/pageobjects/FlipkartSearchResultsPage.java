package com.zestmoney.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlipkartSearchResultsPage {

	WebDriver driver;

	public FlipkartSearchResultsPage(WebDriver driver) {
		this.driver = driver;
	}

	private By productPrice = By.xpath("//div[@class='_30jeq3 _16Jk6d']");

	public WebElement getProductPrice() {
		return driver.findElement(productPrice);
	}

	public static class DynamicLocators {

		public static String displayingProducts = "//div[contains(text(),'@@@@')]/parent::div/parent::div/parent::a";
	}
}
