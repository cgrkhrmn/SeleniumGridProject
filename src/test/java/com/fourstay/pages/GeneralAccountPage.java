package com.fourstay.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fourstay.utilities.Driver;

public class GeneralAccountPage {
	
	public GeneralAccountPage() {
		PageFactory.initElements(Driver.getInstance(), this);
	}
	@FindBy (css = "section input[ng-model='$parent.other.FirstName']")
	public WebElement accountFirstN;
	
	@FindBy (xpath = "//input[@ng-model='$parent.other.LastName']")
	public WebElement accountLastN;
	
	@FindBy (xpath = "//input[@ng-model='$parent.other.email']")
	public WebElement accountEmail;
	
	@FindBy (xpath = "//input[@ng-model='$parent.profile.general.phone']")
	public WebElement accountPhone;
	
	
	

}

