package com.fourstay.step_definitions;

import java.util.List;

import javax.swing.DefaultButtonModel;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fourstay.pages.AccountPage;
import com.fourstay.pages.GeneralAccountPage;
import com.fourstay.pages.HomePage;
import com.fourstay.utilities.BrowserUtilities;
import com.fourstay.utilities.DBUtility;
import com.fourstay.utilities.Driver;
import com.fourstay.utilities.DBUtility.DBType;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

	
public class DataValidationStepDefs {
	WebDriver driver=Driver.getInstance();
	AccountPage accountPage=new AccountPage();
	GeneralAccountPage generalAccountP=new GeneralAccountPage();
	String actualName, expectedFirstName;
	String actualLastName, expectedLastName;
	String actualEmail, expectedEmail,capturedEmail;
	String actualPhoneNumber, expectedPhoneNumber,modifiedPhoneNumber;
	
	
	HomePage homePage=new HomePage();
	@When("^I am entering \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_am_entering_and(String arg1, String arg2) throws Throwable {
		Thread.sleep(5000);
	 capturedEmail=arg1.replaceAll("@testmail.com", "");
		homePage.email.sendKeys(arg1);
		homePage.password.sendKeys(arg2);
		
	}

	@When("^I click login button$")
	public void i_click_login_button() throws Throwable {
		homePage.loginBtn.click();
		BrowserUtilities.waitForPageLoad();
		
	 
	}

	@When("^I click Edit Profile$")
	public void i_click_Edit_Profile() throws Throwable {
//		Actions actions=new Actions(driver);
//		actions.moveToElement(accountPage.userAccount).perform();
		
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(accountPage.userAccount));
		accountPage.userAccount.click();
		wait.until(ExpectedConditions.visibilityOf(accountPage.editProfile));
		accountPage.editProfile.click();
		
	    
	}

	@When("^I capture first n, last n, email, phone$")
	public void i_capture_first_n_last_n_email_phone() throws Throwable {
		
		actualName=generalAccountP.accountFirstN.getAttribute("value");
		
		actualLastName=generalAccountP.accountLastN.getAttribute("value");
		actualEmail=generalAccountP.accountEmail.getAttribute("value");
		actualPhoneNumber=generalAccountP.accountPhone.getAttribute("value");
		modifiedPhoneNumber=actualPhoneNumber.replaceAll("\\.", "");
		
		System.out.println("First name :"+actualName+" LastName: "+actualLastName+" Email: "+actualEmail+" phone number: "+actualPhoneNumber);
		
	   Thread.sleep(5000);
	}

	@When("^I connect database and capture first n, last n, email, phone$")
	public void i_connect_database_and_capture_first_n_last_n_email_phone() throws Throwable {
		String query="SELECT first_name, last_name, phone_number, Lower(email) FROM employees";
		DBUtility.establishConnection(DBType.MYSQL);
		List<String[]> databaseValues=DBUtility.runSQLQuery(query);
		
		for (int i = 0; i < databaseValues.size(); i++) {
			if(databaseValues.get(i)[3].equals(capturedEmail)){
				
			expectedFirstName=databaseValues.get(i)[0];
			expectedLastName=databaseValues.get(i)[1];
			expectedPhoneNumber=databaseValues.get(i)[2];
			expectedEmail=databaseValues.get(i)[3];
			modifiedPhoneNumber=expectedPhoneNumber.replaceAll("\\.", "");
			
			}
		}
		DBUtility.closeConnections();
	 
	}

	@Then("^Verify the info from UI and DB are the same$")
	public void verify_the_info_from_UI_and_DB_are_the_same() throws Throwable {
		Assert.assertEquals(expectedFirstName, actualName);
		System.out.println(expectedFirstName+"====>"+ actualName);
		Assert.assertEquals(expectedEmail, capturedEmail);
		System.out.println(expectedEmail+"=====>"+capturedEmail);
		Assert.assertEquals(expectedLastName, actualLastName);
		System.out.println(expectedLastName+"====>"+ actualLastName);
		Assert.assertEquals(modifiedPhoneNumber, actualPhoneNumber);
		System.out.println(modifiedPhoneNumber+"====>"+actualPhoneNumber);
	}


}
