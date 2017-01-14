package com.selenium.gettingstarted.pages;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

public class Home extends WebDriverPage {

	public Home(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	private final static String LOGIN_ELEMENT_ID = "login";
	private final static String PASSWORD_ELEMENT_ID = "pass";
	private final static String LOGIN = "towdeyukf";
	private final static String PASSWORD = "towdey";

	
	public void open() {
		get("http://poczta.o2.pl");
		manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void enterCredentialsAndLogin(){
		findElement(By.id(LOGIN_ELEMENT_ID)).sendKeys(LOGIN);
		findElement(By.id(PASSWORD_ELEMENT_ID)).sendKeys(PASSWORD);
		findElement(By.id(PASSWORD_ELEMENT_ID)).submit();
	}
	
}
