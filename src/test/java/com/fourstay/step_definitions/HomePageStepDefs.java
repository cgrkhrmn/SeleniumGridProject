package com.fourstay.step_definitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fourstay.utilities.ConfigurationReader;
import com.fourstay.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageStepDefs {
	WebDriver driver;

	@Given("^the user is on fourstay home page$")
	public void the_user_is_on_fourstay_home_page() throws Throwable {
//		System.setProperty("webdriver.chrome.driver", "/Users/cybertek/Documents/Libraries/drivers/chromedriver");
//		driver = new ChromeDriver();
//		driver.get("http://fourstay.herokuapp.com/");
		
	}

	@When("^the user clicks on the login link$")
	public void the_user_clicks_on_the_login_link() throws Throwable {
//		driver.findElement(By.cssSelector(".not-login")).click();;
		Driver.getInstance().get(ConfigurationReader.getProperty("url"));
		Assert.fail();
	}

	@Then("^the email field should be displayed$")
	public void the_email_field_should_be_displayed() throws Throwable {
//		System.out.println("Email field is now displayed");
//		Assert.assertTrue(driver.findElement(By.id("email")).isDisplayed());
	}

}
