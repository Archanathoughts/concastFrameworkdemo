package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	@FindBy(name="user_name")
	private WebElement usernametxt;
	
	@FindBy(name="user_password")
	private WebElement passwordtxt;
	
	@FindBy(id="submitButton")
	private WebElement loginbtn; 
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsernametxt() {
		return usernametxt;
	}

	public WebElement getPasswordtxt() {
		return passwordtxt;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	/**
	 * login to apllication based on username and password
	 * @param username
	 * @param password
	 */
	
	public void loginToApp(String username,String password)
	{
		usernametxt.sendKeys(username);
		passwordtxt.sendKeys(password);
		loginbtn.click();
	}
	


}
