package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class HomePage {

	@FindBy(linkText="Organizations")
	private WebElement org;
	@FindBy(linkText="Contacts")
	private WebElement contact;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement Adminicon;
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement SignOutbtn;
	
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	public WebElement getAdminicon() {
		return Adminicon;
	}

	public WebElement getSignOutbtn() {
		return SignOutbtn;
	}

	public WebElement getOrg() {
		return org;
	}

	public WebElement getContact() {
		return contact;
	}
	public void orgClick(WebDriver driver) {
		 org.click();
	}
	public void contactClick(WebDriver driver) {
		 contact.click();
	}
	public void signOut(WebDriver driver) {
		WebDriverUtility weblib=new WebDriverUtility();
		weblib.mousemoveOnElement(driver,Adminicon);
	    SignOutbtn.click();
	}
}
