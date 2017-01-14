package com.selenium.gettingstarted.pages;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearch extends WebDriverPage {


	public GoogleSearch(WebDriverProvider driverPovider) {
		super(driverPovider);
	}

	public void open() {
		get("https://www.google.pl");
		manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	private WebDriverWait wait = new WebDriverWait(this, 10);

	private void searchInGoogle(String query){
		navigate().to("https://www.google.pl");
		String cssOfInputField = "input[name='q']";
		WebElement inputFieldQ = wait
				.until(ExpectedConditions
						.elementToBeClickable(By.cssSelector(cssOfInputField)));
		inputFieldQ.sendKeys(query);

		String cssOfSearchButton = "button[name='btnG']";
		WebElement searchButton = wait
				.until(ExpectedConditions
						.elementToBeClickable(By.cssSelector(cssOfSearchButton)));
		searchButton.click();

	}

	public void searchForGraphic(String query) {
		searchInGoogle(query);
		String xPathOfGraphicTab = "//*[@id='hdtb-msb']/div[1]/div[2]/a";
		WebElement graphicTab = wait
				.until(ExpectedConditions
						.elementToBeClickable(By.xpath(xPathOfGraphicTab)));
		graphicTab.click();
	}

	public void searchAndNavigateToFirstResult(String query) {
		searchInGoogle(query);
		String xPathOfFirstResult = "//*[@id='rso']/div/div/div[1]/div/h3/a";
		WebElement firstResultLink = wait
				.until(ExpectedConditions
						.elementToBeClickable(By.xpath(xPathOfFirstResult)));
		String resultURL = firstResultLink.getAttribute("href");
		navigate().to(resultURL);
	}






}
