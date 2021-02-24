package com.zestmoney.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonSettingsPage {

	WebDriver driver;

	public AmazonSettingsPage(WebDriver driver) {
		this.driver = driver;
	}

	private By currencyDropDown = By.id("icp-sc-dropdown");
	private By saveChangesButton = By.xpath("//span[contains(text(),'Save')]/parent::span[@class='a-button-inner']");

	public WebElement getCurrencyDropDown() {
		return driver.findElement(currencyDropDown);
	}

	public WebElement getSaveChangesButton() {
		return driver.findElement(saveChangesButton);
	}
}
