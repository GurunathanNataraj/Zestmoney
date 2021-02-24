package com.zestmoney.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlipkartHomePage {

	WebDriver driver;

	public FlipkartHomePage(WebDriver driver) {
		this.driver = driver;
	}

	private By searchField = By.xpath("//input[@title='Search for products, brands and more']");
	private By searchButton = By.xpath("//button[@type='submit']");

	public WebElement getSearchField() {
		return driver.findElement(searchField);
	}

	public WebElement getSearchButton() {
		return driver.findElement(searchButton);
	}

}
