package com.fourstay.step_definitions;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fourstay.pages.AccountPage;
import com.fourstay.pages.HomePage;
import com.fourstay.pages.SearchResultPage;
import com.fourstay.utilities.BrowserUtilities;
import com.fourstay.utilities.ConfigurationReader;
import com.fourstay.utilities.Driver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PriceIsNotShownStepDefs {
	HomePage homePage = new HomePage();
	AccountPage accountPage= new AccountPage();
	SearchResultPage searchResult= new SearchResultPage();
	WebDriver driver;
	
	@Given("^as user, I am on the fourstay homepage$")
	public void as_user_I_am_on_the_fourstay_homepage() throws Throwable {
		Driver.getInstance().get(ConfigurationReader.getProperty("url"));
		Driver.getInstance().manage().window().maximize();
	   
	}

	@When("^i log in and make a search$")
	public void i_log_in_and_make_a_search() throws Throwable {
		homePage.loginLink.click();
		Thread.sleep(3000);

		homePage.email.sendKeys(ConfigurationReader.getProperty("guest.username"));
		Thread.sleep(3000);
		homePage.password.sendKeys(ConfigurationReader.getProperty("guest.password"));
		Thread.sleep(1000);
		homePage.loginBtn.click();
		WebDriverWait wait=new WebDriverWait(Driver.getInstance(),10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.se-pre-con")));
		accountPage.homePageButton.click();
		BrowserUtilities.waitForPageLoad();
		
		Thread.sleep(7000);
		//Search with the criteria
		homePage.schoolName.sendKeys("Georgetown");
		homePage.startDate.sendKeys("03/01/2018");
		homePage.endDate.sendKeys("03/02/2018");
		Thread.sleep(3000);
		JavascriptExecutor jse = (JavascriptExecutor) Driver.getInstance();
	    jse.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(3000);
		homePage.search.click();
		
	}

	@When("^when i see the results$")
	public void when_i_see_the_results() throws Throwable {
		BrowserUtilities.waitForPageLoad();
		BrowserUtilities.switchTabs("search");
		BrowserUtilities.waitForPageLoad();
		
		
	    
	}

	@Then("^each result should have a price tag$")
	public void each_result_should_have_a_price_tag() throws Throwable {
		int resultCount=searchResult.allResultsPrices.size();
		List<Integer> searchList = new ArrayList<Integer>();
		for(int i=0;i<resultCount;i++){
			searchList.add(Integer.valueOf(searchResult.allResultsPrices.get(i).getText().substring(1)) );
			Assert.assertTrue(searchList.get(i)>=0);
			System.out.println("The result "+i+" price is $"+searchList.get(i));
		
				
			}
		}
	}

