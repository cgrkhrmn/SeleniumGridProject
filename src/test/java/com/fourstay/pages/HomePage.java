package com.fourstay.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fourstay.utilities.Driver;

public class HomePage {
	public HomePage() {
		PageFactory.initElements(Driver.getInstance(), this);
		
	}
	
	@FindBy(css = ".not-login")
	public WebElement loginLink;

	@FindBy(id = "email")
	public WebElement email;
	
	@FindBy(id = "key")
	public WebElement password;
	
	@FindBy(id = "btn-login")
	public WebElement loginBtn;	
	
	@FindBy(id = "iLocName")
	public WebElement schoolName;	
	
	@FindBy(id = "rentoutfrom2")
	public WebElement startDate;	
	
	@FindBy(id = "rentoutto2")
	public WebElement endDate;	
	
	@FindBy(id = "search")
	public WebElement search;	
	
	@FindBy(xpath="//div[@class='intercom-launcher-close-icon']")
	public WebElement dialogx;
	
	public WebElement themates;
	
	@FindBy(xpath="//a[@onclick='changeOpt('1')']")
	public WebElement bedNumber;
	
	@FindBy(xpath="(//h3[@class='ng-binding'])[1]")
	public WebElement firstResult;
	
	@FindBy(xpath="(//h5[@class='ng-binding'])[2]")
	public WebElement firstDate;
	
	@FindBy(xpath="(//h5[@class='ng-binding'])[3]")
	public WebElement secondDate;
	
	@FindBy (xpath="(//li[@class='btn menu btn-log zl-margin not-login'])[2]")
	public WebElement signUpButton;
	
	public WebElement FirstName;
	
	public WebElement LastName;
	
	public WebElement phone;
	
		
	@FindBy (css="#btn-signup")
	public WebElement signUpSubmit;
	
	@FindBy (xpath="(//input[@id='email'])[3]")
	public WebElement signUpEmail;
	
	@FindBy(xpath="(//input[@type='password'])[2]")
	public WebElement passwordKey;
}
