package com.selenium.gettingstarted.pages;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Mailbox extends WebDriverPage {
	
	private final String EMAIL_OF_RECEIVER = "s12020@pjwstk.edu.pl";
	private final String EMAIL_SUBJECT = "Selenium test";
	/*private final String EMAIL_CONTENT = "Testing selenium - sending test message";*/
	

	public Mailbox(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	
	public void open() {
		get("https://nowy.tlen.pl/d/#/mails/?label=1");
		manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void sendNewMessage(){
		findElement(By.cssSelector("body > div.AppContainer.ng-scope > nh-top-bar > div > div.topbar__inner > nh-search > div > button"))
		.click();
		findElement(By.xpath("/html/body/div[1]/div/div[1]/div/form/div/div/div[1]/div[2]/nh-chips/div/div/div/input"))
		.sendKeys(EMAIL_OF_RECEIVER);
		findElement(By.xpath("/html/body/div[1]/div/div[1]/div/form/div/div/div[1]/div[2]/nh-chips/div/div/div/input"))
		.sendKeys(Keys.TAB);
		findElement(By.xpath("/html/body/div[1]/div/div[1]/div/form/div/div/div[1]/div[3]/div[2]/input"))
		.sendKeys(EMAIL_SUBJECT);
		/*findElement(By.xpath("/html/body/div")).click();
		findElement(By.xpath("/html/body/div"))
		.sendKeys(EMAIL_CONTENT);*/
		findElement(By.xpath("/html/body/div[1]/div/div[1]/div/form/div/div/div[2]/div[2]/div/div[1]/button"))
		.click();
		
		// clicks again to confirm sending empty message
		findElement(By.xpath("/html/body/div[1]/div/div[1]/div/form/div/div/div[2]/div[2]/div/div[1]/button"))
		.click();
		
	}
	
	
	
}
