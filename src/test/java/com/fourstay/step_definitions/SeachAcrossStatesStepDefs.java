package com.fourstay.step_definitions;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fourstay.pages.HomePage;
import com.fourstay.pages.SearchResultPage;
import com.fourstay.utilities.BrowserUtilities;
import com.fourstay.utilities.Driver;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class SeachAcrossStatesStepDefs {
	
	HomePage homePage= new HomePage();
	@Given("^I enter school name \"([^\"]*)\"$")
	public void i_enter_school_name(String school) throws Throwable {
	    
	    homePage.schoolName.sendKeys(school);
	}

	@Given("^I enter dates \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_dates_and(String startDate, String endDate) throws Throwable {
	    homePage.startDate.sendKeys(startDate);
	    homePage.endDate.sendKeys(endDate);
	}

	@When("^I click the search button$")
	public void i_click_the_search_button() throws Throwable {
		Thread.sleep(3000);
//		homePage.dialogx.click();
//		Thread.sleep(2000);
//		homePage.dialogx.click();
//		Thread.sleep(2000);
//		homePage.dialogx.click();
		homePage.search.click();
	
		Thread.sleep(5000);
		
	    
	}

	@Then("^the results should contain$")
	public void the_results_should_contain(List<String> states) throws Throwable {
	   BrowserUtilities.switchTabs("search");
	   BrowserUtilities.waitForPageLoad();
	   
	   SearchResultPage resultPage= new SearchResultPage();
	   Set<String> actualStates= new HashSet<>();
	   for(WebElement element : resultPage.allStates){
		   actualStates.add(element.getText());
	   }
	   
	   Assert.assertTrue(actualStates.containsAll(states));
	}
	@When("^I enter the search criteria$")
	public void i_enter_the_search_criteria(List<Map<String, String>> searchCriteria) throws Throwable {
	    Map<String, String> input= searchCriteria.get(0);
	    homePage.schoolName.sendKeys(input.get("school"));
	    homePage.startDate.sendKeys(input.get("start"));
	    homePage.endDate.sendKeys(input.get("end"));
	    Driver.getInstance().manage().window().maximize();
	    homePage.search.click();
	}
	

}
