package com.selenium.gettingstarted;

import org.jbehave.web.selenium.WebDriverProvider;

import com.selenium.gettingstarted.pages.GoogleSearch;
import com.selenium.gettingstarted.pages.Home;
import com.selenium.gettingstarted.pages.Mailbox;


public class Pages {

	private WebDriverProvider driverProvider;
	
	//Pages
	private Home home;
	private Mailbox mailbox;
	private GoogleSearch google;
	// ...

	public Pages(WebDriverProvider driverProvider) {
		super();
		this.driverProvider = driverProvider;
	}

	public Home home() {
		if (home == null) {
			home = new Home(driverProvider);
		}
		return home;
	}
	
	public Mailbox mailbox() {
		if (mailbox == null) {
			mailbox = new Mailbox(driverProvider);
		}
		return mailbox;
	}
	
	public GoogleSearch google() {
		if (google == null) {
			google = new GoogleSearch(driverProvider);
		}
		return google;
	}

}
