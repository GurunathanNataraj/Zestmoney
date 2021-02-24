package com.zestmoney.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlipkartLoginPage {

	WebDriver driver;

	public FlipkartLoginPage(WebDriver driver) {

		this.driver = driver;
	}

	private By closeButton = By
			.xpath("//span[text()='Enter Email/Mobile number']/parent::label/ancestor::div/parent::div/button");

	public WebElement getCloseButton() {
		return driver.findElement(closeButton);
	}

}
