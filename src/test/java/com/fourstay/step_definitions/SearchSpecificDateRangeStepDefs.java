package com.fourstay.step_definitions;

import java.util.Arrays;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fourstay.pages.HomePage;
import com.fourstay.utilities.BrowserUtilities;
import com.fourstay.utilities.ConfigurationReader;
import com.fourstay.utilities.Driver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchSpecificDateRangeStepDefs {
	HomePage homePage = new HomePage();
	WebDriver driver;

	@Given("^user is on the fourstay homepage$")
	public void user_is_on_the_fourstay_homepage() throws Throwable {
		Driver.getInstance().get(ConfigurationReader.getProperty("url"));

	}

	@When("^user specify the location,day in, day out and number of beds$")
	public void user_specify_the_location_day_in_day_out_and_number_of_beds() throws Throwable {

		homePage.schoolName.sendKeys("Georgetown");
		homePage.startDate.sendKeys("03/01/2018");
		homePage.endDate.sendKeys("03/02/2018");
		// Look at this step later - select the bed
		// homePage.themates.click();
		// Thread.sleep(2000);
		// homePage.bedNumber.click();
	}

	@When("^user click search$")
	public void user_click_search() throws Throwable {
		//Thread.sleep(6000);
		JavascriptExecutor jse = (JavascriptExecutor) Driver.getInstance();
	    jse.executeScript("window.scrollBy(0,500)", "");
	    
	  //  Driver.getInstance().switchTo().frame(Driver.getInstance().findElement(By.id("intercom-frame")));
	   // Driver.getInstance().findElement(By.cssSelector("div.intercom-borderless-dismiss-button")).click();
	    
	    
	    Thread.sleep(3000);
		homePage.search.click();

	}

	@Then("^Only those stays that meet all searching criteria should be listed on result page$")
	public void only_those_stays_that_meet_all_searching_criteria_should_be_listed_on_result_page() throws Throwable {
			
		
		BrowserUtilities.waitForPageLoad();
		
		//Thread.sleep(5000);
		BrowserUtilities.switchTabs("search");

//		System.out.println(Driver.getInstance().getCurrentUrl());

		String date = homePage.firstResult.getText();
		
		Thread.sleep(7000);
		homePage.firstResult.click();
		Thread.sleep(10000);
		

		System.out.println(Driver.getInstance().getCurrentUrl());
		//Scroll down the result page to see the availabel dates.
		JavascriptExecutor jse = (JavascriptExecutor) Driver.getInstance();
	    jse.executeScript("window.scrollBy(0,250)", "");
		
		System.out.println(homePage.firstDate.getText());
		System.out.println(homePage.secondDate.getText());
		int[] dateFrom = Arrays.stream(homePage.firstDate.getText().split("/")).mapToInt(Integer::parseInt).toArray();
		int[] dateTo = Arrays.stream(homePage.secondDate.getText().split("/")).mapToInt(Integer::parseInt).toArray();
		System.out.println(dateFrom[2]);
		System.out.println(dateTo[2]);
		System.out.println(dateFrom[2] + " " + dateTo[2]);
	
			Assert.assertTrue(dateFrom[0] >= 03);
		Assert.assertTrue(dateFrom[2] >= 2018);
		Assert.assertTrue(dateTo[0] >= 03);
		Assert.assertTrue(dateTo[2] >= 2018);
		
	
		
		

	}
		}



	
