package com.fourstay.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fourstay.utilities.Driver;

public class AccountPage {
	public AccountPage() {
		PageFactory.initElements(Driver.getInstance(), this);
	}
	@FindBy (xpath="(//a[@class='dropdown-toggle'])[3]")
	public WebElement userAccount;
	
	@FindBy(css = ".not-login")
	public WebElement loginLink;
	
	@FindBy(xpath = "//h3[@class='user-name ng-binding']")
	public WebElement userName;
	
	@FindBy(xpath = "(//img[@class='img-responsive xxs-margin'])[1]")
	public WebElement homePageButton;
	
	@FindBy(css=".user-name.ng-binding")
	public WebElement nameValue;
	
	@FindBy(linkText= "Edit Profile")
	public WebElement editProfile;

}
