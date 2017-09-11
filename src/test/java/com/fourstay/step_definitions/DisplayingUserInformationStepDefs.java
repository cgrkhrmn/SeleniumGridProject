package com.fourstay.step_definitions;

import org.junit.Assert;

import com.fourstay.pages.AccountPage;
import com.fourstay.pages.HomePage;
import com.fourstay.utilities.BrowserUtilities;
import com.fourstay.utilities.ConfigurationReader;
import com.fourstay.utilities.Driver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class DisplayingUserInformationStepDefs {
	HomePage homePage = new HomePage();
	
	@Given("^I am on the fourstay login dialog$")
	public void i_am_on_the_fourstay_login_dialog() throws Throwable {
		Driver.getInstance().get(ConfigurationReader.getProperty("url"));
		homePage.loginLink.click();

	}

	@Given("^I enter email \"([^\"]*)\"$")
	public void i_enter_email(String email) throws Throwable {
		Thread.sleep(2000);
		homePage.email.sendKeys(email);
	}

	@Given("^I enter password \"([^\"]*)\"$")
	public void i_enter_password(String password) throws Throwable {
		Thread.sleep(2000);
		homePage.password.sendKeys(password);
	}

	@When("^I click on the login button$")
	public void i_click_on_the_login_button() throws Throwable {
		Thread.sleep(2000);
		homePage.loginBtn.click();
	}

	@Then("^the user name should be \"([^\"]*)\"$")
	public void the_user_name_should_be(String username) throws Throwable {
		BrowserUtilities.waitForPageLoad();
		AccountPage accountPage=new AccountPage();
		String actual=accountPage.userName.getText();
		Assert.assertEquals(username, actual );
		System.out.println("Our expexted user name is "+username+" and the actual user name is "+actual);
	}

}
