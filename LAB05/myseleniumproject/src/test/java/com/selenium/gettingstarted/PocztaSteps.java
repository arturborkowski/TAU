package com.selenium.gettingstarted;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;

public class PocztaSteps {
	
	private final Pages pages;

	public PocztaSteps(Pages pages) {
		this.pages = pages;
	}
	
	@Given("user is on Home page")
    public void userIsOnHomePage(){        
        pages.home().open();        
    }
 
    @When("user logs in using credentials")
    public void userLogsIn(){        
        pages.home().enterCredentialsAndLogin();
    }
 
    @Then("received messages are shown")
    public void mailboxIsShown(){
       WebElement e = pages.home().findElement(By.xpath("//*[@id='folder-1']/div[2]"));
       assertNotNull(e);
    }
    
    @Given("user is in mailbox")
    public void userIsInMailbox(){
    	pages.mailbox().open();
    }
    
    @When("user sends a message")
    public void sendMessage() {
    	pages.mailbox().sendNewMessage();
    }
    
    @Then("received view is displayed")
    public void receivedIsDisplayed(){
    	WebElement e = pages.home().findElement(By.cssSelector("body > div.AppContainer.ng-scope > div > div.AppMain > div > div > div > div.list-stream-actions__wrap.ng-scope > div > div > div.list-stream-actions__name > span:nth-child(1)"));
    	assertNotNull(e);
    }
    
    @Given("user in on Google search page")
    public void userIsInGoogle(){
    	pages.google().open();
    }
    
    @When("user searches for graphics by a value $query")
    public void userSearchesForAValue(String query) {
    	pages.google().searchForGraphic(query);
    }
    
    @Then("graphic tab is active")
    public void graphicTabIsActive(){
    	WebElement e = pages.google().findElement(By.cssSelector("#hdtb-msb > div:nth-child(1) > div.hdtb-mitem.hdtb-msel.hdtb-imb"));
    	assertNotNull(e);
    }
    
    @When("user searches for a value $query")
    public void userSearchesForResults(String query) {
    	pages.google().searchAndNavigateToFirstResult(query);
    }
    
    @Then("user is navigated out from Google")
    public void outFromGoogle(){
    	String title = pages.google().getTitle();
    	assertTrue(!title.toLowerCase().contains("google"));
    }
    

}
