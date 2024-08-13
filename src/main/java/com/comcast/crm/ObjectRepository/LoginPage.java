package com.comcast.crm.ObjectRepository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(name="user_name")
	private WebElement username;
	@FindBy(name="user_password")
	private WebElement password;
	@FindBy(id="submitButton")
	private WebElement loginbtn;
	WebDriver driver;

	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	public void login(String Url, String Username, String Password) {
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.get(Url);
		driver.manage().window().maximize();
        username.sendKeys(Username);
        password.sendKeys(Password);
        loginbtn.click();
	}
}
