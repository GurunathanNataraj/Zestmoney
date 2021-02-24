package com.zestmoney.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonHomePage {

	WebDriver driver;

	public AmazonHomePage(WebDriver driver) {
		this.driver = driver;
	}

	private By flagIcon = By.xpath("//span[contains(@class,'flag ')]");
	private By searchBox = By.id("twotabsearchtextbox");
	private By searchIcon = By.id("nav-search-submit-button");

	public WebElement getFlagIcon() {
		return driver.findElement(flagIcon);
	}

	public WebElement getSearchBox() {
		return driver.findElement(searchBox);
	}

	public WebElement getSearchIcon() {
		return driver.findElement(searchIcon);
	}

}
