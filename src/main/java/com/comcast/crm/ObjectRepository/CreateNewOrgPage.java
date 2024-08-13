package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateNewOrgPage {

	@FindBy(name="accountname")
	private WebElement accountname;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	@FindBy(name="phone")
	private WebElement phone;
	
	@FindBy(name="accounttype")
	private WebElement accounttype;
	
	public CreateNewOrgPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public WebElement getAccountname() {
		return accountname;
	}
	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public WebElement getPhone() {
		return phone;
	}
	public WebElement getAccounttype() {
		return accounttype;
	}
	public void createNewOrg(String orgname) {
		accountname.sendKeys(orgname);
		savebtn.click();
	}
	public void createNewOrgWithPhone(String orgname,String Phone) {
		accountname.sendKeys(orgname);
		phone.sendKeys(Phone);
		savebtn.click();
	}
	public void createNewOrgWithIndustry(String orgname,String Type) {
		WebDriverUtility weblib= new WebDriverUtility();
		accountname.sendKeys(orgname);
		weblib.handlingDropdown(accounttype, Type);
		accounttype.sendKeys(Type);
		savebtn.click();
	}
	
}
