package com.fourstay.step_definitions;

import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fourstay.pages.AccountPage;
import com.fourstay.pages.HomePage;
import com.fourstay.utilities.BrowserUtilities;
import com.fourstay.utilities.ConfigurationReader;
import com.fourstay.utilities.Driver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class StayTest3StepDefs {
	WebDriver driver = Driver.getInstance();
	HomePage homePage = new HomePage();
	String name, lastName;
	AccountPage accountPage=new AccountPage(); 

	@Given("^the user is on the FourStay sign up dialog$")
	public void the_user_is_on_the_FourStay_sign_up_dialog() throws Throwable {
		driver.get(ConfigurationReader.getProperty("url"));
		homePage.signUpButton.click();

	}

	@When("^the user enters enter first name \"([^\"]*)\" and last name \"([^\"]*)\"$")
	public void the_user_enters_enter_first_name_and_last_name(String nameFeature, String lastNameFeature) throws Throwable {
		name=nameFeature;
		lastName=lastNameFeature;
		homePage.FirstName.sendKeys(name);
		homePage.LastName.sendKeys(lastName);

	}

	@When("^the user enters any unregistered email and password$")
	public void the_user_enters_any_unregistered_email_and_password() throws Throwable {
		homePage.signUpEmail.sendKeys(randomEmail());
		homePage.passwordKey.sendKeys("12312331dd");
		
		Thread.sleep(5000);
		//
	}

	@When("^click on the Sign up button$")
	public void click_on_the_Sign_up_button() throws Throwable {
		homePage.signUpSubmit.click();
	}

	@When("^the user goes the account details page$")
	public void the_user_goes_the_account_details_page() throws Throwable {
		WebElement accountPageName=driver.findElement(By.xpath("// h3[@class='user-name ng-binding']"));
		BrowserUtilities.waitForPageLoad();
		String fullName=name+" "+lastName;
		Assert.assertTrue(accountPageName.isDisplayed());
		Assert.assertEquals(fullName, accountPage.nameValue.getText());

		
	}

	@Then("^first name \"([^\"]*)\" and last name \"([^\"]*)\" should be displayed in the right$")
	public void first_name_and_last_name_should_be_displayed_in_the_right(String arg1, String arg2) throws Throwable {
	accountPage.userAccount.click();
	Thread.sleep(1000);
	
	}

	public static String randomEmail() {
		String myEmail = LocalDateTime.now().toString().replaceAll("-", "").replaceAll(":", "").replaceAll("\\.", "");

		return " " + myEmail + "@gmail.com";
	}

	public static String randomKey() {
		String myKey = LocalDateTime.now().toString().replaceAll("-", "").replaceAll(":", "").replaceAll("\\.", "");

		return myKey;
	}

}
